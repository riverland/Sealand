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

	/** update 列表,String:左值列名 SqlExpression:右值表达式 */
	private Map<String, SqlExpr> sets = new HashMap<String, SqlExpr>();

	/** 条件表达式 */
	private SqlExpr where;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, SqlExpr> getSets() {
		return sets;
	}

	public void setSets(Map<String, SqlExpr> sets) {
		this.sets = sets;
	}

	public SqlExpr getWhere() {
		return where;
	}

	public void setWhere(SqlExpr where) {
		this.where = where;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.UPDATE;
	}
}
