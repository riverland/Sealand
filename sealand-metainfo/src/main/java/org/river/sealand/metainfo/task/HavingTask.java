package org.river.sealand.metainfo.task;

import java.util.List;

/**
 * <p>
 * 数据连接任务
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class HavingTask extends Task {

	private static final long serialVersionUID = 8265223529827605349L;

	/** 分组 */
	public String groupBy;

	/** 过滤 */
	public String havings;

	/** 分组表达式 */
	public List<String> aggregates;

	/** 需要传输获取的数据ID */
	public List<String> distributeDataIds;

	/** 参与计算的节点 */
	public List<String> servers;

	@Override
	public Type getType() {
		return Type.HAVING;
	}
}
