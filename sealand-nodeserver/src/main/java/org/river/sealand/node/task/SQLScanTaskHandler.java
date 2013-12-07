package org.river.sealand.node.task;

import java.sql.Connection;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
import org.river.sealand.metainfo.task.TaskStatus;
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
public class SQLScanTaskHandler extends TaskHandler<Task> {

	private static Logger LOG = LoggerFactory.getLogger(SQLScanTaskHandler.class);

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}

		ScanTask task = (ScanTask) data.getData();
		try {
			Connection con = dataSource.getConnection();
			String sql = task.sql;
			ScanDataSet dataSet = new ScanDataSet(con, sql);
			this.dataManager.putDataSet(task.connectionId + "-" + task.dataId, dataSet);

			this.notifyDataReady(task);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			ZooKeeper zk;
			try {
				zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
				this.updateDestTaskStatus(zk, task, false);
			} catch (Throwable t) {
				// do nothing
			}
		}

		data.setData(null);
	}

	@Override
	protected void notifyDataReady(Task task) {
		try {
			ZooKeeper zk = ZooKeeperUtils.getZooKeeper(zkHost, timeout);
			Integer destTaskPendNum = -1;
			while (destTaskPendNum == -1) {
				destTaskPendNum = this.updatePendNum(zk, task);
			}

			if (destTaskPendNum == 0) {
				this.updateDestTaskStatus(zk, task, true);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO the error logic
		}
	}

	/*
	 * 更新目标任务等待任务数量
	 * 
	 * @param zk
	 * 
	 * @param task
	 * 
	 * @return
	 */
	private int updatePendNum(ZooKeeper zk, Task task) {
		try {
			String pendNumPath = task.destTaskPath + "/" + TaskInfoPath.META_PENDING_NUM_PATH;
			Stat pendNumStat = new Stat();
			Integer destTaskPendNum = ZooKeeperUtils.getInt(zk, pendNumPath, pendNumStat);
			destTaskPendNum--;
			zk.setData(pendNumPath, destTaskPendNum.toString().getBytes(), pendNumStat.getVersion());
			return destTaskPendNum;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO the error logic
			return -1;
		}
	}

	/*
	 * 更新目标任务状态
	 * 
	 * @param zk
	 * 
	 * @param task
	 */
	private void updateDestTaskStatus(ZooKeeper zk, Task task, boolean completed) {
		try {
			String statusPath = task.destTaskPath + "/" + TaskInfoPath.META_TASK_STATUS_PATH;
			TaskStatus status = completed ? TaskStatus.COMMPLETED : TaskStatus.FAILED;
			zk.setData(statusPath, status.getValue().getBytes(), -1);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO the error logic
		}
	}

	@Override
	public Class<?> getDataType() {
		return ScanTask.class;
	}

	protected boolean needHandle(DataEntity<Task> data) {
		Task task = data.getData();
		return task.getType() == Task.Type.SCAN;
	}

}
