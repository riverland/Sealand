package org.river.sealand.jdbc;

/**
 * <p>
 * 连接属性
 * 
 * @author river
 * @since Dec 21, 2013
 */
public enum CONProperties {
	DBNAME("dbname","postgres",true),//连接的数据库名
	USER("user","postgres",true),//登录用户
	PASSWD("password","admin",true),//密码
	HOST("host","127.0.0.1",false),//host地址
	PORT("port","9000",false),//数据库服务器端口号
	PROTO_VERSION("protocol_version","1.0",false),//采用协议版本号
	SSL_ENABLE("ssl_enable","Y",false),//是否启用SSL
	SSL_FACTORY("ssl_factory",null,false),
	SSL_ARGS("ssl_args",null,false),
	CHARSET("charset","UTF-8",false),//采用的字符集
	LOGIN_TIMEOUT("login_timeout","-1",false),//登录超时
    SO_TIMEOUT("so_timeout","-1",false),//socket超时时间
    TCP_KEEPALIVE("tcp_keepalive","F",false),
	;
	private String name;

	private String defaults;

	private boolean require;

	private CONProperties(String name, String defaults, boolean require) {
		this.name = name;
		this.defaults = defaults;
		this.require = require;
	}

	public String getName() {
		return name;
	}

	public String getDefaults() {
		return defaults;
	}

	public boolean isRequire() {
		return require;
	}
	
	

}
