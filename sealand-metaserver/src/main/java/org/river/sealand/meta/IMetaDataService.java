package org.river.sealand.meta;

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
}
