package org.river.sealand.jdbc;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;

import org.river.sealand.jdbc.support.CONProperties;
import org.river.sealand.utils.Constant;
import org.river.sealand.utils.JDBCUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * sealand JDBC 驱动
 * 
 * @author river
 * @since Dec 21, 2013
 */
public class Driver implements java.sql.Driver {
	private static final Logger LOG = LoggerFactory.getLogger(Driver.class);
	static {
		try {
			java.sql.DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		LOG.debug("Connecting with URL: " + url);
		if (!url.startsWith("jdbc:postgresql:")) {
			return null;
		}

		Properties props = new Properties(info);
		props = JDBCUtils.parseUrl(url, props);
		try {
			long timeout = this.getTimeout(props);
			if (timeout <= 0) {
				return this.openConnection(url, props);
			} else {
				// TODO 超时处理
				return this.openConnection(url, props);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}

		return null;
	}

	/*
	 * 打开数据库连接
	 * 
	 * @param url
	 * 
	 * @param props
	 * 
	 * @return
	 */
	private Connection openConnection(String url, Properties props) {
		return new ConnectionImpl(url, props);
	}

	/*
	 * 获取超时时间
	 * 
	 * @param props
	 * 
	 * @return
	 */
	private long getTimeout(Properties props) {
		String timeoutStr = props.getProperty(Constant.CON_PROPS_TIMEOUT);
		long timeout = Long.parseLong(timeoutStr);
		return timeout;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return JDBCUtils.parseUrl(url, null) == null ? true : false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		Properties props = new Properties(info);
		props = JDBCUtils.parseUrl(url, props);
		CONProperties[] conInfo = CONProperties.values();
		DriverPropertyInfo[] driverProps = new DriverPropertyInfo[conInfo.length];
		for (int i = 0; i < conInfo.length; i++) {
			driverProps[i] = new DriverPropertyInfo(conInfo[i].getName(), props.getProperty(conInfo[i].getName()));
			driverProps[i].required = conInfo[i].isRequire();
			String[] dft = { conInfo[i].getDefaults() };
			driverProps[i].choices = dft;
		}
		return driverProps;
	}

	@Override
	public int getMajorVersion() {
		return Version.V2_1.getValue();
	}

	@Override
	public int getMinorVersion() {
		return Version.V1_0.getValue();
	}

	@Override
	public boolean jdbcCompliant() {
		return false;
	}

	@Override
	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
