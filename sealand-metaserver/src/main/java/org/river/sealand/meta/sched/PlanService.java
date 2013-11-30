package org.river.sealand.meta.sched;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 构建sql执行计划服务抽象基类
 * 
 * @author river
 * @since Nov 30, 2013
 */
public abstract class PlanService implements IPlanService, Watcher {
	private static final Logger log = LoggerFactory.getLogger(PlanService.class);

	public final static ThreadLocal<ZooKeeper> zooKeeper = new ThreadLocal<ZooKeeper>();
	public final static ThreadLocal<CountDownLatch> connectedSigal = new ThreadLocal<CountDownLatch>();

	/** zookeeper 服务器地址 */
	private String host;

	/** 连接超时时间 */
	private int timeout;

	protected abstract void doPlan(ScheduleNode node);

	@Override
	public void plan(ScheduleNode schedNode) throws Exception {
		ZooKeeper zk = new ZooKeeper(host, timeout, this);
		CountDownLatch latch = new CountDownLatch(1);
		zooKeeper.set(zk);
		connectedSigal.set(latch);
		latch.await();
		this.doPlan(schedNode);
		zk.close();
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getState() == KeeperState.SyncConnected) {
			connectedSigal.get().countDown();
		}
	}

	/**
	 * <p>
	 * 在zookeeper上建立节点
	 * 
	 * @param path
	 * @param data
	 * @param acl
	 * @param createMode
	 * @throws SQLException
	 */
	protected void createNode(final String path, byte data[], List<ACL> acl, CreateMode createMode) throws SQLException {
		try {
			zooKeeper.get().create(path, data, acl, createMode);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new SQLException("");
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
