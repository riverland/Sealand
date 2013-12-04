package org.river.sealand.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * java Object工具类
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class ObjectUtils {
	private static Logger log=LoggerFactory.getLogger(ObjectUtils.class);
	
	/**
	 * <p>
	 * 把对象序列为二进制流
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static byte[] write(Object obj){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
		}catch(Exception e){
			log.error(e.getLocalizedMessage());
		}

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
