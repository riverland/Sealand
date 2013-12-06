package org.river.sealand.meta.plan;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.utils.SQLException;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 构建sql执行计划服务抽象基类
 * 
 * @author river
 * @since Nov 30, 2013
 */
public abstract class PlanService implements IPlanService {
	private static final Logger log = LoggerFactory.getLogger(PlanService.class);

	private final static ThreadLocal<ZooKeeper> zooKeeperLocal = new ThreadLocal<ZooKeeper>();

	/** zookeeper 服务器地址 */
	protected String zkHost;

	/** 连接超时时间 */
	protected int timeout;

	protected abstract void doPlan(ScheduleNode node, String connectionId) throws SQLException;

	@Override
	public void plan(ScheduleNode schedNode, String connectionId) throws Exception {
		ZooKeeper zk = this.getZooKeeper();
		this.doPlan(schedNode, connectionId);
		zk.close();
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
	protected String createNode(final String path, byte data[], List<ACL> acl, CreateMode createMode) throws SQLException {

		try {
			ZooKeeper zk = this.getZooKeeper();
			return zk.create(path, data, acl, createMode);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new SQLException("");
		}
	}

	/**
	 * <p>
	 * 在zookeeper上删除节点
	 * 
	 * @param path
	 * @param data
	 * @param acl
	 * @param createMode
	 * @throws SQLException
	 */
	protected void deleteNode(final String path) throws SQLException {
		try {
			ZooKeeper zk = this.getZooKeeper();
			Stat stat = zk.exists(path, null);
			if (stat != null) {
				zk.delete(path, stat.getVersion());
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
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
		if (zk == null || zk.getState() != States.CONNECTED) {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			zooKeeperLocal.set(zk);
		}
		return zk;
	}

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String host) {
		this.zkHost = host;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public enum PlanType {
		DQL("DQL");

		private String value;

		public String getValue() {
			return value;
		}

		private PlanType(String value) {
			this.value = value;
		}
	}
}
