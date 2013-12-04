package org.river.sealand.meta.plan;

import org.apache.zookeeper.CreateMode;
import org.river.sealand.metainfo.task.AggregateTask;
import org.river.sealand.metainfo.task.JoinTask;
import org.river.sealand.metainfo.task.LimitTask;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.metainfo.task.SortTask;
import org.river.sealand.metainfo.task.TaskUtils;
import org.river.sealand.schedule.node.AggregateNode;
import org.river.sealand.schedule.node.HavingNode;
import org.river.sealand.schedule.node.JoinNode;
import org.river.sealand.schedule.node.LimitNode;
import org.river.sealand.schedule.node.ScanNode;
import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.schedule.node.ScheduleNode.NodeType;
import org.river.sealand.schedule.node.SortNode;
import org.river.sealand.sql.util.SQLUtils;
import org.river.sealand.utils.ObjectUtils;
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
	private String dqlPlanNameSpace;

	@Override
	protected void doPlan(ScheduleNode node, String connectionId) throws SQLException {
		String conPath = dqlPlanNameSpace + "/" + connectionId;
		try {
			createNode(conPath, connectionId.getBytes(), null, CreateMode.PERSISTENT);
			this.planTask(conPath, node, connectionId);
			createNode(conPath+"/"+PlanService.PLAN_TYPE_PATH, PlanType.DQL.getValue().getBytes(), null, CreateMode.PERSISTENT);
			createNode(conPath+"/"+PlanService.STATUS_PLANNED, STATUS_PLANNED.toString().getBytes(), null, CreateMode.PERSISTENT);			
		} catch (Throwable e) {
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
		default: {
			log.error("there is undefined task in connectionId[" + connectionId + "]");
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
	private void buildScanTask(String parentPath, ScanNode node, String connectionId) throws SQLException {
		ScanTask task = new ScanTask();
		task.sql = node.getSql();
		task.taskId = TaskUtils.genTaskId();
		task.dataId = node.getAlias();
		task.resultFields=node.getFields();
		task.isGlobal=node.isGlobal();
		task.tables=node.getTables();
		byte[] taskData=ObjectUtils.write(task);
		createNode(parentPath+"/"+task.taskId, taskData, null, CreateMode.PERSISTENT);
	}

	/*
	 * 生成分页计算任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildLimitTask(String parentPath, LimitNode node, String connectionId) throws SQLException {
		LimitTask task=new LimitTask();
		task.start=node.getStart();
		task.offset=node.getOffset();
		task.taskId = TaskUtils.genTaskId();
		task.dataId = node.getAlias();
		task.resultFields=node.getFields();
		
		byte[] taskData=ObjectUtils.write(task);
		String path=parentPath+"/"+task.taskId;
		createNode(path, taskData, null, CreateMode.PERSISTENT);
		this.planTask(path, node.getSrcNodes().get(0), connectionId);
		
	}

	/*
	 * 生成排序计算任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildSortTask(String parentPath, SortNode node, String connectionId) throws SQLException {
		SortTask task=new SortTask();
		task.orderBy=node.getSorts();
		task.taskId = TaskUtils.genTaskId();
		task.dataId = node.getAlias();
		task.resultFields=node.getFields();
		
		byte[] taskData=ObjectUtils.write(task);
		String path=parentPath+"/"+task.taskId;
		createNode(path, taskData, null, CreateMode.PERSISTENT);
		this.planTask(path, node.getSrcNodes().get(0), connectionId);
	}

	/*
	 * 聚合任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildAggregateTask(String parentPath, ScheduleNode node, String connectionId) throws SQLException {
		AggregateTask task=new AggregateTask();
		if(node.getNodeType()==NodeType.HAVING){
			task.havings=((HavingNode)node).getHavings();
			node=node.getSrcNodes().get(0);
		}
		
		if(node.getNodeType()==NodeType.AGGREGATE){
			task.groupBy=SQLUtils.buildSelectList(((AggregateNode)node).getGroupBy());
		}
			
		task.taskId = TaskUtils.genTaskId();
		task.dataId = node.getAlias();
		task.resultFields=node.getFields();
		
		byte[] taskData=ObjectUtils.write(task);
		String path=parentPath+"/"+task.taskId;
		createNode(path, taskData, null, CreateMode.PERSISTENT);
		this.planTask(path, node.getSrcNodes().get(0), connectionId);
	}
	

	/*
	 * 连接任务
	 * 
	 * @param node
	 * 
	 * @return
	 */
	private void buildJoinTask(String parentPath, JoinNode node, String connectionId) throws SQLException {
		JoinTask task=new JoinTask();
		task.on=node.getOn();
		task.taskId = TaskUtils.genTaskId();
		task.dataId = node.getAlias();
		task.resultFields=node.getFields();
		
		byte[] taskData=ObjectUtils.write(task);
		String path=parentPath+"/"+task.taskId;
		createNode(path, taskData, null, CreateMode.PERSISTENT);
		
		this.planTask(path, node.getSrcNodes().get(0), connectionId);
	}
}
