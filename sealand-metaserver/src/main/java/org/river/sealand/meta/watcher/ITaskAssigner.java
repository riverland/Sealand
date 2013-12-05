package org.river.sealand.meta.watcher;

import org.river.sealand.metainfo.task.Task;
import org.river.sealand.utils.SQLException;

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
	 * @throws SQLException 
	 */
	public void assign(Task task,String taskPath) throws SQLException;
}
