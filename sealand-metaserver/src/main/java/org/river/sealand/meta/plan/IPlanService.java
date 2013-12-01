package org.river.sealand.meta.plan;

import org.river.sealand.schedule.node.ScheduleNode;

/**
 * <p>
 * sql执行计划服务
 * 
 * @author river
 * @since Nov 30, 2013
 */
public interface IPlanService {

	/**
	 * <p>
	 * 生成计划
	 * 
	 * @param schedNode
	 * @throws Exception 
	 */
	public void plan(ScheduleNode schedNode) throws Exception;
}
