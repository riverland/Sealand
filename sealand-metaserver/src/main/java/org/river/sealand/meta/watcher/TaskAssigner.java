package org.river.sealand.meta.watcher;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.river.sealand.metainfo.IMetaNodeInfoService;
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
