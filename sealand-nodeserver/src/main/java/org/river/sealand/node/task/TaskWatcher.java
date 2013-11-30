package org.river.sealand.node.task;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.river.base.threads.IQueueHandlerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 监听本计算节点所有分派的任务
 * 
 * @author river
 * @since Nov 30, 2013
 */
public class TaskWatcher implements Watcher, Runnable {
	private static final Logger log = LoggerFactory.getLogger(TaskWatcher.class);

	private String taskPath;
	private IQueueHandlerManager<byte[]> queueManager;
	private ZooKeeper zooKeeper;
	private CountDownLatch latch = new CountDownLatch(1);
	private Object atom = new Object();

	/**
	 * <p>
	 * 任务监控初始化
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void initialize() throws IOException, InterruptedException {
		this.boot();
		WatchThread watchThread = new WatchThread();
		watchThread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				atom.wait();
				synchronized (atom) {
					zooKeeper.getChildren(taskPath, this, null);
				}
			} catch (Throwable e) {
				log.error(e.getMessage());
			}
		}
	}
	
	

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDataChanged) {
			atom.notifyAll();
		}
	}

	/*
	 * 启动ZooKeeper客户端
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void boot() throws IOException, InterruptedException {
		zooKeeper = new ZooKeeper(taskPath, -1, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					latch.countDown();
				}
			}
		});

		latch.await();
	}

	public String getTaskPath() {
		return taskPath;
	}

	public void setTaskPath(String taskPath) {
		this.taskPath = taskPath;
	}

	public IQueueHandlerManager<byte[]> getQueueManager() {
		return queueManager;
	}

	public void setQueueManager(IQueueHandlerManager<byte[]> queueManager) {
		this.queueManager = queueManager;
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
					log.error(e.getMessage());
				}
			}
		}
	}

}
