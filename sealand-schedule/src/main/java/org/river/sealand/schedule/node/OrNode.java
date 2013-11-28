package org.river.sealand.schedule.node;

/**
 * <p>
 * 分布式CROSS Join中的OR,srcNodes 为Join节点
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class OrNode extends ScheduleNode {
	@Override
	public NodeType getNodeType() {
		return NodeType.OR;
	}

}
