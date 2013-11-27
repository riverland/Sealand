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
public class SQLUpdate implements ISqlStruct {
	/** update 操作的表 */
	private String tableName;;

	/** update 列表,String:左值列名 SqlBoolExpression:右值表达式 */
	private Map<String, SQLBoolExpr> sets = new HashMap<String, SQLBoolExpr>();

	/** 条件表达式 */
	private SQLBoolExpr where;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, SQLBoolExpr> getSets() {
		return sets;
	}

	public void setSets(Map<String, SQLBoolExpr> sets) {
		this.sets = sets;
	}

	public SQLBoolExpr getWhere() {
		return where;
	}

	public void setWhere(SQLBoolExpr where) {
		this.where = where;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.UPDATE;
	}
}
