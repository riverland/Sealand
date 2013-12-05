package org.river.sealand.meta.watcher;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskStatus;
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
	private List<DQLPlanWatcher> children;
	private DQLPlanWatcher parent;
	private boolean alive = true;
	private CountDownLatch latch = new CountDownLatch(1);
	private Object atom = new Object();

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
					TaskStatus status=this.getTaskStatus();
					if(status==TaskStatus.TO_ASSIGN){
						this.assign(task);
					}else if(status==TaskStatus.COMMPLETED){
						this.wakeUpParent();
					}
				}
			} catch (Throwable e) {
				log.error(e.getMessage());
			}
		}
	}

	/*
	 * 获取任务状态
	 * 
	 * @return
	 */
	private TaskStatus getTaskStatus() throws Exception {
		final String path = this.taskPath + "/" + TaskInfoPath.TASK_STATUS_FOR_META_PATH;
		byte[] data = this.zooKeeper.getData(path, null, null);
		String status=new String(data);
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
	public void assign(Task task) {

	}

	@Override
	public void wakeUpParent() {
		if (parent != null) {
			parent.atom.notify();
		}
	}

}
