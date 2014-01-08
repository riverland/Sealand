package org.river.sealand.jdbc.support;

import java.sql.ResultSetMetaData;

/**
 * <p>
 * 结果集列元数据
 * 
 * @author river
 * @since Jan 8, 2014
 */
public interface IResultSetAppend extends ResultSetMetaData {
	/**
	 * <p>
	 * 获取列序列号
	 * 
	 * @param label
	 * @return
	 */
	public int getColumnIndex(String label);
}
