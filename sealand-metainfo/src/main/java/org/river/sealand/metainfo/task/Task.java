package org.river.sealand.metainfo.task;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 分布式任务实体
 * 
 * @author river
 * @since Dec 1, 2013
 */
public abstract class Task implements Serializable {
	private static final long serialVersionUID = 5128094283936211477L;
	
	/** 任务ID */
	public String taskId;

	/** 对应于一次连接,任务只属于一个数据库连接 */
	public String connectionId;

	/** 数据ID */
	public String dataId;

	/** 返回列:格式dataId#列位 */
	public List<String> resultFields;

	public abstract Type getType();

	public static enum Type {
		SCAN, TRANSFER, JOIN, SORT, LIMIT, AGGREGATE;
	}
}
