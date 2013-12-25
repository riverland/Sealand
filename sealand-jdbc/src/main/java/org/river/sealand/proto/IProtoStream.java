package org.river.sealand.proto;

import java.io.IOException;

/**
 * <p>
 * socket 连接管理及操作类
 * 
 * @author river
 * @since Dec 23, 2013
 */
public interface IProtoStream {

	/**
	 * <p>
	 * 关闭连接流
	 */
	public void close();

	/**
	 * <p>
	 * 发送字节数组
	 * @throws IOException 
	 */
	public void send(byte[] data) throws IOException;

	/**
	 * 发送字节数组的部分
	 * 
	 * @param data
	 * @param start
	 * @param length
	 * @throws IOException 
	 */
	public void send(byte[] data, int start, int length) throws IOException;

	/**
	 * <p>
	 * 收取一条消息
	 * 
	 * @return
	 */
	public Message receive();
}
