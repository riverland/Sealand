package org.river.sealand.proto;

import java.sql.SQLException;
import java.util.Map;

/**
 * <p>
 * 数据类型映射实现
 * 
 * @author river
 * @since Dec 28, 2013
 */
public class TypeMapInfo implements ITypeInfo {

	private Map<String, Integer> typeName2SqlTypeMap;
	private Map<String, Class<?>> typeName2ClazzMap;
	private Map<String, Integer> typeName2OidMap; 
	private Map<String, Integer> oid2TypeNameMap;
	private Map<Integer,Integer> arrOid2BaseOidMap;
	private Map<Integer,Integer> arrOid2DelimiterMap;

	@Override
	public void addCoreType(String typeName, Integer oid, Integer sqlType, String javaClass, Integer arrayOid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDataType(String type, Class<?> clazz) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSQLType(int oid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSQLType(String typeName) throws SQLException {
		return 0;
	}

	@Override
	public int getOid(String typeName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTypeName(int oid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArrayBaseOid(int arrayOid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArrayOid(String eleTypeName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getArrayDelimiter(int oid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> getTypeName2SqlTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getJavaClass(String typeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJavaClass(int oid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrecision(int oid, int typmod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScale(int oid, int typmod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCaseSensitive(int oid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSigned(int oid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDisplaySize(int oid, int typmod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximumPrecision(int oid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean requiresQuoting(int oid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
