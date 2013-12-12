package org.river.sealand.meta.watcher;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.river.sealand.metainfo.task.HavingTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
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
			this.setTaskMetaInfo(1, taskPath);
			this.assignHavingTask((HavingTask) task, taskPath);
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
	 * @return 执行该节点地址
	 */
	private String assignHavingTask(HavingTask task, String taskPath) throws Exception {
		byte[] taskData = ObjectUtils.write(task);
		String nodePath = task.runNode.get(0);
		final String waitTaskPath = nodePath + "/" + TaskInfoPath.NODE_WAITING_TASK_LIST_PATH + "/" + TaskInfoPath.NODE_TASK_PATH;
		ZooKeeper zooKeeper = this.getZooKeeper();
		String realWaitTaskPath = zooKeeper.create(waitTaskPath, taskData, null, CreateMode.PERSISTENT_SEQUENTIAL);
		zooKeeper.create(realWaitTaskPath + "/" + TaskInfoPath.NODE_TASK_DEST_PATH, taskPath.getBytes(), null, CreateMode.PERSISTENT);

		return nodePath;
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
