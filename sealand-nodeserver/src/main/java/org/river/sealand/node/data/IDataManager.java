package org.river.sealand.node.data;
/**
 * <p>
 * 临时数据管理
 * @author river
 * @since  Dec 7, 2013
 */
public interface IDataManager {
	/**
	 * <p>
	 * 获取本结算节点已经计算好的数据集
	 * @param dataId
	 * @return
	 */
	public DataSet getDataSet(String dataId);
	
	/**
	 * <p>
	 * 把dataSet放到IDataManager中管理
	 * @param dataId
	 * @param dataSet
	 */
	public void putDataSet(String dataId,DataSet dataSet);
}
