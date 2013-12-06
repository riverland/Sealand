package org.river.sealand.meta.watcher;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.river.sealand.metainfo.task.HavingTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
import org.river.sealand.metainfo.task.TransferTask;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据聚合过滤任务指派
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class HavingTaskAssigner extends TaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(HavingTaskAssigner.class);

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

			String childPath = taskPath + "/" + zooKeeper.getChildren(taskPath, null).get(0);
			Task aggregate = (Task) ObjectUtils.read(zooKeeper.getData(childPath, null, null));

			String havingNodePath = this.assignHavingTask4Waiting((HavingTask) task, taskPath);
			TransferTask transferTask = new TransferTask();
			transferTask.connectionId = task.connectionId;
			transferTask.dataId = aggregate.dataId;
			transferTask.destServers.add(havingNodePath);
			for (String tmp : nodes) {
				this.assign2Node(TaskInfoPath.NODE_SERVERS_PATH + "/" + tmp, havingNodePath, transferTask);
			}

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
	 * 把havingNode分配到一个资源比较充裕的节点
	 * 
	 * @return
	 */
	private String assignHavingTask4Waiting(HavingTask task, String taskPath) throws Exception {
		byte[] taskData = ObjectUtils.write(task);
		String nodePath = metaNodeInfoService.getLRUNode();
		final String waitTaskPath = nodePath + "/" + TaskInfoPath.NODE_WAITING_TASK_LIST_PATH + "/" + TaskInfoPath.NODE_TASK_PATH;
		ZooKeeper zooKeeper = this.getZooKeeper();
		String realWaitTaskPath = zooKeeper.create(waitTaskPath, taskData, null, CreateMode.PERSISTENT_SEQUENTIAL);
		zooKeeper.create(realWaitTaskPath + "/" + TaskInfoPath.NODE_TASK_DEST_PATH, taskPath.getBytes(), null, CreateMode.PERSISTENT);

		return realWaitTaskPath;
	}

	@Override
	protected void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		super.setTaskMetaInfo(pendingNum, taskPath);
		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_TYPE_PATH, Task.Type.HAVING.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}
}
