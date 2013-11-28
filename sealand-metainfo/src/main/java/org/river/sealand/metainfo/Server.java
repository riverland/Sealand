package org.river.sealand.metainfo;
/**
 * <p>
 * 计算服务节点
 * @author river
 * @since  Nov 28, 2013
 */
public class Server {
	/**节点编码，唯一*/
	private String code;
	
	/**节点IP地址*/
	private String ip;
	
	/**节点服务端口*/
	private int port;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
