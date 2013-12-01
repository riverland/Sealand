package org.river.sealand.meta.plan;

import org.river.sealand.schedule.node.ScheduleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 查询sql计划
 * 
 * @author river
 * @since Nov 30, 2013
 */
public class DQLPlanService extends PlanService {
	private static final Logger log = LoggerFactory.getLogger(DQLPlanService.class);
	
	/**DQL在zookeeper中的地址空间*/
	private String dqlNamespace;
	
	@Override
	protected void doPlan(ScheduleNode node) {
		
	}
}
