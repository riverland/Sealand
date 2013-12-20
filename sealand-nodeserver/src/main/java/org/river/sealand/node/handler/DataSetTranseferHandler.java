package org.river.sealand.node.handler;

import org.river.base.threads.impl.QueueHandlerAdaptor;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.node.data.IDataManager;
import org.river.sealand.proto.MSGConstant;
import org.river.sealand.proto.MsgType;
import org.river.sealand.proto.Version;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.pack.PackUtils;
import org.river.sealand.utils.SQLException;
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

	@Override
	public void handle(DataEntity<byte[]> data) {
		if (!this.needHandle(data)) {
			return;
		}

		byte[] msg = data.getData();

		try {
			// TODO 多路数据情况下数据锁定
			DataSet dataSet = PackUtils.unpack4Transfer(msg, Version.V1_0);
			String dataId = dataSet.getConnectionId() + MSGConstant.DATA_ID_SEPERATE + dataSet.getTransactionId() + MSGConstant.DATA_ID_SEPERATE + dataSet.getAlias();
			DataSet old = this.dataManager.getDataSet(dataId);
			if (old != null) {
				old.addAll(dataSet);
				dataSet = old;
			}

			this.dataManager.putDataSet(dataId, dataSet);
		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
			// TODO the error logic
		}

		data.setData(null);
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
