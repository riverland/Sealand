package org.river.sealand.metainfo;

import java.util.List;

/**
 * <p>
 * 元数据服务
 * @author river
 * @since  Nov 27, 2013
 */
public interface IMetaDataService {
	
	/**
	 * <p>
	 * 判断表是否为全局表
	 * @param tabName
	 * @return
	 */
	public boolean isGlobal(String tabName);
	
	/**
	 * <p>
	 * 获取表列名
	 * @param tabName
	 * @return
	 */
	public List<String> getColumnNames(String tabName);
	
	
}
