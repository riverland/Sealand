package org.river.sealand.sql.ast;

import java.util.ArrayList;

/**
 * <p>
 * 条件表达式
 * 
 * @author river
 * @since Nov 17, 2013
 */
public class SqlBoolExpr extends SqlExpr {	

	public SqlBoolExpr() {
		super();
	}

	public SqlBoolExpr(SqlExpr expr) {
		this.elements.add(expr);
	}

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SqlBoolExpr not() {
		SqlBoolExpr not = new SqlBoolExpr();
		not.elements = new ArrayList<SqlExpr>();
		not.elements.add(this);
		not.operator = SqlOperator.NOT;
		return not;
	}
	
	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public static SqlBoolExpr not(SqlExpr expr) {
		SqlBoolExpr not = new SqlBoolExpr();
		not.elements = new ArrayList<SqlExpr>();
		not.elements.add(expr);
		not.operator = SqlOperator.NOT;
		return not;
	}

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SqlBoolExpr and(SqlExpr expr) {
		if (this.operator == SqlOperator.AND) {
			this.elements.add(expr);
			return this;
		}

		SqlBoolExpr and = new SqlBoolExpr();
		and.elements = new ArrayList<SqlExpr>();
		and.elements.add(this);
		and.elements.add(expr);
		and.operator = SqlOperator.AND;

		return and;
	}
	

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SqlBoolExpr or(SqlExpr expr) {

		if (this.operator == SqlOperator.OR) {
			this.elements.add(expr);
			return this;
		}

		SqlBoolExpr or = new SqlBoolExpr();
		or.elements = new ArrayList<SqlExpr>();
		or.elements.add(this);
		or.elements.add(expr);
		or.operator = SqlOperator.OR;

		return or;
	}

}
