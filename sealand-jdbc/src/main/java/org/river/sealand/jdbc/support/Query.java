package org.river.sealand.jdbc.support;

/**
 * <p>
 * 查询对象
 * 
 * @author river
 * @since Dec 26, 2013
 */
public class Query implements IQuery {

	private String sql;

	private int paramCount;

	public Query(String sql) {
		this.sql = sql;
	}

	public Query(String sql, int paramCount) {
		this.sql = sql;
		this.paramCount = paramCount;
	}

	@Override
	public String getSql() {
		return this.sql;
	}

	@Override
	public int getParamsCount() {
		return paramCount;
	}

	@Override
	public boolean isStatementDescribed() {
		return false;
	}

}
