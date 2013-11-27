package org.river.sealand.schedule;

import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.utils.DBType;

/**
 * <p>
 * SQL执行计划构建接口
 * 
 * @author river
 * @since Nov 27, 2013
 */
public interface IScheduleBuilder {
	
	/**
	 * <p>
	 * 构建SQL执行计划
	 * 
	 * @param sql
	 * @param dbType
	 * @return
	 */
	public ScheduleNode build(String sql, DBType dbType);
}
