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
	private Map<String, IType> typeName2TypeMap = new HashMap<String, IType>();
	private Map<Integer, IType> oid2TypeMap = new HashMap<Integer, IType>();
	private Map<Integer, Integer> arrOid2BaseOidMap = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> baseOid2ArrOidMap = new HashMap<Integer, Integer>();
	private Map<Integer, Character> arrOid2DelimiterMap = new HashMap<Integer, Character>();

	public TypeMapInfo() {
		Type[] types = Type.values();
		for (Type tmp : types) {
			this.addCoreType(tmp);
		}
	}

	@Override
	public void addCoreType(IType type) {
		typeName2TypeMap.put(type.getTypeName(), type);
		typeName2SqlTypeMap.put(type.getTypeName(), type.getSqlType());
		oid2TypeMap.put(type.getOid(), type);
		arrOid2BaseOidMap.put(type.getArrayOid(), type.getOid());
		baseOid2ArrOidMap.put(type.getOid(), type.getArrayOid());
		arrOid2DelimiterMap.put(type.getArrayOid(), ',');
	}

	@Override
	public void addDataType(String type, Class<?> clazz) throws SQLException {

	}

	@Override
	public Integer getSQLType(Integer oid) throws SQLException {
		IType type = this.oid2TypeMap.get(oid);
		return type.getSqlType();
	}

	@Override
	public Integer getSQLType(String typeName) throws SQLException {
		IType type = this.typeName2TypeMap.get(typeName);
		return type.getSqlType();
	}

	@Override
	public Integer getOid(String typeName) throws SQLException {
		IType type = this.typeName2TypeMap.get(typeName);
		return type.getOid();
	}

	@Override
	public String getTypeName(Integer oid) throws SQLException {
		IType type = this.oid2TypeMap.get(oid);
		return type.getTypeName();
	}

	@Override
	public Integer getArrayBaseOid(Integer arrayOid) throws SQLException {
		return this.arrOid2BaseOidMap.get(arrayOid);
	}

	@Override
	public Integer getArrayOid(String eleTypeName) throws SQLException {
		Integer baseOid = this.getOid(eleTypeName);
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
		IType type = this.typeName2TypeMap.get(typeName);
		return type.getJavaClass();
	}

	@Override
	public Class<?> getJavaClass(Integer oid) throws SQLException {
		IType type = this.oid2TypeMap.get(oid);
		return type.getJavaClass();
	}

	@Override
	public Integer getPrecision(Integer oid, Integer typmod) {
		IType type = this.oid2TypeMap.get(oid);
		return type.getPrecision(typmod);
	}

	@Override
	public Integer getScale(Integer oid, Integer typmod) {
		IType type = this.oid2TypeMap.get(oid);
		return type.getScale(typmod);
	}

	@Override
	public boolean isCaseSensitive(Integer oid) {
		IType type = this.oid2TypeMap.get(oid);
		return type.isCaseSensitive();
	}

	@Override
	public boolean isSigned(Integer oid) {
		IType type = this.oid2TypeMap.get(oid);
		return type.isSigned();
	}

	@Override
	public Integer getDisplaySize(Integer oid, Integer typmod) {
		IType type = this.oid2TypeMap.get(oid);
		return type.getDisplaySize(typmod);
	}

	@Override
	public Integer getMaximumPrecision(Integer oid) {
		IType type = this.oid2TypeMap.get(oid);
		return type.getMaximumPrecision();
	}

	@Override
	public boolean requiresQuoting(Integer oid) throws SQLException {
		IType type = this.oid2TypeMap.get(oid);
		return type.requiresQuoting();
	}

}
