package org.river.sealand.schedule.node;

import java.io.Serializable;

/**
 * <p>
 * LIMIT 节点主要用于分布式合并之后分页操作
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class LimitNode extends ScheduleNode implements Serializable {
	private static final long serialVersionUID = 2580907094136081687L;

	private int start;

	private int offset;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.LIMIT;
	}

}
