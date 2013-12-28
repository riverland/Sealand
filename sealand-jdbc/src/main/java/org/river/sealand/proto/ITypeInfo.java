package org.river.sealand.proto;

import java.sql.SQLException;
import java.util.Map;

/**
 * <p>
 * 类型信息前后段映射接口,主要使前端和后端数据类型解藕，本接口参考postgresql
 * 
 * @author river
 * @since Dec 28, 2013
 */
public interface ITypeInfo {

	/**
	 * <p>
	 * 添加列型
	 * 
	 * @param typeName
	 *            类型名称
	 * @param oid
	 *            类型后端id
	 * @param sqlType
	 *            对应java.sql.Types
	 * @param javaClass
	 *            对应java类型
	 * @param arrayOid
	 */
	public void addCoreType(String typeName, Integer oid, Integer sqlType, String javaClass, Integer arrayOid);

	/**
	 * <p>
	 * 
	 * @param type
	 * @param clazz
	 * @throws SQLException
	 */
	public void addDataType(String type, Class<?> clazz) throws SQLException;

	/**
	 * <p>
	 * 获取后端数据类型oid对应的java.sql.Types
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public int getSQLType(int oid) throws SQLException;

	/**
	 * <p>
	 * 根据名称获取java.sql.Types
	 * 
	 * @param typeName
	 * @return
	 * @throws SQLException
	 */
	public int getSQLType(String typeName) throws SQLException;

	/**
	 * 根据类型名称获取Oid
	 * 
	 * @param typeName
	 * @return
	 * @throws SQLException
	 */
	public int getOid(String typeName) throws SQLException;

	/**
	 * <p>
	 * 根据oid获取类型名称
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public String getTypeName(int oid) throws SQLException;

	/**
	 * <p>
	 * 获取array的基础类型oid
	 * 
	 * @param arrayOid
	 * @return
	 * @throws SQLException
	 */
	public int getArrayBaseOid(int arrayOid) throws SQLException;

	/**
	 * <p>
	 * 获取array的oid
	 * 
	 * @param eleTypeName
	 * @return
	 * @throws SQLException
	 */
	public int getArrayOid(String eleTypeName) throws SQLException;

	/**
	 * <p>
	 * 获取array分割符
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public char getArrayDelimiter(int oid) throws SQLException;

	/**
	 * <p>
	 * 获取类型到sqlType的Map
	 * 
	 * @return
	 */
	public Map<String, Integer> getTypeName2SqlTypes();

	/**
	 * <p>
	 * 获取数据类对应的java类
	 * 
	 * @param typeName
	 * @return
	 */
	public Class<?> getJavaClass(String typeName);

	/**
	 * 获取数据类对应的java类
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public String getJavaClass(int oid) throws SQLException;

	/**
	 * 获取数据类型的精度
	 * 
	 * @param oid
	 * @param typmod
	 * @return
	 */
	public int getPrecision(int oid, int typmod);

	/**
	 * 获取数据类型的scale
	 * 
	 * @param oid
	 * @param typmod
	 * @return
	 */
	public int getScale(int oid, int typmod);

	/**
	 * <p>
	 * 该类型是否大小写敏感
	 * 
	 * @param oid
	 * @return
	 */
	public boolean isCaseSensitive(int oid);

	/**
	 * <p>
	 * 是否带符号,如数据类型的正负号
	 * 
	 * @param oid
	 * @return
	 */
	public boolean isSigned(int oid);

	/**
	 * <p>
	 * 获取显示长度
	 * 
	 * @param oid
	 * @param typmod
	 * @return
	 */
	public int getDisplaySize(int oid, int typmod);

	/**
	 * <p>
	 * 获取最大精度
	 * 
	 * @param oid
	 * @return
	 */
	public int getMaximumPrecision(int oid);

	/**
	 * 是否加引号
	 * 
	 * @param oid
	 * @return
	 * @throws SQLException
	 */
	public boolean requiresQuoting(int oid) throws SQLException;

}
