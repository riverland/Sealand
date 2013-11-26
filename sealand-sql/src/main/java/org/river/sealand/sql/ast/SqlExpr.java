package org.river.sealand.sql.ast;

import java.util.ArrayList;
import java.util.List;

public class SqlExpr implements ISqlStruct {

	/** 表达式的操作数 */
	protected List<SqlExpr> elements = new ArrayList<SqlExpr>();

	/** 操作类型 */
	protected SqlOperator operator;

	/** 表达式类型 */
	protected Type type;
	
	/**值类型，变量类型*/
	protected Object value;	

	public SqlExpr() {
		super();
	}

	public SqlExpr(Object value) {
		super();
		this.value = value;
		this.type=Type.VALUE;
	}

	public List<SqlExpr> getElements() {
		return elements;
	}

	public void setElements(List<SqlExpr> elements) {
		this.elements = elements;
	}

	public SqlOperator getOperator() {
		return operator;
	}

	public void setOperator(SqlOperator operator) {
		this.operator = operator;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}	
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static enum Type {
		FUNC, VALUE, COMP,VARIABLE;
	}
	
	@Override
	public SqlType getSqlType() {
		return SqlType.EXPRESSION;
	}

}
