package org.river.sealand.utils;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

/**
 * <p>
 * zookeeper 相关工具类
 * 
 * @author river
 * @since Dec 6, 2013
 */
public class ZooKeeperUtils {

	/**
	 * <p>
	 * 获取一个zookeeper连接
	 * 
	 * @param host
	 * @param timeout
	 * @return
	 * @throws Exception
	 */
	public static ZooKeeper getZooKeeper(String host, long timeout) throws Exception {
		final CountDownLatch latch = new CountDownLatch(1);
		ZooKeeper zooKeeper = new ZooKeeper(host, -1, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					latch.countDown();
				}
			}
		});

		latch.await();
		return zooKeeper;
	}

}
