package org.river.sealand.utils;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

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
	
	/**
	 * <p>
	 * 从指定地址获取整型数据
	 * @param zk
	 * @param path
	 * @return
	 */
	public static int getInt(ZooKeeper zk,String path,Stat stat){
		//TODO implements
		return 0;
	}
	
	/**
	 * <p>
	 * 从指定地址获取浮点型数据
	 * @param zk
	 * @param path
	 * @return
	 */
	public static int getDouble(ZooKeeper zk,String path,Stat stat){
		//TODO implements
		return 0;
	}
	
	/**
	 * <p>
	 * 从指定地址获取序列化对象
	 * @param zk
	 * @param path
	 * @param stat
	 * @return
	 */
	public static Object getObject(ZooKeeper zk,String path,Stat stat){
		//TODO implements
		return null;
	}

}
