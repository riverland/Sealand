package org.river.sealand.sql.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 条件表达式
 * 
 * @author river
 * @since Nov 17, 2013
 */
public class SqlExpr implements ISqlStruct {
	/** 表达式的操作数 */
	private List<SqlExpr> elements = new ArrayList<SqlExpr>();

	/** 表达式类型 */
	private Type type;

	/** 表达式值，该值只有类型是VARIABLE 或VALUE,FUNC才会有值,值可以为函数表达式，数字，字符串，列名,子查询等 */
	private Object value;

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SqlExpr not() {
		this.checkSupport(this);
		SqlExpr not = new SqlExpr();
		not.elements = new ArrayList<SqlExpr>();
		not.elements.add(this);
		not.type = Type.NOT;
		return not;
	}

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SqlExpr and(SqlExpr expr) {
		this.checkSupport(this);
		this.checkSupport(expr);

		if (this.type == Type.AND) {
			this.elements.add(expr);
			return this;
		}

		SqlExpr and = new SqlExpr();
		and.elements = new ArrayList<SqlExpr>();
		and.elements.add(this);
		and.elements.add(expr);
		and.type = Type.AND;

		return and;
	}

	/**
	 * <p>
	 * 当前参数expr做非操作
	 * 
	 * @param expr
	 * @return
	 */
	public SqlExpr or(SqlExpr expr) {
		this.checkSupport(this);
		this.checkSupport(expr);

		if (this.type == Type.OR) {
			this.elements.add(expr);
			return this;
		}

		SqlExpr or = new SqlExpr();
		or.elements = new ArrayList<SqlExpr>();
		or.elements.add(this);
		or.elements.add(expr);
		or.type = Type.OR;

		return or;
	}

	private void checkSupport(SqlExpr expr) {
		if (expr == null || expr.type == Type.VALUE || expr.type == Type.VARIABLE || expr.type == Type.FUNC) {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * <p>
	 * 表达式类型
	 */
	public static enum Type {
		NOT, AND, OR, GRP, IN, EXIST, BETWEEN, EQ, LT, GT, GE, LE, NE, LIKE, VARIABLE, COLUMN, VALUE, FUNC, SUBSELECT;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.EXPRESSION;
	}

	public List<SqlExpr> getElements() {
		return elements;
	}

	public Type getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

	public void setElements(List<SqlExpr> elements) {
		this.elements = elements;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
