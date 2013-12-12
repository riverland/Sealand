package org.river.sealand.metainfo.task;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	/**事务ID*/
	public String transactionId;
	
	/**入口ID*/
	public String stmtId;

	/** 数据ID */
	public String dataId;
	
	/**数据源ID列表*/
	public List<String> srcDataIds;

	/** 返回列*/
	public List<String> resultFields;
	
	/**用于计算的列表达式:格式dataId#列位 */
	public List<String> columnFields;
	
	/**目标任务地址*/
	public String destTaskPath;
	
	/**当前任务地址*/
	public String taskPath;
	
	/**参与计算的节点*/
	public List<String> runNode=new ArrayList<String>();

	public abstract Type getType();

	public static enum Type {
		SCAN("S"), TRANSFER("T"), JOIN("J"), SORT("O"), LIMIT("L"), AGGREGATE("A"),HAVING("H");
		
		private String value;

		public String getValue() {
			return value;
		}

		private Type(String value) {
			this.value = value;
		}
		
		
	}
}
