package org.river.sealand.node.task;

import java.util.List;
import java.util.Map;

import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.AggregateTask;
import org.river.sealand.metainfo.task.LimitTask;
import org.river.sealand.metainfo.task.SortTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.node.algorithm.IGroupAlgorithm;
import org.river.sealand.node.data.DataSet;
import org.river.sealand.utils.StringUtils;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 聚合任务执行节点处理器
 * 
 * @author river
 * @since Dec 7, 2013
 * @param <Task>
 */
public class AggregateTaskHandler extends TaskHandler<Task> {

	private static Logger LOG = LoggerFactory.getLogger(AggregateTaskHandler.class);
	private IGroupAlgorithm groupAlgorithm;
	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}

		ZooKeeper zk = null;
		LimitTask task = (LimitTask) data.getData();
		try {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			DataSet dataSet = this.aggregate(task);
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
	 * 对源数据集进行聚合计算
	 * @param task
	 * @return
	 */
	private DataSet aggregate(Task task){
		Map<String,DataSet> group =this.group(task);
		return this.aggregate(group,task);
	}
	
	/*
	 * 对应经分组的数据进行聚合计算
	 * @param group
	 * @param task
	 * @return
	 */
	private DataSet aggregate(Map<String,DataSet> group,Task task){
		AggregateTask aggregate=(AggregateTask) task;
		return null;
	}
	
	/*
	 * 把数据集分组 
	 * @param task
	 * @return
	 */
	private Map<String,DataSet> group(Task task){
		AggregateTask aggregate=(AggregateTask) task;		
		List<String> groupBy=StringUtils.commaSplit(aggregate.groupBy);
		DataSet src=this.dataManager.remove(task.srcDataIds.get(0));
		return groupAlgorithm.groupBy(src, groupBy);
	}

	
	
	@Override
	public Class<?> getDataType() {
		return SortTask.class;
	}

	@Override
	protected boolean needHandle(DataEntity<Task> data) {
		Task task = data.getData();
		return task.getType() == Task.Type.AGGREGATE;
	}

}
