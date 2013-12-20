package org.river.sealand.node.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.SortTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.data.DataType;
import org.river.sealand.proto.data.MemDataSet;
import org.river.sealand.sql.ast.SQLSort;
import org.river.sealand.utils.Entry;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 排序任务执行节点处理器
 * 
 * @author river
 * @since Dec 10, 2013
 * @param <Task>
 */
public class SortTaskHandler extends TaskHandler {

	private static Logger LOG = LoggerFactory.getLogger(SortTaskHandler.class);

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}

		ZooKeeper zk = null;
		Task task = data.getData();
		try {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			DataSet dataSet = this.sort(task);
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
	private DataSet sort(Task task) {
		String srcDataId = task.srcDataIds.get(0);
		DataSet srcData = this.dataManager.getDataSet(task.connectionId + "-" + srcDataId);

		SortTask sortTask = (SortTask) task;
		List<String> records = srcData.getRecords();
		List<DataType> dataTypes = srcData.getCollumnDataType();
		List<Entry<String, SQLSort.Type>> labelSorts = sortTask.orderBy;
		List<Entry<Integer, SQLSort.Type>> indexSorts = this.getOrderByIndex(srcData, labelSorts);

		RecordComparator<String> c = new RecordComparator<String>(indexSorts, dataTypes);
		//排序算法直接用jdk的，如果性能上不合，则可用实现其他算法
		Collections.sort(records, c);
		return srcData;
	}

	/*
	 * 构建排序列index
	 * 
	 * @param data
	 * 
	 * @param orderBy
	 * 
	 * @return
	 */
	private List<Entry<Integer, SQLSort.Type>> getOrderByIndex(DataSet data, List<Entry<String, SQLSort.Type>> orderBy) {
		List<Entry<Integer, SQLSort.Type>> rt = new ArrayList<Entry<Integer, SQLSort.Type>>();
		List<String> cols = data.allColLables();
		for (Entry<String, SQLSort.Type> tmp : orderBy) {
			Integer i = cols.indexOf(tmp.key);
			rt.add(new Entry<Integer, SQLSort.Type>(i, tmp.value));
		}
		return rt;
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

	/**
	 * <p>
	 * 数据记录比较器
	 * 
	 * @author river
	 * @since Dec 11, 2013
	 * @param <String>
	 */
	private static class RecordComparator<T> implements Comparator<T> {
		private List<Entry<Integer,SQLSort.Type>> orderby;
		private List<DataType> dataTypes;

		private RecordComparator(List<Entry<Integer,SQLSort.Type>> orderby, List<DataType> dataTypes) {
			this.orderby = orderby;
			this.dataTypes = dataTypes;
		}

		@Override
		public int compare(Object o1, Object o2) {
			String[] o1Arr = StringUtils.split((String) o1, MemDataSet.COL_SEPERATOR);
			String[] o2Arr = StringUtils.split((String) o2, MemDataSet.COL_SEPERATOR);

			for (int i = 0; i < orderby.size(); i++) {
				DataType dataType = dataTypes.get(i);
				String l = o1Arr[i];
				String r = o2Arr[i];
				Number cp = 0;
				switch (dataType) {
				case STRING: {
					cp = l.compareTo(r);
					break;
				}
				case INT: {
					Long lLong = Long.valueOf(l);
					Long rLong = Long.valueOf(r);
					cp = lLong - rLong;
					break;
				}
				case FLOAT: {
					Double lDouble = Double.valueOf(l);
					Double rDouble = Double.valueOf(r);
					cp = lDouble - rDouble;
					break;
				}
				}

				if (cp.doubleValue() > 0) {
					return 1;
				} else if (cp.doubleValue() < 0) {
					return -1;
				}

			}
			return 0;
		}
	}

}
