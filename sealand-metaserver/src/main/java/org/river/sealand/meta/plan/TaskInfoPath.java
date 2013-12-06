package org.river.sealand.meta.plan;

/**
 * <p>
 * 任务信息的一些路径常量
 * @author river
 * @since  Dec 4, 2013
 */
public class TaskInfoPath {
	public static final String TASK_NAME_PATTERN="task-\\d+";
	public static final String META_PENDING_NUM_PATH="pending_num";
	public static final String META_TASK_RECORD_NUM_PATH="record_num";
	public static final String META_TASK_STATUS_PATH="task_status";	
	public static final String META_TASK_TYPE_PATH="task_type";
	public static final String META_SERVER_PATH="meta_server";
	public static final String META_SERVER_SQLPLAN_PATH=META_SERVER_PATH+"/sql_plans";
	
	public static final String NODE_SERVERS_PATH="node_servers";
	
	public static final String NODE_IP_PATH="node_ip";
	public static final String NODE_PORT_PATH="node_port";
	public static final String NODE_PENDING_TASK_LIST_PATH="pending_tasks";
	public static final String NODE_WAITING_TASK_LIST_PATH="waiting_tasks";
	public static final String NODE_TASK_PATH="task-";
	public static final String NODE_TASK_DEST_PATH="task-";
}
