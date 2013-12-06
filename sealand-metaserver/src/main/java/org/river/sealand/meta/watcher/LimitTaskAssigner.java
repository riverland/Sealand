package org.river.sealand.meta.watcher;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.task.LimitTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TransferTask;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据分页任务指派
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class LimitTaskAssigner extends TaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(LimitTaskAssigner.class);

	@Override
	public void assign(Task task, String taskPath) throws SQLException {
		if (task == null || StringUtils.isEmpty(taskPath)) {
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

		try {
			List<String> nodes = zooKeeper.getChildren(TaskInfoPath.NODE_SERVERS_PATH, null);
			this.setTaskMetaInfo(nodes.size(), taskPath);

			String childPath = taskPath + "/" + zooKeeper.getChildren(taskPath, null).get(0);
			Task limit = (Task) ObjectUtils.read(zooKeeper.getData(childPath, null, null));

			String limitNodePath = this.assignLimitTask4Waiting((LimitTask) task, taskPath);
			TransferTask transferTask = new TransferTask();
			transferTask.connectionId = task.connectionId;
			transferTask.dataId = limit.dataId;
			transferTask.destServers.add(limitNodePath);
			for (String tmp : nodes) {
				this.assign2Node(TaskInfoPath.NODE_SERVERS_PATH + "/" + tmp, limitNodePath, transferTask);
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
	private String assignLimitTask4Waiting(LimitTask task, String taskPath) throws KeeperException, InterruptedException {
		byte[] taskData = ObjectUtils.write(task);
		String nodePath = metaNodeInfoService.getLRUNode();
		final String waitTaskPath = nodePath + "/" + TaskInfoPath.NODE_WAITING_TASK_LIST_PATH + "/" + TaskInfoPath.NODE_TASK_PATH;
		String realWaitTaskPath = zooKeeper.create(waitTaskPath, taskData, null, CreateMode.PERSISTENT_SEQUENTIAL);
		zooKeeper.create(realWaitTaskPath + "/" + TaskInfoPath.NODE_TASK_DEST_PATH, taskPath.getBytes(), null, CreateMode.PERSISTENT);

		return realWaitTaskPath;
	}

	@Override
	protected void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		super.setTaskMetaInfo(pendingNum, taskPath);
		try {
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_TYPE_PATH, Task.Type.LIMIT.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}
}
