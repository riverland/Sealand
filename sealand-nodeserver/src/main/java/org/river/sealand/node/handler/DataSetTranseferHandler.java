package org.river.sealand.node.handler;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.river.base.threads.impl.QueueHandlerAdaptor;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.node.data.IDataManager;
import org.river.sealand.node.data.MemDataSet;
import org.river.sealand.proto.MSGConstant;
import org.river.sealand.proto.MsgType;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.data.DataType;
import org.river.sealand.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据集转移处理器
 * 
 * @author river
 * @since Dec 12, 2013
 * @param <E>
 */
public class DataSetTranseferHandler extends QueueHandlerAdaptor<byte[]> {
	private static final Logger LOG = LoggerFactory.getLogger(DataSetTranseferHandler.class);
	private IDataManager dataManager;
	private String charset;

	@Override
	public void handle(DataEntity<byte[]> data) {
		if (!this.needHandle(data)) {
			return;
		}

		byte[] msg = data.getData();
		byte[] rs = Arrays.copyOfRange(msg, 4, msg.length);
		int pos = 0;

		byte dataIdLen = rs[0];
		String dataId = new String(Arrays.copyOfRange(rs, 1, dataIdLen));
		pos = +dataIdLen;

		byte[] lblLens = { rs[pos], rs[pos + 1] };
		int lblLen = NumberUtils.readInt2(lblLens);
		List<String> labels = this.buildLabels(rs, pos, lblLen);
		pos = +lblLen;

		int dataTypeLen = rs[pos];
		List<DataType> dataTypes = this.buildDataTypes(rs, pos, dataTypeLen);
		pos = +dataTypeLen;

		DataSet dataSet = this.dataManager.getDataSet(dataId);
		if (dataSet == null) {
			dataSet = new MemDataSet(labels, dataTypes);
		}

		for (int i = pos; i < rs.length;) {
			byte[] lens = { rs[i], rs[i + 1] };
			int rowLen = NumberUtils.readInt2(lens);
			byte[] rows = Arrays.copyOfRange(rs, 2, rowLen);
			i = +rowLen;
			try {
				dataSet.addRecord(new String(rows, charset));
			} catch (UnsupportedEncodingException e) {
				LOG.error(e.getLocalizedMessage(), e);
				// TODO 异常业务处理逻辑
			}
		}
		this.dataManager.putDataSet(dataId, dataSet);
		//TODO 多路数据情况下数据锁定
	}

	/*
	 * 构建表格表头数据
	 * 
	 * @param data
	 * 
	 * @param len
	 * 
	 * @return
	 */
	private List<String> buildLabels(byte[] data, int start, int len) {
		String lableStr = new String(Arrays.copyOfRange(data, start + 2, start + len));
		String[] lableArr = StringUtils.split(lableStr, MemDataSet.COL_SEPERATOR);
		List<String> labels = Arrays.asList(lableArr);
		return labels;
	}

	/*
	 * 构建表格表头数据
	 * 
	 * @param data
	 * 
	 * @param len
	 * 
	 * @return
	 */
	private List<DataType> buildDataTypes(byte[] data, int start, int len) {
		List<DataType> dataTypes = new ArrayList<DataType>();
		for (int i = start + 1; i < start + len; i++) {
			dataTypes.add(DataType.get((char) data[i]));
		}
		return dataTypes;
	}

	/*
	 * 判断是否需要处理数据
	 * 
	 * @param data
	 * 
	 * @return
	 */
	private boolean needHandle(DataEntity<byte[]> data) {
		byte[] msg = data.getData();
		byte msgType = msg[MSGConstant.MSG_TYPE_BYTE_INDEX];
		return MsgType.RAW_DATA.getValue() == msgType;
	}

	@Override
	public Class<?> getDataType() {
		return byte[].class;
	}

	public IDataManager getDataManager() {
		return dataManager;
	}

	public void setDataManager(IDataManager dataManager) {
		this.dataManager = dataManager;
	}

}
