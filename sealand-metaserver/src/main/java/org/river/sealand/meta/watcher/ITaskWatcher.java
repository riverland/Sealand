package org.river.sealand.meta.watcher;

import java.io.IOException;

import org.river.sealand.metainfo.task.Task;

/**
 * <p>
 * metaserver 任务监视接口
 * @author river
 * @since  Dec 5, 2013
 */
public interface ITaskWatcher {
	
	/**
	 * <p>
	 * 启动监听
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void start() throws IOException, InterruptedException;
	
	/**
	 * <p>
	 * 结束监听
	 */
	public void close();
	
	/**
	 * <p>
	 * 分派任务到计算节点为可执行的任务
	 * @param task
	 */
	public void assign(Task task);
	
	/**
	 * <p>
	 * 唤醒启动上一级监听
	 */
	public void wakeUpParent();
}
