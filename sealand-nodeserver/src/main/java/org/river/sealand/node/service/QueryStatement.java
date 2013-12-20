package org.river.sealand.node.service;

import org.river.sealand.proto.data.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 查询指令执行服务接口实现
 * @author river
 * @since  Dec 20, 2013
 */
public class QueryStatement implements IStatementService {
	
	private static final Logger LOG=LoggerFactory.getLogger(QueryStatement.class);
	
	@Override
	public byte[] execute(Statement stmt) {
		return null;
	}

}
