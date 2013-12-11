package org.river.sealand.node.task;

import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.HavingTask;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.node.data.DataSet;
import org.river.sealand.node.data.MemDataSet;
import org.river.sealand.utils.SQLException;
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
	protected IFilterAlgorithm algorithm;

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}
		ZooKeeper zk = null;
		HavingTask task = (HavingTask) data.getData();
		try {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);

			DataSet dataSet = this.having(data);
			this.dataManager.putDataSet(task.connectionId + "-" + task.dataId, dataSet);

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
	 * 过滤操作
	 * 
	 * @param data
	 * 
	 * @return
	 */
	private DataSet having(DataEntity<Task> data) throws SQLException {
		HavingTask havingTask = (HavingTask) data.getData();
		String dataId = havingTask.srcDataIds.get(0);
		DataSet groupSet = this.dataManager.getDataSet(dataId);

		String havings = havingTask.havings;
		DataSet havingSet = new MemDataSet(havingTask.resultFields);
		try {
			havingSet.addAll(this.algorithm.filter(groupSet, havings));
		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
			// TODO implements the error logic
		}
		return havingSet;
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

	public IFilterAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(IFilterAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
}
