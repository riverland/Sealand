package org.river.sealand.jdbc.support;

import java.sql.SQLException;

import org.river.sealand.proto.IProtoStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 执行sql指令协议执行实现
 * 
 * @author river
 * @since Dec 25, 2013
 */
public class StmtExecutorImpl implements IStmtExecutor {
	private static final Logger log = LoggerFactory.getLogger(StmtExecutorImpl.class);
	private IProtoStream protoStream;

	private Object lock;

	@Override
	public void execute(IQuery query, IParams params, IResultHandler handler, int maxRows, int fetchSize, int flags) throws SQLException {

	}

	/*
	 * 等待执行锁 
	 * @throws SQLException
	 */
	private void waitOnLock() throws SQLException {
		//TODO implements
	}

}
