package org.river.sealand.meta.watcher;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 聚合任务指派
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class AggregateTaskAssigner extends TaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(AggregateTaskAssigner.class);

	@Override
	protected void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		super.setTaskMetaInfo(pendingNum, taskPath);
		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_TYPE_PATH, Task.Type.AGGREGATE.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}
}
