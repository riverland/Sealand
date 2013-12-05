package org.river.sealand.metainfo;

import java.util.List;

/**
 * <p>
 * 节点服务器相关的元数据服务接口
 * 
 * @author river
 * @since Nov 30, 2013
 */
public interface IMetaNodeInfoService {

	/**
	 * <p>
	 * 注册服务节点
	 * 
	 * @param svrNode
	 */
	public void register(Server svrNode);
	
	/**
	 * <p>
	 * 获取已经注册的节点
	 * @return
	 */
	public List<Server> getRegisteredNodes();
}
