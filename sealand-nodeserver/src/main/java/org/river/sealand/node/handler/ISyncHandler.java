package org.river.sealand.node.handler;

/**
 * <p>
 * 请求报文同步处理接口
 * @author river
 * @since  Nov 28, 2013
 */
public interface ISyncHandler {
	
	/**
	 * <p>
	 * 请求报文同步处理接口
	 * @param data
	 * @return
	 */
	public byte[] handle(byte[] data);
}
