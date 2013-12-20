package org.river.sealand.proto.pack;

import org.river.sealand.proto.data.DataSet;

/**
 * <p>
 * 打包服务
 * 
 * @author river
 * @since Dec 18, 2013
 */
public interface IPackService<E> {
	/**
	 * <p>
	 * 把dataset打包为byte[]格式
	 * 
	 * @param dataset
	 * @return
	 */
	public byte[] pack(E data);

	/**
	 * <p>
	 * 解压协议包
	 * 
	 * @param data
	 * @return
	 */
	public E unpack(byte[] data);
}
