package org.river.sealand.sql.ast;

import java.util.ArrayList;

/**
 * <p>
 * 条件表达式
 * 
 * @author river
 * @since Nov 17, 2013
 */
public class SQLBoolExpr extends SQLExpr {	

	public SQLBoolExpr() {
		super();
	}

	public SQLBoolExpr(SQLExpr expr) {
		this.elements.add(expr);
	}

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SQLBoolExpr not() {
		SQLBoolExpr not = new SQLBoolExpr();
		not.elements = new ArrayList<SQLExpr>();
		not.elements.add(this);
		not.operator = SQLOperator.NOT;
		return not;
	}
	
	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public static SQLBoolExpr not(SQLExpr expr) {
		SQLBoolExpr not = new SQLBoolExpr();
		not.elements = new ArrayList<SQLExpr>();
		not.elements.add(expr);
		not.operator = SQLOperator.NOT;
		return not;
	}

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SQLBoolExpr and(SQLExpr expr) {
		if (this.operator == SQLOperator.AND) {
			this.elements.add(expr);
			return this;
		}

		SQLBoolExpr and = new SQLBoolExpr();
		and.elements = new ArrayList<SQLExpr>();
		and.elements.add(this);
		and.elements.add(expr);
		and.operator = SQLOperator.AND;

		return and;
	}
	

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SQLBoolExpr or(SQLExpr expr) {

		if (this.operator == SQLOperator.OR) {
			this.elements.add(expr);
			return this;
		}

		SQLBoolExpr or = new SQLBoolExpr();
		or.elements = new ArrayList<SQLExpr>();
		or.elements.add(this);
		or.elements.add(expr);
		or.operator = SQLOperator.OR;

		return or;
	}

}
