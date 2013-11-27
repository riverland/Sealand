package org.river.sealand.schedule.node;

import java.util.List;

/**
 * <p>
 * AGGREGATE 节点主要用于分布式合并
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class AggregateNode extends ScheduleNode {
	private List<String> groupBy;

	public List<String> getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(List<String> groupBy) {
		this.groupBy = groupBy;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.AGGREGATE;
	}

}
