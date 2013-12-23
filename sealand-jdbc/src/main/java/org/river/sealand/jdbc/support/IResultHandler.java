package org.river.sealand.jdbc.support;

import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * <p>
 * 协议返回回调接口
 * 
 * @author river
 * @since Dec 22, 2013
 */
public interface IResultHandler {

	/**
	 * 更新指令状态
	 * 
	 * @param status
	 * @param updateCount
	 */
	public void handleCommandStatus(String status, int updateCount);

	/**
	 * <p>
	 * 处理警告信息
	 * 
	 * @param warning
	 */
	public void handleWarning(SQLWarning warning);

	/**
	 * <p>
	 * 处理错误信息
	 * 
	 * @param error
	 */
	public void handleError(SQLException error);

	/**
	 * <p>
	 * 指令完成业务处理
	 * 
	 * @throws SQLException
	 */
	void handleCompletion() throws SQLException;
}
