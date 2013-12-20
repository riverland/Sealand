package org.river.sealand.proto.pack;

import java.util.HashMap;
import java.util.Map;

import org.river.sealand.proto.Version;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.data.Statement;
import org.river.sealand.utils.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 协议包工具类
 * 
 * @author river
 * @since Dec 18, 2013
 */
public class PackUtils {
	private static final Logger LOG = LoggerFactory.getLogger(PackUtils.class);
	private static final Map<Version, IPackService<DataSet>> transferMap = new HashMap<Version, IPackService<DataSet>>();
	private static final Map<Version, IPackService<Statement>> stmtMap = new HashMap<Version, IPackService<Statement>>();
	
	static {
		transferMap.put(Version.V1_0, new TransferPackService());
		stmtMap.put(Version.V1_0, new StatementPackService());
	}

	/**
	 * <p>
	 * 数据传输包解压包打包工具方法
	 * 
	 * @param dataSet
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public static byte[] pack4Transfer(DataSet dataSet, Version v) throws SQLException {
		TransferPackService packService = (TransferPackService) transferMap.get(v);
		if (packService == null) {
			String msg = "protocol version[" + v.name() + "] is not supported";
			LOG.error(msg);
			throw new SQLException(msg);
		}
		return packService.pack(dataSet);
	}

	/**
	 * <p>
	 * 数据传输包解压包打包工具方法
	 * 
	 * @param dataSet
	 * @param v
	 * @return
	 * @throws SQLException
	 */
	public static DataSet unpack4Transfer(byte[] data, Version v) throws SQLException {
		TransferPackService packService = (TransferPackService) transferMap.get(v);
		if (packService == null) {
			String msg = "protocol version[" + v.name() + "] is not supported";
			LOG.error(msg);
			throw new SQLException(msg);
		}
		return packService.unpack(data);
	}
	
	/**
	 * <p>
	 * 打包stmt
	 * @param stmt
	 * @param v
	 * @return
	 * @throws SQLException 
	 */
	public static byte[] pack4stmt(Statement stmt, Version v) throws SQLException{
		StatementPackService packService = (StatementPackService) stmtMap.get(v);
		if (packService == null) {
			String msg = "protocol version[" + v.name() + "] is not supported";
			LOG.error(msg);
			throw new SQLException(msg);
		}
		return packService.pack(stmt);
	}
	
	/**
	 * <p>
	 * 解包
	 * @param data
	 * @return
	 * @throws SQLException 
	 */
	public static Statement unpack4stmt(byte[] data,Version v) throws SQLException{
		StatementPackService packService = (StatementPackService) stmtMap.get(v);
		if (packService == null) {
			String msg = "protocol version[" + v.name() + "] is not supported";
			LOG.error(msg);
			throw new SQLException(msg);
		}
		return packService.unpack(data);
	}
}
