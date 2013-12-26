package org.river.sealand.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>
 * Statement 抽象类
 * 
 * @author river
 * @since Dec 26, 2013
 */
public abstract class AbstractStatement implements Statement {

	protected int maxFieldSize;
	protected int maxRows;
	protected int queryTimeout;
	protected int fetchSize;
	protected int fetchDirection;
	protected Connection con;
	protected boolean poolable;

	@Override
	public int getMaxFieldSize() throws SQLException {
		return maxFieldSize;
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		this.maxFieldSize = max;
	}

	@Override
	public int getMaxRows() throws SQLException {
		return this.maxRows;
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		this.maxRows = max;
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		this.fetchDirection = direction;
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return this.fetchDirection;
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		this.fetchSize = rows;
	}

	@Override
	public int getFetchSize() throws SQLException {
		return this.fetchSize;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return this.con;
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		this.poolable = poolable;
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return poolable;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		if (iface.isAssignableFrom(getClass())) {
			return (T) this;
		}

		throw new SQLException("Cannot unwrap to " + iface.getName());
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return iface.isAssignableFrom(getClass());
	}
}
