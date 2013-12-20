package org.river.sealand.node.service;

/**
 * <p>
 * metaserver调用客户端
 * @author river
 * @since  Dec 18, 2013
 */
public interface MetaServerClient {
	public void send(byte[] msg);
}
