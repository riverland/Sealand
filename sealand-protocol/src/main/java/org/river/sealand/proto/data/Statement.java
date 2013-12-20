package org.river.sealand.proto.data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * statement sql
 * 
 * @author river
 * @since Dec 18, 2013
 */
public class Statement {
	private String sql;

	private List<String> params = new ArrayList<String>();

	private String connectionId;

	private String transactionId;
	
	private String stmtId;

	public String getStmtId() {
		return stmtId;
	}

	public void setStmtId(String stmtId) {
		this.stmtId = stmtId;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public static enum Type {
		DQL('Q');

		public char value;

		private Type(char value) {
			this.value = value;
		}

	}

}
