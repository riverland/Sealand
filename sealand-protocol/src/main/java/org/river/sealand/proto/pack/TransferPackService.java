package org.river.sealand.proto.pack;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.river.sealand.proto.MSGConstant;
import org.river.sealand.proto.MsgType;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.data.DataType;
import org.river.sealand.sql.util.SQLUtils;
import org.river.sealand.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据传输包解压包服务实现
 * 
 * @author river
 * @since Dec 18, 2013
 */
public class TransferPackService implements IPackService {

	private static final Logger LOG = LoggerFactory.getLogger(TransferPackService.class);

	@Override
	public byte[] pack(DataSet dataset) {
		byte[] data = this.doDataSetMsgPack(dataset);
		int len = data.length + MSGConstant.MSG_LEN_BYTE_NUM + MSGConstant.MSG_TYPE_BYTE_LEN;
		byte[] result = new byte[len];
		byte[] msgLen = NumberUtils.writeInt4(len);
		for (int i = 0; i < msgLen.length; i++) {
			result[i] = msgLen[i];
		}
		result[MSGConstant.MSG_TYPE_BYTE_INDEX] = (byte) MsgType.TRANSFER.getValue();

		System.arraycopy(data, 0, result, MSGConstant.MSG_TYPE_BYTE_INDEX + 1, data.length);

		return result;
	}

	@Override
	public DataSet unpack(byte[] data) {
		return null;
	}

	/*
	 * 传输数据对象打包逻辑
	 * 
	 * @param dataset
	 * 
	 * @return
	 */
	private byte[] doDataSetMsgPack(DataSet dataset) {
		byte[] dataId = this.getDataId(dataset);
		byte[] dataType = this.getDataType(dataset);
		byte[] label = this.getLabel(dataset);
		byte[] data = this.getRecordData(dataset);
		byte[] result = ArrayUtils.addAll(dataId, dataType);
		result = ArrayUtils.addAll(result, label);
		result = ArrayUtils.addAll(result, data);
		return result;
	}

	/*
	 * 数据集collumn名数据
	 * 
	 * @param dataSet
	 * 
	 * @return
	 */
	private byte[] getLabel(DataSet dataSet) {
		List<String> label = dataSet.allColLables();
		byte[] labelData = SQLUtils.buildSelectList(label).getBytes();
		int lblLen = labelData.length + MSGConstant.MSG_RECORD_LEN_LEN;
		byte[] lenData = NumberUtils.writeInt2(lblLen);
		return ArrayUtils.addAll(lenData, labelData);
	}

	/*
	 * 获取数据类型数据
	 * 
	 * @param dataSet
	 * 
	 * @return
	 */
	private byte[] getDataType(DataSet dataSet) {
		List<DataType> dataType = dataSet.getCollumnDataType();
		byte[] data = new byte[dataType.size()];
		for (int i = 0; i < dataType.size(); i++) {
			data[i] = (byte) dataType.get(i).getValue();
		}
		int typeLen = data.length + MSGConstant.MSG_RECORD_LEN_LEN;
		byte[] lenData = NumberUtils.writeInt2(typeLen);
		return ArrayUtils.addAll(lenData, data);
	}

	/*
	 * 获取数据ID
	 * 
	 * @param dataSet
	 * 
	 * @return
	 */
	private byte[] getDataId(DataSet dataSet) {
		String conId = dataSet.getConnectionId();
		String xaId = dataSet.getTransactionId();
		String dataId = dataSet.getAlias();
		String cat = conId + MSGConstant.DATA_ID_SEPERATE + xaId + MSGConstant.DATA_ID_SEPERATE + dataId;
		byte[] data = cat.getBytes();
		byte[] len = NumberUtils.writeInt2(data.length);
		return ArrayUtils.addAll(len, data);
	}

	/*
	 * 获取记录数据
	 * 
	 * @param dataSet
	 * 
	 * @return
	 */
	private byte[] getRecordData(DataSet dataSet) {
		List<String> records = dataSet.getRecords();
		byte[] rs = null;
		for (String rec : records) {
			rs = ArrayUtils.addAll(rs, this.getRecordItem(rec));
		}
		return rs;
	}

	/*
	 * 获取记录单位
	 * 
	 * @param item
	 * 
	 * @return
	 */
	private byte[] getRecordItem(String item) {
		byte[] data = item.getBytes();
		byte[] len = NumberUtils.writeInt2(data.length);
		return ArrayUtils.addAll(len, data);
	}

}
