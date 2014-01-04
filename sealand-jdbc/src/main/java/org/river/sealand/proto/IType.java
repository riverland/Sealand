package org.river.sealand.proto;

import java.sql.SQLException;

/**
 * <p>
 * 数据类型定义对象接口
 * @author river
 * @since  Dec 29, 2013
 */
public interface IType {
	
	/**
	 * <p>
	 * 获取类型名称
	 * @return
	 */
	public String getTypeName();
	
	/**
	 * <p>
	 * 获取类型的Oid
	 * @return
	 */
	public Integer getOid();
	
	/**
	 * 获取数据类对应的java类
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public Class<?>  getJavaClass();
	

	/**
	 * <p>
	 * 获取sqlType {@link java.sql.Types}
	 * @return
	 */
	public Integer getSqlType();

	/**
	 * <p>
	 * 获取数组Oid
	 * @return
	 */
	public Integer getArrayOid();


	/**
	 * 获取数据类型的精度
	 * 
	 * @param oid
	 * @param typmod
	 * @return
	 */
	public Integer getPrecision(int typmod);

	/**
	 * 获取数据类型的scale
	 * 
	 * @param oid
	 * @param typmod
	 * @return
	 */
	public Integer getScale(int typmod);

	/**
	 * <p>
	 * 该类型是否大小写敏感
	 * 
	 * @param oid
	 * @return
	 */
	public boolean isCaseSensitive();

	/**
	 * <p>
	 * 是否带符号,如数据类型的正负号
	 * 
	 * @param oid
	 * @return
	 */
	public boolean isSigned();

	/**
	 * <p>
	 * 获取显示长度
	 * 
	 * @param oid
	 * @param typmod
	 * @return
	 */
	public Integer getDisplaySize(int typmod);

	/**
	 * <p>
	 * 获取最大精度
	 * 
	 * @param oid
	 * @return
	 */
	public Integer getMaximumPrecision();

	/**
	 * 是否加引号
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public boolean requiresQuoting() throws SQLException;
}
