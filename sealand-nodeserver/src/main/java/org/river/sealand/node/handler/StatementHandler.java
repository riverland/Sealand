package org.river.sealand.node.handler;

import org.river.sealand.proto.MSGConstant;
import org.river.sealand.proto.MsgType;
import org.river.sealand.proto.Version;
import org.river.sealand.proto.data.Statement;
import org.river.sealand.proto.pack.PackUtils;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * sql执行handler
 * 
 * @author river
 * @since Dec 18, 2013
 */
public class StatementHandler implements ISyncHandler {
	private static final Logger LOG = LoggerFactory.getLogger(StatementHandler.class);

	@Override
	public byte[] handle(byte[] data) {
		if (!this.needHandle(data)) {
			return null;
		}

		try {
			Statement stmt = PackUtils.unpack4stmt(data, Version.V1_0);
		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
			// TODO error logic
		}

		return null;
	}

	/*
	 * 判断是否需要处理数据
	 * 
	 * @param data
	 * 
	 * @return
	 */
	private boolean needHandle(byte[] data) {
		byte msgType = data[MSGConstant.MSG_TYPE_BYTE_INDEX];
		return MsgType.RAW_DATA.getValue() == msgType;
	}

}
