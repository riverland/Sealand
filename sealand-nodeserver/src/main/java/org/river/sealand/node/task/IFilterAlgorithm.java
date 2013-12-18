package org.river.sealand.node.task;

import org.river.sealand.proto.data.DataSet;

/**
 * <p>
 * 执行过滤
 * @author river
 * @since  Dec 10, 2013
 */
public interface IFilterAlgorithm {
	
	/**
	 * <p>
	 * 过滤不满足where 的数据记录
	 * @param src
	 * @param where
	 * @return
	 */
	public DataSet filter(DataSet src,String where);
}
