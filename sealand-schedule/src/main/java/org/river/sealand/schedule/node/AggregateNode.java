package org.river.sealand.schedule.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * AGGREGATE 节点主要用于分布式合并
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class AggregateNode extends ScheduleNode implements Serializable {
	private static final long serialVersionUID = 8485843651070083901L;
	
	/** 分组字段 */
	private List<String> groupBy = new ArrayList<String>();

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
