package org.river.sealand.schedule;

import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.utils.DBType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 执行计划构建接口默认实现
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class DefaultScheduleBuilder implements IScheduleBuilder {
	
	private static Logger log=LoggerFactory.getLogger(DefaultScheduleBuilder.class);

	
	
	@Override
	public ScheduleNode build(String sql, DBType dbType) {
		
		return null;
	}

}
