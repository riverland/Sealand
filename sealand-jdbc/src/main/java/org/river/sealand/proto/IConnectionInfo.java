package org.river.sealand.proto;


/**
 * <p>
 * 连接信息
 * @author river
 * @since  Dec 22, 2013
 */
public interface IConnectionInfo {
	/**
	 * <p>
	 * 获取数据库地址
	 * @return
	 */
	public String getHost();
	
	/**
	 * <p>
	 * 获取连接端口
	 * @return
	 */
	public Integer getPort();
	
	/**
	 * <p>
	 * 获取登录用户
	 * @return
	 */
	public String getUser();
	
	/**
	 * <p>
	 * 获取连接的数据库
	 * @return
	 */
	public String getDbName();
	
	/**
	 * <p>
	 * 获取协议版本
	 * @return
	 */
	public String getDbVersion();
	
	
	
}
