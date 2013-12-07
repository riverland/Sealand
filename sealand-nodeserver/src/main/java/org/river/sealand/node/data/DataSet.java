package org.river.sealand.node.data;

import java.sql.ResultSet;
import java.util.List;
/**
 * <p>
 * 内部数据集对象
 * @author river
 * @since  Dec 6, 2013
 */
public interface DataSet extends ResultSet {
	/**
	 * <p>
	 * 获取数据集的别名
	 * @return
	 */
	public String getAlias();
	
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
	
	/**
	 * <p>
	 * 添加记录
	 */
	public void addRecord(String rec);
	
	/**
	 * 添加所有记录
	 * @param recs
	 */
	public void addAll(List<String> recs);
	
	/**
	 * <p>
	 * 获取数据类型
	 * @param label
	 * @return
	 */
	public DataType getDataType(String label);
	
	/**
	 * <p>
	 * 获取数据类型
	 * @param label
	 * @return
	 */
	public DataType getDataType(int colIndex);
	
	/**
	 * <p>
	 * 获取所有列名
	 * @return
	 */
	public List<String> allColLables();
	
	/**
	 * <p>
	 * 获取指定记录
	 * @return
	 */
	public String getRecord(int i);
	
	/**
	 * <p>
	 * 获取指定记录
	 * @return
	 */
	public String getRecord();
}
