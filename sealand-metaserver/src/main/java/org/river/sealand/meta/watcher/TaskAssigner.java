package org.river.sealand.meta.watcher;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.IMetaNodeInfoService;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskStatus;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.SQLException;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 任务分配接口抽象实现
 * 
 * @author river
 * @since Dec 5, 2013
 */
public abstract class TaskAssigner implements ITaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(TaskAssigner.class);
	private static final ThreadLocal<ZooKeeper> zooKeeperLocal = new ThreadLocal<ZooKeeper>();

	protected String zkHost;
	protected long timeout;
	protected IMetaNodeInfoService metaNodeInfoService;

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
			for (String tmp : nodes) {
				this.assign2Node(TaskInfoPath.NODE_SERVERS_PATH + "/" + tmp, taskPath, task);
			}

		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
			// TODO 添加异常编码定义
			throw new SQLException("");
		} catch (Exception e) {
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

	}

	/**
	 * 把执行任务分配到指定节点
	 * 
	 * @param nodePath
	 * 
	 * @param task
	 */
	protected void assign2Node(String nodePath, String destTaskPath, Task task) throws Exception {
		ZooKeeper zooKeeper = this.getZooKeeper();
		byte[] taskData = ObjectUtils.write(task);
		final String taskPath = nodePath + "/" + TaskInfoPath.NODE_PENDING_TASK_LIST_PATH + "/" + TaskInfoPath.NODE_TASK_PATH;
		final String realTaskPath = zooKeeper.create(taskPath, taskData, null, CreateMode.PERSISTENT_SEQUENTIAL);
		zooKeeper.create(realTaskPath + "/" + TaskInfoPath.NODE_TASK_DEST_PATH, destTaskPath.getBytes(), null, CreateMode.PERSISTENT);

		// 计算当前节点任务数
		byte[] taskNumData = zooKeeper.getData(nodePath + "/" + TaskInfoPath.NODE_PORT_PATH, null, null);
		String taskNumStr = new String(taskNumData);
		Integer taskNumInt = new Integer(taskNumStr);
		taskNumInt++;
		zooKeeper.create(nodePath + "/" + TaskInfoPath.NODE_PORT_PATH, taskNumInt.toString().getBytes(), null, CreateMode.PERSISTENT);
	}

	/**
	 * 设置任务计划中任务的元数据
	 * 
	 * @param pendingNum
	 */
	protected void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_PENDING_NUM_PATH, String.valueOf(pendingNum).getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_RECORD_NUM_PATH, String.valueOf(0).getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_STATUS_PATH, TaskStatus.ASSIGNED.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}

	/*
	 * 获取zooKeeper
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	protected ZooKeeper getZooKeeper() throws Exception {
		ZooKeeper zk = zooKeeperLocal.get();
		if (zk == null) {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			zooKeeperLocal.set(zk);
		}
		return zk;
	}

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String zkHost) {
		this.zkHost = zkHost;
	}

	public IMetaNodeInfoService getMetaNodeInfoService() {
		return metaNodeInfoService;
	}

	public void setMetaNodeInfoService(IMetaNodeInfoService metaNodeInfoService) {
		this.metaNodeInfoService = metaNodeInfoService;
	}

}
