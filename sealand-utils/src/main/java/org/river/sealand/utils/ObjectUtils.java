package org.river.sealand.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>
 * java Object工具类
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class ObjectUtils {
	/**
	 * <p>
	 * 把对象序列为二进制流
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static byte[] write(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		return baos.toByteArray();
	}

	/**
	 * <p>
	 * 从二进制流中实例化对象
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public static Object read(byte[] arr) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(arr);
		ObjectInputStream ins = new ObjectInputStream(bais);
		return ins.readObject();
	}
}
