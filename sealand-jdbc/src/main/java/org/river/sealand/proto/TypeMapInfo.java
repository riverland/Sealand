package org.river.sealand.proto;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 数据类型映射实现
 * 
 * @author river
 * @since Dec 28, 2013
 */
public class TypeMapInfo implements ITypeInfo {

	private Map<String, Integer> typeName2SqlTypeMap = new HashMap<String, Integer>();
	private Map<String, Class<?>> typeName2ClazzMap = new HashMap<String, Class<?>>();
	private Map<String, Integer> typeName2OidMap = new HashMap<String, Integer>();
	private Map<Integer, String> oid2TypeNameMap = new HashMap<Integer, String>();
	private Map<Integer, Integer> arrOid2BaseOidMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> baseOid2ArrOidMap = new HashMap<Integer, Integer>();
	private Map<Integer, Character> arrOid2DelimiterMap = new HashMap<Integer, Character>();

	@Override
	public void addCoreType(String typeName, Integer oid, Integer sqlType, String javaClass, Integer arrayOid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDataType(String type, Class<?> clazz) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getSQLType(Integer oid) throws SQLException {
		String typeName = this.oid2TypeNameMap.get(oid);
		return this.typeName2SqlTypeMap.get(typeName);
	}

	@Override
	public Integer getSQLType(String typeName) throws SQLException {
		return this.typeName2SqlTypeMap.get(typeName);
	}

	@Override
	public Integer getOid(String typeName) throws SQLException {
		return this.typeName2OidMap.get(typeName);
	}

	@Override
	public String getTypeName(Integer oid) throws SQLException {
		return this.oid2TypeNameMap.get(oid);
	}

	@Override
	public Integer getArrayBaseOid(Integer arrayOid) throws SQLException {
		return this.arrOid2BaseOidMap.get(arrayOid);
	}

	@Override
	public Integer getArrayOid(String eleTypeName) throws SQLException {
		Integer baseOid=this.getOid(eleTypeName);
		return this.baseOid2ArrOidMap.get(baseOid);
	}

	@Override
	public char getArrayDelimiter(Integer oid) throws SQLException {
		return this.arrOid2DelimiterMap.get(oid);
	}

	@Override
	public Map<String, Integer> getTypeName2SqlTypes() {		
		return this.typeName2SqlTypeMap;
	}

	@Override
	public Class<?> getJavaClass(String typeName) {
		return this.typeName2ClazzMap.get(typeName);
	}

	@Override
	public Class<?> getJavaClass(Integer oid) throws SQLException {
		String typeName=this.getTypeName(oid);
		return this.typeName2ClazzMap.get(typeName);
	}

	@Override
	public Integer getPrecision(Integer oid, Integer typmod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getScale(Integer oid, Integer typmod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isCaseSensitive(Integer oid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSigned(Integer oid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getDisplaySize(Integer oid, Integer typmod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getMaximumPrecision(Integer oid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean requiresQuoting(Integer oid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
