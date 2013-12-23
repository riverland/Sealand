package org.river.sealand.proto;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.river.sealand.jdbc.Version;
import org.river.sealand.jdbc.support.CONProperties;
import org.river.sealand.jdbc.support.ConnectionState;
import org.river.sealand.jdbc.support.IParams;
import org.river.sealand.jdbc.support.IQuery;
import org.river.sealand.jdbc.support.IResultHandler;
import org.river.sealand.jdbc.support.IStmtExecutor;
import org.river.sealand.jdbc.support.TransactionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 协议相关的连接实现
 * 
 * @author river
 * @since Dec 23, 2013
 */
public class ProtoConnectionImpl implements IProtoConnection {
	private static final Logger log = LoggerFactory.getLogger(ProtoConnectionImpl.class);

	// 连接相关的元数据信息
	private String url;
	private String user;
	private String password;
	private Properties props;

	// 当前连接实例信息
	private TransactionState xaState;
	private List<INotification> notifications;
	private ConnectionState connState;
	
	// 依赖的其他业务接口
	public IStmtExecutor stmtExecutor;

	@Override
	public String getHost() {
		return props.getProperty(CONProperties.HOST.getName());
	}

	@Override
	public Integer getPort() {
		String port = props.getProperty(CONProperties.PORT.getName());
		return Integer.parseInt(port);
	}

	@Override
	public String getUser() {
		return props.getProperty(CONProperties.USER.getName());
	}

	@Override
	public String getDbName() {
		return props.getProperty(CONProperties.DBNAME.getName());
	}

	@Override
	public String getDbVersion() {
		return props.getProperty(CONProperties.PROTO_VERSION.getName());
	}

	@Override
	public Charset getEncoding() {
		String charset = props.getProperty(CONProperties.CHARSET.getName());
		return Charset.forName(charset);
	}

	@Override
	public TransactionState getTransactionState() {
		return xaState;
	}

	@Override
	public synchronized INotification[] getNotifications() {
		return notifications.toArray(new INotification[notifications.size()]);
	}

	@Override
	public Version getProtoVersion() {
		int versionNum = Integer.parseInt(props.getProperty(CONProperties.PROTO_VERSION.getName()));
		return Version.fromValue(versionNum);
	}

	@Override
	public void close() {

	}

	@Override
	public ConnectionState getConnectionState() {
		return this.connState;
	}

	@Override
	public void execute(IQuery query, IParams params, IResultHandler handler, int maxRows, int fetchSize, int flags) throws SQLException {
		this.stmtExecutor.execute(query, params, handler, maxRows, fetchSize, flags);
	}

}
