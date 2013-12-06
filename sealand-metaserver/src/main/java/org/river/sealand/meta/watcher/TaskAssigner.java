package org.river.sealand.meta.watcher;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.IMetaNodeInfoService;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskStatus;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.SQLException;
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

	protected ZooKeeper zooKeeper;
	protected CountDownLatch latch;

	protected String zkHost;
	protected IMetaNodeInfoService metaNodeInfoService;

	public void initialize() {
		new WatchThread().start();
	}

	@Override
	public void assign(Task task, String taskPath) throws SQLException {
		if (task == null || StringUtils.isEmpty(taskPath)) {
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

		try {
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
	protected void assign2Node(String nodePath, String destTaskPath, Task task) throws KeeperException, InterruptedException {
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
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_PENDING_NUM_PATH, String.valueOf(pendingNum).getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_RECORD_NUM_PATH, String.valueOf(0).getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_STATUS_PATH, TaskStatus.ASSIGNED.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}

	/*
	 * 启动ZooKeeper客户端
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 */
	private void boot() throws IOException, InterruptedException {
		latch = new CountDownLatch(1);
		zooKeeper = new ZooKeeper(zkHost, -1, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					latch.countDown();
				}
			}
		});

		latch.await();
	}

	/**
	 * <p>
	 * zookeeper alive监控线程
	 * 
	 * @author river
	 * @since Nov 30, 2013
	 */
	private class WatchThread extends Thread {
		final long SLEEP_TIME = 10 * 1000;

		@Override
		public void run() {
			while (true) {
				try {
					if (zooKeeper == null || zooKeeper.getState() == States.CLOSED || zooKeeper.getState() == States.NOT_CONNECTED) {
						boot();
					} else {
						Thread.sleep(SLEEP_TIME);
					}
				} catch (Throwable e) {
					LOG.error(e.getMessage());
				}
			}
		}
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
