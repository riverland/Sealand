package org.river.sealand.node.task;

import javax.sql.DataSource;

import org.river.base.threads.impl.QueueHandlerAdaptor;
import org.river.sealand.node.data.IDataManager;

/**
 * <p>
 * 接受任务基类
 * 
 * @author river
 * @since Dec 7, 2013
 * @param <Task>
 */
public abstract class TaskHandler<Task> extends QueueHandlerAdaptor<Task> {
	protected DataSource dataSource;
	protected IDataManager dataManager;
	protected String zkHost;
	protected long timeout;

	/**
	 * 通知该节点数据计算完成
	 * 
	 * @param task
	 */
	protected abstract void notifyDataReady(Task task);

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
