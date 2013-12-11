package org.river.sealand.node.task;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.AggregateTask;
import org.river.sealand.metainfo.task.LimitTask;
import org.river.sealand.metainfo.task.SortTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.node.algorithm.AlggregateAlgorithmManager;
import org.river.sealand.node.algorithm.IAggregateAlgorithm;
import org.river.sealand.node.algorithm.IGroupAlgorithm;
import org.river.sealand.node.data.DataSet;
import org.river.sealand.node.data.DataType;
import org.river.sealand.node.data.MemDataSet;
import org.river.sealand.sql.util.SQLUtils;
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
	protected IGroupAlgorithm groupAlgorithm;

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
	 * 
	 * @param task
	 * 
	 * @return
	 */
	protected DataSet aggregate(Task task) throws SQLException {
		Map<String, DataSet> group = this.group(task);
		return this.aggregate(group, task);
	}

	/*
	 * 对应经分组的数据进行聚合计算
	 * 
	 * @param group
	 * 
	 * @param task
	 * 
	 * @return
	 */
	protected DataSet aggregate(Map<String, DataSet> group, Task task) throws SQLException {
		DataSet dataSet = new MemDataSet(task.resultFields);

		Set<String> keySet = group.keySet();
		for (String key : keySet) {
			DataSet item = group.get(key);
			String rec = this.aggregateGroup(item, task, key);
			dataSet.addRecord(rec);
		}
		return dataSet;
	}

	/*
	 * 对应经分组的数据进行聚合计算
	 * 
	 * @param group
	 * 
	 * @param task
	 * 
	 * @return
	 */
	private String aggregateGroup(DataSet group, Task task, String groupValues) throws SQLException {
		AggregateTask aggregate = (AggregateTask) task;
		List<String> algFuncs = aggregate.aggregates;
		Map<String, IAggregateAlgorithm> algorithms = this.getAggregateAlgorithm(algFuncs);
		while (group.next()) {
			for (String func : algFuncs) {
				// TODO 函数参数是表达式的情况未处理
				List<String> args = SQLUtils.getFuncArgsLabel(func);
				Object value = group.getObject(args.get(0));
				DataType dataType = group.getDataType(args.get(0));
				algorithms.get(func).addSrcData(dataType, value);
			}
		}

		Map<String, String> groupValueMap = this.buildGroupByValues(aggregate.groupBy, groupValues);

		List<String> fields = task.columnFields;
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		for (String tmp : fields) {
			if (!flag) {
				sb.append(MemDataSet.COL_SEPERATOR);
			} else {
				flag = false;
			}

			String value = groupValueMap.get(tmp);
			if (!StringUtils.isEmpty(value)) {
				sb.append(value);
				continue;
			}

			IAggregateAlgorithm algorithm = algorithms.get(tmp);
			if (algorithm != null) {
				value = algorithm.getResult();
			}

			sb.append(value);

		}
		return sb.toString();
	}

	/*
	 * 构建groupby 的字段值
	 * 
	 * @param groupBy
	 * 
	 * @param groupValues
	 * 
	 * @return
	 */
	private Map<String, String> buildGroupByValues(String groupBy, String groupValues) {
		Map<String, String> map = new HashMap<String, String>();
		String[] keys = groupBy.split(",");
		String[] values = groupValues.split(",");
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		return map;
	}

	/*
	 * 获取聚合统计算法
	 * 
	 * @param algFuncs
	 * 
	 * @return
	 */
	private Map<String, IAggregateAlgorithm> getAggregateAlgorithm(List<String> algFuncs) {
		if (algFuncs == null || algFuncs.isEmpty()) {
			return null;
		}

		Map<String, IAggregateAlgorithm> algorithms = new HashMap<String, IAggregateAlgorithm>();
		for (String func : algFuncs) {
			algorithms.put(func, AlggregateAlgorithmManager.get(func));
		}
		return algorithms;
	}

	/*
	 * 把数据集分组
	 * 
	 * @param task
	 * 
	 * @return
	 */
	private Map<String, DataSet> group(Task task) {
		AggregateTask aggregate = (AggregateTask) task;
		List<String> groupBy = StringUtils.commaSplit(aggregate.groupBy);
		DataSet src = this.dataManager.remove(task.srcDataIds.get(0));
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
