package org.river.sealand.sql.ast;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * update 子句
 * 
 * @author river
 * @since Nov 18, 2013
 */
public class SqlUpdate implements ISqlStruct {
	/** update 操作的表 */
	private String tableName;;

	/** update 列表,String:左值列名 SqlBoolExpression:右值表达式 */
	private Map<String, SqlBoolExpr> sets = new HashMap<String, SqlBoolExpr>();

	/** 条件表达式 */
	private SqlBoolExpr where;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, SqlBoolExpr> getSets() {
		return sets;
	}

	public void setSets(Map<String, SqlBoolExpr> sets) {
		this.sets = sets;
	}

	public SqlBoolExpr getWhere() {
		return where;
	}

	public void setWhere(SqlBoolExpr where) {
		this.where = where;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.UPDATE;
	}
}
