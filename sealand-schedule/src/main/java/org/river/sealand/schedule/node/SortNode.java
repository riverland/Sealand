package org.river.sealand.schedule.node;

import java.util.HashMap;
import java.util.Map;

import org.river.sealand.sql.ast.SQLSort.Type;

/**
 * <p>
 * SORT 节点主要用于分布式合并之后的排序操作
 * @author river
 * @since  Nov 27, 2013
 */
public class SortNode extends ScheduleNode{
	private Map<String,Type> sorts=new HashMap<String,Type>();;


	public Map<String, Type> getSorts() {
		return sorts;
	}

	public void setSorts(Map<String, Type> sorts) {
		this.sorts = sorts;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SORT;
	}
	
	
}
