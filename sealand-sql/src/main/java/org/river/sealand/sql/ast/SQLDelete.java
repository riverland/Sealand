package org.river.sealand.sql.ast;

/**
 * <p>
 * 删除语句
 * 
 * @author river
 * @since Nov 18, 2013
 */
public class SQLDelete implements ISqlStruct{
	private String tableName;

	private SQLBoolExpr where;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public SQLBoolExpr getWhere() {
		return where;
	}

	public void setWhere(SQLBoolExpr where) {
		this.where = where;
	}

	@Override
	public SqlType getSqlType() {
		
		return SqlType.DELETE;
	}

}
