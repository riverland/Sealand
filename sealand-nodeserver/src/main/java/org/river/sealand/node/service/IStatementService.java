package org.river.sealand.node.service;

import org.river.sealand.proto.data.Statement;

/**
 * <p>
 * sql指令执行接口
 * @author river
 * @since  Dec 20, 2013
 */
public interface IStatementService {
	
	/**
	 * <p>
	 * 执行sql指令
	 * @param stmt
	 * @return
	 */
	public byte[] execute(Statement stmt);
}
