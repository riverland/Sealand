package org.river.sealand.meta.handler;

/**
 * <p>
 * 请求报文异步处理接口
 * @author river
 * @since  Nov 28, 2013
 */
public interface IAsyncHandler {
	
	/**
	 * <p>
	 * 请求报文异步处理接口
	 * @param data
	 * @return
	 */
	public void handle(byte[] data);
}
