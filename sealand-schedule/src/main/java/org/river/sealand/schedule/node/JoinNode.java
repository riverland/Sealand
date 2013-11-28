package org.river.sealand.schedule.node;


/**
 * <p>
 * join 节点主要用于分布式数据连接
 * @author river
 * @since  Nov 27, 2013
 */
public class JoinNode extends ScheduleNode{
	private String on;
	
	private JoinType joinType; 

	public JoinType getJoinType() {
		return joinType;
	}

	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.JOIN;
	}
	
	public static enum JoinType{
		INNER, LEFT, RIGHT,CROSS;
	}
}
