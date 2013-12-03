package org.river.sealand.meta.plan;

import org.apache.zookeeper.CreateMode;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.schedule.node.JoinNode;
import org.river.sealand.schedule.node.LimitNode;
import org.river.sealand.schedule.node.ScanNode;
import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.schedule.node.SortNode;
import org.river.sealand.utils.SQLException;
import org.river.sealand.utils.SQLException.Type;
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

	/** DQL在zookeeper中的地址空间 */
	private String dqlNamespace;

	@Override
	protected void doPlan(ScheduleNode node, String connectionId) throws SQLException {
		String conPath=dqlNamespace+"/"+connectionId;
		try{			
			createNode(conPath, PlanType.DQL.getValue().getBytes(), null, CreateMode.PERSISTENT);
			this.planTask(conPath, node, connectionId);	
		}catch(Throwable e){
			deleteNode(conPath);
		}
	
	}

	/*
	 * 生成计划任务树逻辑
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void planTask(String parentPath, ScheduleNode node, String connectionId) throws SQLException {
		switch (node.getNodeType()) {
		case SCAN: {
			this.buildScanTask(parentPath, (ScanNode) node, connectionId);
			break;
		}
		case LIMIT: {
			this.buildLimitTask(parentPath, (LimitNode) node, connectionId);
			break;
		}
		case SORT: {
			this.buildSortTask(parentPath, (SortNode) node, connectionId);
			break;
		}
		case HAVING:
		case AGGREGATE: {
			this.buildAggregateTask(parentPath, node, connectionId);
			break;
		}
		case JOIN: {
			this.buildJoinTask(parentPath, (JoinNode) node, connectionId);
			break;
		}
		default:{
			log.error("there is undefined task in connectionId["+connectionId+"]");
			throw new SQLException(Type.EXECUTE);
		}		

		}
	}

	/*
	 * 生成扫描任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildScanTask(String parentPath, ScanNode node, String connectionId) {
		ScanTask task = new ScanTask();
		task.sql = node.getSql();
	}

	/*
	 * 生成分页计算任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildLimitTask(String parentPath, LimitNode node, String connectionId) {

	}

	/*
	 * 生成排序计算任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildSortTask(String parentPath, SortNode node, String connectionId) {

	}

	/*
	 * 聚合任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildAggregateTask(String parentPath, ScheduleNode node, String connectionId) {

	}

	/*
	 * 连接任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildJoinTask(String parentPath, JoinNode node, String connectionId) {

	}
}
