package org.river.sealand.node.task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.JoinTask;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.node.algorithm.IJoinAlgorithm;
import org.river.sealand.node.data.DataSet;
import org.river.sealand.node.data.IDataWatcher;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Having执行节点处理器
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class HaveTaskHandler extends TaskHandler<Task> {

	private static Logger LOG = LoggerFactory.getLogger(HaveTaskHandler.class);
	protected DataSource dataSource;
	protected IJoinAlgorithm algorithm;

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}
		ZooKeeper zk = null;
		JoinTask task = (JoinTask) data.getData();
		try {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);

			DataSet dataSet = this.join(data);
			this.dataManager.putDataSet(task.connectionId + "-" + task.dataId, dataSet);
			this.dataManager.remove(task.localDataId);
			int localRecNum = dataSet.count();
			while (this.updateRecNum(zk, task, localRecNum) == -1) {
				// do nothing
			}
			this.notifyDataReady(task);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			try {
				this.updateDestTaskStatus(zk, task, false);
			} catch (Throwable t) {
				// do nothing
			}
		}

		data.setData(null);
	}

	/*
	 * 执行连接操作
	 * 
	 * @param data
	 * 
	 * @return
	 */
	private DataSet join(DataEntity<Task> data) throws InterruptedException {
		JoinTask joinTask = (JoinTask) data.getData();
		String localDataId = joinTask.connectionId + "-" + joinTask.localDataId;
		DataSet localData = this.dataManager.getDataSet(localDataId);
		List<String> remotes = new ArrayList<String>();
		List<String> dataIds = joinTask.srcDataIds;
		for (String dataId : dataIds) {
			remotes.add(joinTask.connectionId + "-" + dataId);
		}
		String on = joinTask.on;
		DataSet joinSet = this.join(localData, remotes, on);
		return joinSet;
	}

	/*
	 * 执行连接操作
	 * 
	 * @param local
	 * 
	 * @param remotes
	 * 
	 * @return
	 */
	private DataSet join(DataSet local, List<String> remotes, String on) throws InterruptedException {
		while (remotes.size() > 0) {
			DataSet remoteSet = this.getRemoteSet(remotes);
			try {
				local = this.algorithm.join(local, remoteSet, on);
			} catch (SQLException e) {
				LOG.error(e.getLocalizedMessage());
				// TODO implements the error logic
			}
		}

		return local;
	}

	/*
	 * 获取应经准备好的数据，并从列表中删除
	 * 
	 * @param remotes
	 * 
	 * @return
	 */
	private DataSet getRemoteSet(List<String> remotes) throws InterruptedException {
		DataSet data = null;
		while (true) {
			for (String tmp : remotes) {
				data = this.dataManager.getDataSet(tmp);
				if (data != null) {
					remotes.remove(tmp);
					return data;
				}
			}

			Object lock = new Object();
			lock.wait();
			this.watch(lock, remotes);
		}
	}

	/*
	 * 监听未准备好的数据
	 * 
	 * @param lock
	 * 
	 * @param remotes
	 */
	private void watch(Object lock, List<String> remotes) {
		for (String tmp : remotes) {
			this.dataManager.watch(tmp, new DataReadyWatcher(lock));
		}
	}

	@Override
	public Class<?> getDataType() {
		return ScanTask.class;
	}

	@Override
	protected boolean needHandle(DataEntity<Task> data) {
		Task task = data.getData();
		return task.getType() == Task.Type.SCAN;
	}

	/**
	 * <p>
	 * 数据已经准备好的事件监听
	 * 
	 * @author river
	 * @since Dec 8, 2013
	 */
	private static class DataReadyWatcher implements IDataWatcher {

		private Object lock;

		public DataReadyWatcher(Object lock) {
			this.lock = lock;
		}

		@Override
		public String fire(DataEvent event) {
			if (event.getEvent() == IDataWatcher.EventType.CREATE) {
				lock.notifyAll();
			}

			return event.getDataId();
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public IJoinAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(IJoinAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

}
