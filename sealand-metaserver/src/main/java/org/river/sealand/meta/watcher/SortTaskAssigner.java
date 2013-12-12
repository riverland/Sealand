package org.river.sealand.meta.watcher;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.river.sealand.metainfo.task.SortTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
import org.river.sealand.metainfo.task.TaskUtils;
import org.river.sealand.metainfo.task.TransferTask;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 排序任务指派
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class SortTaskAssigner extends TaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(SortTaskAssigner.class);

	@Override
	public void assign(Task task, String taskPath) throws SQLException {
		if (task == null || StringUtils.isEmpty(taskPath)) {
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			List<String> nodes = zooKeeper.getChildren(TaskInfoPath.NODE_SERVERS_PATH, null);
			this.setTaskMetaInfo(nodes.size(), taskPath);
			SortTask sort = (SortTask) task;

			String nodePath = metaNodeInfoService.getLRUNode();
			String realTaskPath = this.assignTask4Waiting(sort, taskPath);
			this.assginSplitTask(sort, nodes);
			this.assginTranseferTask(sort, nodes, nodePath, realTaskPath);
		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
			// TODO 添加异常编码定义
			throw new SQLException("");
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO 添加异常编码定义
			throw new SQLException("");
		}
	}

	/*
	 * 分配单节点聚合任务
	 * 
	 * @param task
	 * 
	 * @param nodes
	 */
	private void assginSplitTask(SortTask task, List<String> nodes) throws Exception {
		task.destTaskPath = "local";
		for (String tmp : nodes) {
			this.assign2Node(TaskInfoPath.NODE_SERVERS_PATH + "/" + tmp, task.taskPath, task);
		}
	}

	/*
	 * 分配传输任务
	 * 
	 * @param task
	 * 
	 * @param nodes
	 * 
	 * @param destNode
	 * 
	 * @throws Exception
	 */
	private void assginTranseferTask(SortTask task, List<String> nodes, String destNode, String destTaskPath) throws Exception {
		TransferTask transferTask = new TransferTask();
		transferTask.taskId = TaskUtils.genTaskId();
		transferTask.connectionId = task.connectionId;
		transferTask.dataId = task.dataId;
		transferTask.destServers.add(destNode);
		for (String tmp : nodes) {
			this.assign2Node(TaskInfoPath.NODE_SERVERS_PATH + "/" + tmp, destTaskPath, transferTask);
		}
	}

	/*
	 * 把aggregate归总任务分配到一个资源比较充裕的节点，并把该节点地址返回
	 * 
	 * @return 执行该
	 */
	private String assignTask4Waiting(SortTask task, String nodePath) throws Exception {
		byte[] taskData = ObjectUtils.write(task);
		final String waitTaskPath = nodePath + "/" + TaskInfoPath.NODE_PENDING_TASK_LIST_PATH + "/" + TaskInfoPath.NODE_TASK_PATH;
		ZooKeeper zooKeeper = this.getZooKeeper();
		zooKeeper.create(waitTaskPath, taskData, null, CreateMode.PERSISTENT_SEQUENTIAL);
		return nodePath;
	}

	@Override
	protected void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		super.setTaskMetaInfo(pendingNum, taskPath);
		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_TYPE_PATH, Task.Type.SORT.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}
}
