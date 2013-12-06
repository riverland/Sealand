package org.river.sealand.meta.watcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.Task.Type;
import org.river.sealand.metainfo.task.TaskStatus;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 监听已经完成计划的Plan,并对可以分配的计划进行分配
 * 
 * @author river
 * @since Nov 30, 2013
 */
public class DQLPlanWatcher implements Watcher, ITaskWatcher, Runnable {
	private static final Logger log = LoggerFactory.getLogger(DQLPlanWatcher.class);

	/** DQL在zookeeper中的地址空间 */
	private String zkHost;
	private ZooKeeper zooKeeper;
	private Task task;
	private String taskPath;
	private List<ITaskWatcher> children;
	private ITaskWatcher parent;
	private boolean alive = true;
	private CountDownLatch latch = new CountDownLatch(1);
	private Object atom = new Object();
	private Map<Task.Type, ITaskAssigner> assignerMap = new HashMap<Task.Type, ITaskAssigner>();

	public DQLPlanWatcher(String zkHost, Map<Type, ITaskAssigner> assignerMap) {
		super();
		this.zkHost = zkHost;
		this.assignerMap = assignerMap;
	}

	/**
	 * <p>
	 * 任务监控初始化
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Override
	public void start() throws IOException, InterruptedException {
		this.boot();
		WatchThread watchThread = new WatchThread();
		watchThread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (atom) {
					atom.wait();
					TaskStatus status = this.updateStatus();
					if (status == TaskStatus.TO_ASSIGN) {
						this.assign(task);
					} else if (status == TaskStatus.COMMPLETED) {
						this.wakeUpParent();
					}
				}
			} catch (Throwable e) {
				log.error(e.getMessage());
			}
		}
	}

	/*
	 * 检查更新当前任务状态
	 * 
	 * @return
	 */
	private TaskStatus updateStatus() throws Exception {
		if (this.getPendingNum() > 0) {
			return this.getTaskStatus();
		}

		final String path = this.taskPath + "/" + TaskInfoPath.META_TASK_STATUS_PATH;

		Stat stat = zooKeeper.exists(path, false);
		zooKeeper.setData(path, TaskStatus.COMMPLETED.getValue().getBytes(), stat.getVersion());

		return TaskStatus.COMMPLETED;
	}

	/*
	 * 获取执行中的子任务数量
	 * 
	 * @return
	 */
	private int getPendingNum() throws KeeperException, InterruptedException {
		final String path = this.taskPath + "/" + TaskInfoPath.META_PENDING_NUM_PATH;
		byte[] data = zooKeeper.getData(path, null, null);
		return Integer.valueOf(new String(data));
	}

	/*
	 * 获取任务状态
	 * 
	 * @return
	 */
	private TaskStatus getTaskStatus() throws Exception {
		final String path = this.taskPath + "/" + TaskInfoPath.META_TASK_STATUS_PATH;
		byte[] data = this.zooKeeper.getData(path, null, null);
		String status = new String(data);
		return TaskStatus.fromValue(status);
	}

	@Override
	public void process(WatchedEvent event) {

		if (event.getType() == EventType.NodeDataChanged) {
			atom.notifyAll();
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
		zooKeeper = new ZooKeeper(zkHost, -1, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					latch.countDown();
					atom.notifyAll();
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
			while (alive) {
				try {
					if (zooKeeper == null || zooKeeper.getState() == States.CLOSED || zooKeeper.getState() == States.NOT_CONNECTED) {
						boot();
					} else {
						Thread.sleep(SLEEP_TIME);
					}
				} catch (Throwable e) {
					log.error(e.getMessage());
				}
			}
		}
	}

	@Override
	public void close() {
		alive = false;
		try {
			zooKeeper.close();
		} catch (InterruptedException e) {
			// TODO some logic
		}
	}

	@Override
	public void assign(Task task) throws SQLException {
		ITaskAssigner assigner = this.assignerMap.get(task.getType());
		assigner.assign(task, taskPath);
	}

	@Override
	public void wakeUpParent() {
		if (parent != null) {
			parent.wakeup();
		}
	}

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String zkHost) {
		this.zkHost = zkHost;
	}

	public void setParent(DQLPlanWatcher parent) {
		this.parent = parent;
	}

	@Override
	public void addChild(ITaskWatcher child) {
		this.children.add(child);
	}

	@Override
	public void setParent(ITaskWatcher parent) {
		this.parent = parent;
	}

	@Override
	public void wakeup() {
		this.atom.notifyAll();
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public void setTaskPath(String taskPath) {
		this.taskPath = taskPath;
	}

}
