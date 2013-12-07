package org.river.sealand.node.data;

import java.sql.ResultSet;
/**
 * <p>
 * 内部数据集对象
 * @author river
 * @since  Dec 6, 2013
 */
public interface DataSet extends ResultSet {
	/**
	 * <p>
	 * 数据集记录数
	 */
	public int count();
	
	/**
	 * <p>
	 * 加载数据集
	 */
	public void load();
	
	/**
	 * <p>
	 * 获取子集
	 * @param start
	 * @param offset
	 */
	public DataSet subset(int start,int offset);
}
