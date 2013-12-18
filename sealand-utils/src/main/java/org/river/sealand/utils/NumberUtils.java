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
	 * @param data
	 * @return
	 */
	public static byte[] writeInt4(int data){
		byte[] _int4buf=new byte[4];
        _int4buf[0] = (byte)(data >>> 24);
        _int4buf[1] = (byte)(data >>> 16);
        _int4buf[2] = (byte)(data >>> 8);
        _int4buf[3] = (byte)(data);
		return _int4buf;
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
	
	
	/**
	 * <p>
	 * 网络字节序,高位高地址，低位低地址
	 * @param data
	 * @return
	 */
	public static byte[] writeInt2(int data){
		byte[] _int2buf=new byte[2];
        _int2buf[0] = (byte)(data >>> 8);
        _int2buf[1] = (byte)(data);
		return _int2buf;
	}
}
