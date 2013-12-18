package org.river.sealand.proto.pack;

import java.util.HashMap;
import java.util.Map;

import org.river.sealand.proto.Version;
import org.river.sealand.proto.data.DataSet;
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
	private static final Map<Version, IPackService> transferMap = new HashMap<Version, IPackService>();
	static {
		transferMap.put(Version.V1_0, new TransferPackService());
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
		IPackService packService = transferMap.get(v);
		if (packService == null) {
			String msg = "protocol version[" + v.name() + "] is not supported";
			LOG.error(msg);
			throw new SQLException(msg);
		}
		return packService.pack(dataSet);
	}
}
