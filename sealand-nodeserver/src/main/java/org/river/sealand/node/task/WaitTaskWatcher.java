package org.river.sealand.node.task;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;
import org.river.base.threads.IQueueHandlerManager;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
import org.river.sealand.node.NodeInfo;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 监听本计算节点所有分派的待激活任务
 * 
 * @author river
 * @since Nov 30, 2013
 */
public class WaitTaskWatcher implements Watcher, Runnable {
	private static final Logger log = LoggerFactory.getLogger(WaitTaskWatcher.class);

	private String zkHost;
	private long timeout;
	private IQueueHandlerManager<Task> queueManager;
	private ZooKeeper zooKeeper;
	private Object atom = new Object();

	/**
	 * <p>
	 * 任务监控初始化
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void initialize() throws Exception {
		zooKeeper = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
		WatchThread watchThread = new WatchThread();
		watchThread.start();
	}

	@Override
	public void run() {
		final String taskListPath=NodeInfo.nodePath+"/"+TaskInfoPath.NODE_WAITING_TASK_LIST_PATH;
		while (true) {
			try {
				synchronized (atom) {					
					List<String> children = zooKeeper.getChildren(taskListPath, this, null);
					if (children == null || children.isEmpty()) {
						atom.wait(1 * 1000);
						continue;
					}

					for (String tmp : children) {
						Stat stat = new Stat();
						String path = taskListPath + "/" + tmp;
						byte[] data = zooKeeper.getData(path, null, stat);
						zooKeeper.delete(path, stat.getVersion());
						if (data == null) {
							continue;
						}

						this.queueManager.addData((Task) ObjectUtils.read(data));
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

	public IQueueHandlerManager<Task> getQueueManager() {
		return queueManager;
	}

	public void setQueueManager(IQueueHandlerManager<Task> queueManager) {
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
						zooKeeper = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
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
