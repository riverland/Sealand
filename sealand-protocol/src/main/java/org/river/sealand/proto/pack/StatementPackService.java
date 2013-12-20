package org.river.sealand.proto.pack;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.river.sealand.proto.MSGConstant;
import org.river.sealand.proto.data.Statement;
import org.river.sealand.utils.NumberUtils;

/**
 * <p>
 * statement 协议打包
 * 
 * @author river
 * @since Dec 18, 2013
 */
public class StatementPackService implements IPackService<Statement> {

	@Override
	public byte[] pack(Statement stmt) {
		byte[] connId = this.getString(stmt.getConnectionId());
		byte[] transactionId = this.getString(stmt.getTransactionId());
		byte[] stmtId = this.getString(stmt.getStmtId());
		byte[] sql = this.getString(stmt.getSql());

		List<String> params = stmt.getParams();
		byte[] paramByte = null;
		if (!params.isEmpty()) {
			paramByte = this.getParams(params);
		}
		int len = connId.length + transactionId.length + stmtId.length + sql.length + paramByte.length + MSGConstant.MSG_LEN_BYTE_NUM;
		byte[] lenByte = NumberUtils.writeInt4(len);
		byte[] result = ArrayUtils.addAll(lenByte, sql);

		return ArrayUtils.addAll(result, paramByte);
	}

	@Override
	public Statement unpack(byte[] data) {
		int pos = MSGConstant.MSG_LEN_BYTE_NUM;
		byte[] connIdLenByte = ArrayUtils.subarray(data, pos, MSGConstant.KEY_LEN_WIDTH);
		int connIdLen = NumberUtils.readInt2(connIdLenByte);
		pos = +MSGConstant.KEY_LEN_WIDTH;
		String connId = new String(ArrayUtils.subarray(data, pos, connIdLen));
		pos = +connIdLen;

		byte[] xaIdLenByte = ArrayUtils.subarray(data, pos, MSGConstant.KEY_LEN_WIDTH);
		int xaIdLen = NumberUtils.readInt2(xaIdLenByte);
		pos = +MSGConstant.KEY_LEN_WIDTH;
		String xaId = new String(ArrayUtils.subarray(data, pos, xaIdLen));
		pos = +xaIdLen;

		byte[] stmtIdLenByte = ArrayUtils.subarray(data, pos, MSGConstant.KEY_LEN_WIDTH);
		int stmtIdLen = NumberUtils.readInt2(stmtIdLenByte);
		pos = +MSGConstant.KEY_LEN_WIDTH;
		String stmtId = new String(ArrayUtils.subarray(data, pos, stmtIdLen));
		pos = +stmtIdLen;

		byte[] sqlLenByte = ArrayUtils.subarray(data, pos, MSGConstant.SQL_LEN_WIDTH);
		int sqlLen = NumberUtils.readInt2(sqlLenByte);
		pos = +MSGConstant.SQL_LEN_WIDTH;
		String sql = new String(ArrayUtils.subarray(data, pos, sqlLen));
		pos = +sqlLen;

		List<String> params = new ArrayList<String>();
		while (pos < data.length) {
			byte[] tmpLenByte = ArrayUtils.subarray(data, pos, MSGConstant.SQL_LEN_WIDTH);
			int tmpLen = NumberUtils.readInt2(tmpLenByte);
			pos = +MSGConstant.SQL_LEN_WIDTH;
			String tmp = new String(ArrayUtils.subarray(data, pos, tmpLen));
			params.add(tmp);
			pos = +tmpLen;
		}

		Statement stmt = new Statement();
		stmt.setConnectionId(connId);
		stmt.setTransactionId(xaId);
		stmt.setStmtId(stmtId);
		stmt.setSql(sql);
		stmt.setParams(params);
		return stmt;
	}

	/*
	 * 获取string的字节
	 * 
	 * @param str
	 * 
	 * @return
	 */
	private byte[] getString(String str) {
		byte[] sqlByte = str.getBytes();
		byte[] lenByte = NumberUtils.writeInt2(sqlByte.length);
		return ArrayUtils.addAll(sqlByte, lenByte);
	}

	/*
	 * 获取参数的字节
	 * 
	 * @param params
	 * 
	 * @return
	 */
	private byte[] getParams(List<String> params) {
		byte[] rs = null;
		for (String tmp : params) {
			rs = ArrayUtils.addAll(rs, this.getString(tmp));
		}
		return rs;
	}

}
