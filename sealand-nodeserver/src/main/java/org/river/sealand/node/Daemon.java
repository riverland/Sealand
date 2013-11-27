package org.river.sealand.node;


/**
 * <p>
 * 网络监听服务接口
 * @author river
 * @date 20120913
 */
public interface Daemon {
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	public void init() throws Exception;
	
	/**
	 * 启动监听服务
	 * @throws Exception
	 */
	public void start()throws Exception;
	
	/**
	 * 停止监听服务
	 * @throws Exception
	 */
	public void stop() throws Exception;
	
	/**
	 * 销毁监听服务，并释放资源
	 * @throws Exception
	 */
	public void destroy() throws Exception;
}
