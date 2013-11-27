package org.river.sealand.schedule.node;

import java.util.List;

/**
 * <p>
 * HAVING 节点主要用于分布式合并之后的过滤操作
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class HavingNode extends ScheduleNode {
	private String havings;

	public String getHavings() {
		return havings;
	}

	public void setHavings(String havings) {
		this.havings = havings;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.HAVING;
	}

}
