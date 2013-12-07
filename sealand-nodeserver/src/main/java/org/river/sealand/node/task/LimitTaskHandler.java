package org.river.sealand.node.task;

import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.LimitTask;
import org.river.sealand.metainfo.task.SortTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.node.data.DataSet;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 分页任务执行节点处理器
 * 
 * @author river
 * @since Dec 7, 2013
 * @param <Task>
 */
public class LimitTaskHandler extends TaskHandler<Task> {

	private static Logger LOG = LoggerFactory.getLogger(LimitTaskHandler.class);

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}

		ZooKeeper zk = null;
		LimitTask task = (LimitTask) data.getData();
		try {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			DataSet dataSet = this.limit(task);
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
	 * 执行分页操作
	 * 
	 * @param task
	 * 
	 * @return
	 */
	private DataSet limit(Task task) {
		String srcDataId = task.srcDataIds.get(0);
		DataSet all = this.dataManager.getDataSet(task.connectionId + "-" + srcDataId);

		LimitTask limitTask = (LimitTask) task;
		DataSet limit = all.subset(limitTask.start, limitTask.offset);
		this.dataManager.remove(srcDataId);
		return limit;
	}

	@Override
	public Class<?> getDataType() {
		return SortTask.class;
	}

	@Override
	protected boolean needHandle(DataEntity<Task> data) {
		Task task = data.getData();
		return task.getType() == Task.Type.LIMIT;
	}

}
