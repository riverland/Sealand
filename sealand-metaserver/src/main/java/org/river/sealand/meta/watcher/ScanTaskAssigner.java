package org.river.sealand.meta.watcher;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.river.sealand.meta.plan.TaskInfoPath;
import org.river.sealand.metainfo.task.ScanTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskStatus;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Scan数据扫描任务指派
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class ScanTaskAssigner extends TaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(ScanTaskAssigner.class);

	@Override
	public void assign(Task task, String taskPath) throws SQLException {
		if (task == null || StringUtils.isEmpty(taskPath)) {
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

		ScanTask scanTask = (ScanTask) task;
		try{
			List<String> nodes =zooKeeper.getChildren(TaskInfoPath.NODE_SERVERS_PATH, null);
			this.setTaskMetaInfo(nodes.size(), taskPath);
			
		}catch(SQLException e){
			// TODO 添加异常编码定义
			throw new SQLException("");
		}catch(Exception e){
			// TODO 添加异常编码定义
			throw new SQLException("");
		}		

	}
	
	/*
	 * 把执行任务分配到指定节点 
	 * @param nodePath
	 * @param task
	 */
	private void assign2Node(String nodePath,Task task){
		
	}

	/*
	 * 设置任务计划中任务的元数据
	 * 
	 * @param pendingNum
	 */
	private void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		try {
			zooKeeper.create(taskPath + "/" + TaskInfoPath.PENDING_TASK_NUM_FOR_META_PATH, String.valueOf(pendingNum).getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.TASK_RECORD_NUM_FOR_META_PATH, String.valueOf(0).getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.TASK_STATUS_FOR_META_PATH, TaskStatus.ASSIGNED.getValue().getBytes(), null, CreateMode.PERSISTENT);
			zooKeeper.create(taskPath + "/" + TaskInfoPath.TASK_TYPE_FOR_META_PATH, Task.Type.SCAN.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			//TOTO 定义sql异常
			throw new SQLException("");
		}
	}
}
