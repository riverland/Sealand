package org.river.sealand.jdbc.support;

public interface IQuery {
	
	/**
	 * <p>
	 * 获取查询的sql
	 * @return
	 */
	public String getSql();
	
	/**
	 * <p>
	 * 获取参数数量
	 * @return
	 */
	public int getParamsCount();
	
	/**
	 * <p>
	 * 是否为描述性statement
	 * @return
	 */
	public boolean isStatementDescribed();
}
