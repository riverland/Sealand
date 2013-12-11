package org.river.sealand.schedule.node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.river.sealand.sql.ast.SQLSort;
import org.river.sealand.utils.Entry;

/**
 * <p>
 * SORT 节点主要用于分布式合并之后的排序操作
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class SortNode extends ScheduleNode implements Serializable {

	private static final long serialVersionUID = 3180731320221384746L;

	private List<Entry<String, SQLSort.Type>> sorts = new ArrayList<Entry<String, SQLSort.Type>>();;

	public List<Entry<String, SQLSort.Type>> getSorts() {
		return sorts;
	}

	public void setSorts(List<Entry<String, SQLSort.Type>> sorts) {
		this.sorts = sorts;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SORT;
	}

}
