package org.river.sealand.metainfo.task;

import java.util.List;

import org.river.sealand.sql.ast.SQLSort;
import org.river.sealand.utils.Entry;

/**
 * <p>
 * 数据排序任务,为两段式任务
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class SortTask extends Task {

	private static final long serialVersionUID = 6996501368131685767L;

	/**排序*/
	public List<Entry<String, SQLSort.Type>> orderBy;

	/** 需要传输获取的数据ID */
	public List<String> distributeDataIds;

	/** 参与计算的节点 */
	public List<String> servers;

	@Override
	public Type getType() {
		return Type.LIMIT;
	}
}
