package org.river.sealand.meta.watcher;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.river.sealand.metainfo.task.JoinTask;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.TaskInfoPath;
import org.river.sealand.utils.ObjectUtils;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据连接任务指派
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class JoinTaskAssigner extends TaskAssigner {
	private static final Logger LOG = LoggerFactory.getLogger(JoinTaskAssigner.class);

	@Override
	public void assign(Task task, String taskPath) throws SQLException {
		if (task == null || StringUtils.isEmpty(taskPath)) {
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			List<String> nodes = zooKeeper.getChildren(TaskInfoPath.NODE_SERVERS_PATH, null);
			this.setTaskMetaInfo(nodes.size(), taskPath);
			this.setTransferInfo((JoinTask)task, taskPath);
			
			for (String tmp : nodes) {
				this.assign2Node(TaskInfoPath.NODE_SERVERS_PATH + "/" + tmp, taskPath, task);
			}

		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
			// TODO 添加异常编码定义
			throw new SQLException("");
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO 添加异常编码定义
			throw new SQLException("");
		}

	}

	/*
	 * 设置连接任务数据传输的信息
	 * 
	 * @param task
	 * 
	 * @param taskPath
	 */
	private void setTransferInfo(JoinTask task, String taskPath) throws SQLException {
		
		try {
			List<String> dataIds=new ArrayList<String>();
			String localDataId=null;
			int max=0;
			ZooKeeper zooKeeper = this.getZooKeeper();
			List<String> nodes = zooKeeper.getChildren(taskPath, null);
			for (String tmp : nodes) {
				if(StringUtils.isEmpty(tmp)||!tmp.matches(TaskInfoPath.TASK_NAME_PATTERN)){
					continue;
				}
				
				final String subTaskPath=taskPath+"/"+tmp;
				Task subTask=(Task) ObjectUtils.read(zooKeeper.getData(subTaskPath, null, null));
				dataIds.add(subTask.dataId);
				int recNum=this.getRecordNum(taskPath+"/"+tmp);
				if(recNum>max){
					max=recNum;
					localDataId=subTask.dataId;
				}
			}
			
			dataIds.remove(localDataId);
			task.distributeDataIds=dataIds;
			task.localDataId=localDataId;

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			// TODO 添加异常编码定义
			throw new SQLException("");
		}
	}
	
	/*
	 * 获取任务节点的记录数
	 * @param taskPath
	 * @return
	 */
	private int getRecordNum(String taskPath) throws Exception{
		ZooKeeper zooKeeper = this.getZooKeeper();
		byte[] recNumData = zooKeeper.getData(taskPath + "/" + TaskInfoPath.META_TASK_RECORD_NUM_PATH, null, null);
		String recNumStr = new String(recNumData);
		Integer recNum = new Integer(recNumStr);
		return recNum;
	}

	@Override
	protected void setTaskMetaInfo(int pendingNum, String taskPath) throws SQLException {
		super.setTaskMetaInfo(pendingNum, taskPath);
		try {
			ZooKeeper zooKeeper = this.getZooKeeper();
			zooKeeper.create(taskPath + "/" + TaskInfoPath.META_TASK_TYPE_PATH, Task.Type.JOIN.getValue().getBytes(), null, CreateMode.PERSISTENT);
		} catch (Exception e) {
			// TOTO 定义sql异常
			throw new SQLException("");
		}
	}
}
