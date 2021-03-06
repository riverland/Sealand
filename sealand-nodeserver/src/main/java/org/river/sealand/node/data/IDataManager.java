package org.river.sealand.node.data;

import org.river.sealand.node.data.IDataWatcher.DataEvent;
import org.river.sealand.proto.data.DataSet;

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
	
	/**
	 * <p>
	 * 删除数据集
	 * @param dataId
	 */
	public DataSet remove(String dataId);
	
	
	/**
	 * <p>
	 * 监听数据集
	 * @param dataId
	 * @param watcher
	 */
	public void watch(String dataId,IDataWatcher watcher);
	
	/**
	 * <p>
	 * 触发数据事件
	 * @param event
	 */
	public void fire(DataEvent event);
}
