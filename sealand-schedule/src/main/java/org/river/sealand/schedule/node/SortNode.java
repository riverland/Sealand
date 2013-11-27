package org.river.sealand.schedule.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * SORT 节点主要用于分布式合并之后的排序操作
 * @author river
 * @since  Nov 27, 2013
 */
public class SortNode extends ScheduleNode{
	private Map<String,SortType> sorts=new HashMap<String,SortType>();;


	public Map<String, SortType> getSorts() {
		return sorts;
	}

	public void setSorts(Map<String, SortType> sorts) {
		this.sorts = sorts;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SORT;
	}
	
	public static enum SortType{
		ASC,DESC;
	}
	
}
