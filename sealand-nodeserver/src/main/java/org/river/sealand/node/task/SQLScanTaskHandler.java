package org.river.sealand.node.task;

import org.river.base.threads.impl.QueueHandlerAdaptor;
import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.ScanTask;
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
public class SQLScanTaskHandler extends QueueHandlerAdaptor<Task> {

	private static Logger LOG = LoggerFactory.getLogger(SQLScanTaskHandler.class);

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}
		
		ScanTask task=(ScanTask)data.getData();
		
		data.setData(null);		
	}

	@Override
	public Class<?> getDataType() {
		return Task.class;
	}

	protected boolean needHandle(DataEntity<Task> data) {
		return false;
	}

}
