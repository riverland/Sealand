package org.river.sealand.node.task;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.river.base.threads.impl.QueueHandlerAdaptor;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
import org.river.sealand.metainfo.task.TaskStatus;
import org.river.sealand.node.data.IDataManager;
import org.river.sealand.utils.ZooKeeperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 接受任务基类
 * 
 * @author river
 * @since Dec 7, 2013
 * @param <Task>
 */
public abstract class TaskHandler<E> extends QueueHandlerAdaptor<E> {
	private static final Logger LOG = LoggerFactory.getLogger(TaskHandler.class);	
	protected IDataManager dataManager;
	protected String zkHost;
	protected long timeout;

	/**
	 * <p>
	 * 判断是否需要处理
	 * @param data
	 * @return
	 */
	protected abstract boolean needHandle(DataEntity<Task> data);

	/**
	 * 通知该节点数据计算完成
	 * 
	 * @param task
	 */
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
	protected int updatePendNum(ZooKeeper zk, Task task) {
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
	 * 更新目标任务等待任务记录数量
	 * 
	 * @param zk
	 * 
	 * @param task
	 * 
	 * @return
	 */
	protected int updateRecNum(ZooKeeper zk, Task task, int recNum) {
		try {
			String recNumPath = task.destTaskPath + "/" + TaskInfoPath.META_TASK_RECORD_NUM_PATH;
			Stat recNumStat = new Stat();
			Integer destTaskRecNum = ZooKeeperUtils.getInt(zk, recNumPath, recNumStat);
			destTaskRecNum = destTaskRecNum + recNum;
			zk.setData(recNumPath, destTaskRecNum.toString().getBytes(), recNumStat.getVersion());
			return destTaskRecNum;
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
	protected void updateDestTaskStatus(ZooKeeper zk, Task task, boolean completed) {
		try {
			String statusPath = task.destTaskPath + "/" + TaskInfoPath.META_TASK_STATUS_PATH;
			TaskStatus status = completed ? TaskStatus.COMMPLETED : TaskStatus.FAILED;
			zk.setData(statusPath, status.getValue().getBytes(), -1);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO the error logic
		}
	}

	public IDataManager getDataManager() {
		return dataManager;
	}

	public void setDataManager(IDataManager dataManager) {
		this.dataManager = dataManager;
	}

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String zkHost) {
		this.zkHost = zkHost;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

}
