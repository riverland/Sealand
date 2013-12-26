package org.river.sealand.jdbc.support;

import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * <p>
 * 对返回的协议信息进行处理
 * 
 * @author river
 * @since Dec 26, 2013
 */
public class ResultSetHandlerImpl implements IResultHandler {

	@Override
	public void handleCommandStatus(String status, int updateCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleWarning(SQLWarning warning) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleError(SQLException error) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCompletion() throws SQLException {
		// TODO Auto-generated method stub

	}

}
