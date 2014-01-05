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
		byte[] trim=new byte[4];
		if(data.length>4){
			System.arraycopy(data, data.length-4, trim, 0, 4);
		}else{
			System.arraycopy(data, 0, trim, 0, 4);
		}
		return (trim[0] & 0xFF) << 24 | (trim[1] & 0xFF) << 16 | (trim[2] & 0xFF) << 8 | trim[3] & 0xFF;
	}

	/**
	 * <p>
	 * 网络字节序,高位高地址，低位低地址
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] writeInt4(int data) {
		byte[] _int4buf = new byte[4];
		_int4buf[0] = (byte) (data >>> 24);
		_int4buf[1] = (byte) (data >>> 16);
		_int4buf[2] = (byte) (data >>> 8);
		_int4buf[3] = (byte) (data);
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
		byte[] trim=new byte[2];
		if(data.length>2){
			System.arraycopy(data, data.length-2, trim, 0, 2);
		}else{
			System.arraycopy(data, 0, trim, 0, 2);
		}
		return (trim[0] & 0xFF) << 8 | trim[1] & 0xFF;
	}

	/**
	 * <p>
	 * 网络字节序,高位高地址，低位低地址
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] writeInt2(int data) {
		byte[] _int2buf = new byte[2];
		_int2buf[0] = (byte) (data >>> 8);
		_int2buf[1] = (byte) (data);
		return _int2buf;
	}

	/**
	 * <p>
	 * 网络字节序,高位高地址，低位低地址
	 * 
	 * @param data
	 * @return
	 */
	public static long readInt8(byte[] data) {
		byte[] trim=new byte[8];
		if(data.length>2){
			System.arraycopy(data, data.length-8, trim, 0, 8);
		}else{
			System.arraycopy(data, 0, trim, 0, 8);
		}
		return (trim[0] & 0xFF) << 56 | (trim[1] & 0xFF) << 48 | (trim[2] & 0xFF) << 40 | (trim[3] & 0xFF) << 32 | (trim[4] & 0xFF) << 24 | (trim[5] & 0xFF) << 16 | (trim[6] & 0xFF) << 8
				| (trim[7] & 0xFF);
	}
	
	/**
	 * <p>
	 * 读取float数据
	 * @param data
	 * @return
	 */
	public static float readFloat(byte[] data){
		return 0;
	}
}
