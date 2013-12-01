package org.river.sealand.metainfo.task;

import java.util.List;

/**
 * <p>
 * 数据连接任务
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class LimitTask extends Task {

	private static final long serialVersionUID = 6996501368131685767L;

	/**排序*/
	public String orderBy;

	/** 需要传输获取的数据ID */
	public List<String> distributeDataIds;

	/** 参与计算的节点 */
	public List<String> servers;

	@Override
	public Type getType() {
		return Type.LIMIT;
	}
}
