package org.river.sealand.jdbc.support;

import java.sql.SQLException;

/**
 * <p>
 * 执行sql指令的协议抽象
 * 
 * @author river
 * @since Dec 22, 2013
 */
public interface IStmtExecutor {

	/**
	 * <p>
	 * 执行sql查询
	 * 
	 * @param query
	 * @param params
	 * @param handler
	 * @param maxRows
	 * @param fetchSize
	 * @param flags
	 * @throws SQLException
	 */
	public void execute(IQuery query, IParams params, IResultHandler handler, int maxRows, int fetchSize, int flags) throws SQLException;
}
