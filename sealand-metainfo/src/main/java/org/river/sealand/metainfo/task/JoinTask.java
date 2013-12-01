package org.river.sealand.metainfo.task;

import java.util.List;

/**
 * <p>
 * 数据连接任务
 * @author river
 * @since  Dec 1, 2013
 */
public class JoinTask extends Task {
	private static final long serialVersionUID = 8990962354245311051L;

	/** join条件 */
	public String on;

	/** 本地数据ID */
	public String localDataId;

	/** 需要传输获取的数据ID */
	public List<String> distributeDataIds;

	/** 参与计算的节点 */
	public List<String> servers;

	@Override
	public Type getType() {
		return Type.JOIN;
	}
}
