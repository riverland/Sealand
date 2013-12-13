package org.river.sealand.utils;

/**
 * <p>
 * 数据相关工具类
 * 
 * @author river
 * @since Dec 12, 2013
 */
public class NumberUtils {
	/**
	 * <p>
	 * 网络字节序,高位高地址，低位低地址
	 * 
	 * @param data
	 * @return
	 */
	public static int readInt4(byte[] data) {
		return (data[0] & 0xFF) << 24 | (data[1] & 0xFF) << 16 | (data[2] & 0xFF) << 8 | data[3] & 0xFF;
	}

	/**
	 * <p>
	 * 网络字节序,高位高地址，低位低地址
	 * 
	 * @param data
	 * @return
	 */
	public static int readInt2(byte[] data) {
		return (data[2] & 0xFF) << 8 | data[3] & 0xFF;
	}
}
