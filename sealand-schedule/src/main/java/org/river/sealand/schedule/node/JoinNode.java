package org.river.sealand.schedule.node;

import java.util.List;

/**
 * <p>
 * join 节点主要用于分布式数据连接
 * @author river
 * @since  Nov 27, 2013
 */
public class JoinNode extends ScheduleNode{
	private List<String> on;

	public List<String> getOn() {
		return on;
	}

	public void setOn(List<String> on) {
		this.on = on;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.JOIN;
	}
	
	
}
