package org.river.sealand.metainfo;

/**
 * <p>
 * 节点服务器相关的元数据服务接口
 * 
 * @author river
 * @since Nov 30, 2013
 */
public interface ImetaNodeInfoService {

	/**
	 * <p>
	 * 注册服务节点
	 * 
	 * @param svrNode
	 */
	public void register(Server svrNode);
}
