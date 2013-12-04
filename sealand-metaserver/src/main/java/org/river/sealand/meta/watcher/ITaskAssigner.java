package org.river.sealand.meta.watcher;

import org.river.sealand.metainfo.task.Task;

/**
 * <p>
 * 任务分配接口
 * @author river
 * @since  Dec 4, 2013
 */
public interface ITaskAssigner {
	
	/**
	 * <p>
	 * 任务分配
	 * @param task
	 */
	public void assign(Task task);
}
