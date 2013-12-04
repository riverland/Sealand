package org.river.sealand.meta.watcher;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 监听已经完成计划的Plan,并对可以分配的计划进行分配
 * 
 * @author river
 * @since Nov 30, 2013
 */
public class DQLPlanWatcher implements Watcher, Runnable {
	private static final Logger log = LoggerFactory.getLogger(DQLPlanWatcher.class);

	/** DQL在zookeeper中的地址空间 */
	private String dqlPlanNamespace;
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
				synchronized (atom) {
					List<String> children = zooKeeper.getChildren(dqlPlanNamespace, this, null);
					if (children == null || children.isEmpty()) {
						atom.wait(1 * 1000);
						continue;
					}

					for (String tmp : children) {
						Stat stat = new Stat();
						String path = dqlPlanNamespace + "/" + tmp;
						byte[] data = zooKeeper.getData(path, null, stat);
						zooKeeper.delete(path, stat.getVersion());
						if (data == null) {
							continue;
						}

					}
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
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 */
	private void boot() throws IOException, InterruptedException {
		zooKeeper = new ZooKeeper(dqlPlanNamespace, -1, new Watcher() {
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
