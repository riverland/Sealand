package org.river.sealand.node.algorithm;

import java.util.List;

import org.river.sealand.node.data.DataType;


/**
 * <p>
 * 聚合算法接口,所有实现都非线程安全
 * @author river
 * @since  Dec 10, 2013
 */
public interface IAggregateAlgorithm {
	
	/**
	 * <p>
	 * 计算出最终结果
	 * @return
	 */
	public String getResult();
	
	/**
	 * <p>
	 * 添加数据
	 * @param datas
	 */
	public void addSrcData(DataType dataType,List<Object> datas);
	
	/**
	 * <p>
	 * 添加数据
	 * @param datas
	 */
	public void addSrcData(DataType dataType,Object ... datas);
}
