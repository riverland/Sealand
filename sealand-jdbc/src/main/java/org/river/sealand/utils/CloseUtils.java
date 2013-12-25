package org.river.sealand.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
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

	/**
	 * <p>
	 * 关闭socket连接
	 * 
	 * @param sc
	 */
	public static void close(Socket sc) {
		if (sc == null) {
			return;
		}

		try {
			sc.close();
		} catch (Throwable e) {
			// do nothing
		}
	}

	/**
	 * <p>
	 * 关闭输入流
	 * 
	 * @param sc
	 */
	public static void close(InputStream ins) {
		if (ins == null) {
			return;
		}

		try {
			ins.close();
		} catch (Throwable e) {
			// do nothing
		}
	}

	/**
	 * <p>
	 * 关闭输入流
	 * 
	 * @param sc
	 */
	public static void close(OutputStream os) {
		if (os == null) {
			return;
		}

		try {
			os.close();
		} catch (Throwable e) {
			// do nothing
		}
	}
	
}
