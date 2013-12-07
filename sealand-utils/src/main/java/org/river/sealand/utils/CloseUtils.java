package org.river.sealand.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <p>
 * 关闭工具类
 * 
 * @author river
 * @since Dec 7, 2013
 */
public class CloseUtils {
	/**
	 * <p>
	 * 关闭数据库连接
	 * 
	 * @param con
	 */
	public static void close(Connection con) {
		if (con == null) {
			return;
		}
		
		try {
			con.close();
		} catch (Throwable e) {
			// do nothing
		}
	}
	
	/**
	 * <p>
	 * 关闭数据库连接Statement
	 * 
	 * @param con
	 */
	public static void close(Statement stmt) {
		if (stmt == null) {
			return;
		}
		
		try {
			stmt.close();
		} catch (Throwable e) {
			// do nothing
		}
	}
	
	/**
	 * <p>
	 * 关闭数据库连接Statement
	 * 
	 * @param con
	 */
	public static void close(ResultSet rs) {
		if (rs == null) {
			return;
		}
		
		try {
			rs.close();
		} catch (Throwable e) {
			// do nothing
		}
	}
}
