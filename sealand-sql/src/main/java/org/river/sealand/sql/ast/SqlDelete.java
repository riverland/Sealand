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

	private SqlExpr where;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public SqlExpr getWhere() {
		return where;
	}

	public void setWhere(SqlExpr where) {
		this.where = where;
	}

	@Override
	public SqlType getSqlType() {
		
		return SqlType.DELETE;
	}

}
