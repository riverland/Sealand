package org.river.sealand.jdbc;

import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * <p>
 * wrapper 通用实现
 * 
 * @author river
 * @since Dec 28, 2013
 */
public class JdbcWrapper implements Wrapper {

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return iface.isAssignableFrom(getClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		if (iface.isAssignableFrom(getClass())) {
			return (T) this;
		}
		throw new SQLException("Cannot unwrap to " + iface.getName());
	}

}
