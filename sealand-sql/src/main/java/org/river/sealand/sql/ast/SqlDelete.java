package org.river.sealand.sql.ast;

/**
 * <p>
 * 删除语句
 * 
 * @author river
 * @since Nov 18, 2013
 */
public class SqlDelete implements ISqlStruct{
	private String tableName;

	private SqlBoolExpr where;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public SqlBoolExpr getWhere() {
		return where;
	}

	public void setWhere(SqlBoolExpr where) {
		this.where = where;
	}

	@Override
	public SqlType getSqlType() {
		
		return SqlType.DELETE;
	}

}
