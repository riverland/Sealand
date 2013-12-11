package org.river.sealand.metainfo.task;

import java.util.List;

/**
 * <p>
 * 数据分页任务
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class LimitTask extends Task {

	private static final long serialVersionUID = -514125465396481784L;
	
	/**数据开始行数*/
	public int start;
	
	/**记录偏移量*/
	public int offset;

	/** 需要传输获取的数据ID */
	public List<String> distributeDataIds;

	/** 参与计算的节点 */
	public List<String> servers;

	@Override
	public Type getType() {
		return Type.SORT;
	}
}
