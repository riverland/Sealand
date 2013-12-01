package org.river.sealand.node.task;

import org.river.base.threads.impl.AsyncQueueHandler;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * sql执行节点处理器
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class SQLScanTaskHandler extends AsyncQueueHandler<Task> {

	private static Logger log = LoggerFactory.getLogger(SQLScanTaskHandler.class);

	@Override
	public void handle(DataEntity<Task> data) {
		super.handle(data);
	}

	@Override
	public Class<?> getDataType() {
		return Task.class;
	}

	@Override
	protected void asyncHandle(Task data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean needHandle(DataEntity<Task> data) {
		// TODO Auto-generated method stub
		return false;
	}

}
