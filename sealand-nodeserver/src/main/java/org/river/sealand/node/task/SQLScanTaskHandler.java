package org.river.sealand.node.task;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.zookeeper.ZooKeeper;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.node.data.ScanDataSet;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * sql执行节点处理器
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class SQLScanTaskHandler extends TaskHandler {

	private static Logger LOG = LoggerFactory.getLogger(SQLScanTaskHandler.class);
	protected DataSource dataSource;

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}
		ZooKeeper zk = null;
		ScanTask task = (ScanTask) data.getData();
		try {
			zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			Connection con = dataSource.getConnection();
			String sql = task.sql;
			ScanDataSet dataSet = new ScanDataSet(con, sql);
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

	@Override
	public Class<?> getDataType() {
		return ScanTask.class;
	}

	@Override
	protected boolean needHandle(DataEntity<Task> data) {
		Task task = data.getData();
		return task.getType() == Task.Type.SCAN;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
