package org.river.sealand.proto;

import java.nio.charset.Charset;

import org.river.sealand.jdbc.Version;
import org.river.sealand.jdbc.support.ConnectionState;
import org.river.sealand.jdbc.support.TransactionState;

/**
 * <p>
 * 协议连接对象
 * 
 * @author river
 * @since Dec 22, 2013
 */
public interface IProtoConnection extends IConnectionInfo {
	/**
	 * <p>
	 * 获取编码的字符集
	 * 
	 * @return
	 */
	public Charset getEncoding();

	/**
	 * <p>
	 * 获取当前连接的事务状态
	 * 
	 * @return
	 */
	public TransactionState getTransactionState();

	/**
	 * <p>
	 * 获取连接所有的异步消息
	 * 
	 * @return
	 */
	public INotification[] getNotifications();

	/**
	 * <p>
	 * 获取所采用的协议版本
	 * 
	 * @return
	 */
	public Version getProtoVersion();
	
	/**
	 * <p>
	 * 关闭当前连接
	 */
    public void close();
    
    /**
     * <p>
     * 获取连接状态
     * @return
     */
    public ConnectionState getConnectionState();
}
