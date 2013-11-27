package org.river.sealand.sql.ast;

import java.util.ArrayList;
import java.util.List;

public class SQLExpr implements ISqlStruct {

	/** 表达式的操作数 */
	protected List<SQLExpr> elements = new ArrayList<SQLExpr>();

	/** 操作类型 */
	protected SQLOperator operator;

	/** 表达式类型 */
	protected Type type;

	/** 值类型，变量类型 */
	protected Object value;

	public SQLExpr() {
		super();
	}

	public SQLExpr(Object value) {
		super();
		this.value = value;
		this.type = Type.VALUE;
	}

	public List<SQLExpr> getElements() {
		return elements;
	}

	public void setElements(List<SQLExpr> elements) {
		this.elements = elements;
	}

	public SQLOperator getOperator() {
		return operator;
	}

	public void setOperator(SQLOperator operator) {
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
		FUNC, VALUE, COMP, VARIABLE;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.EXPRESSION;
	}

	@Override
	public String toString() {
		switch (this.type) {
		case VALUE:{
			if(value instanceof Number){
				return value.toString();
			}else{
				return "'" + value.toString() + "'";
			}			
		}			
		case VARIABLE:
			return value.toString();
		case FUNC: {
			StringBuffer sb = new StringBuffer();
			SQLExpr first = elements.get(0);
			sb.append(first.toString());
			sb.append("(");
			int size = elements.size();
			if (size > 1) {
				boolean flag = true;
				for (int i = 1; i < size; i++) {
					if (!flag) {
						sb.append(",").append(elements.get(i).toString());
					} else {
						sb.append(elements.get(i).toString());
						flag = false;
					}

				}
			}
			sb.append(")");

			return sb.toString();
		}
		case COMP:
			return "("+this.compExprToString()+")";
		default:
			return null;
		}

	}

	private String compExprToString() {
		switch (this.operator) {
		case NOT:
			return SQLOperator.NOT.getValue()+" ("+elements.get(0).toString()+")";
		case BETWEEN:
			return elements.get(0).toString()+" "+Keyword.BETWEEN+" ("+elements.get(1).toString()+") AND ("+elements.get(2).toString()+")";
		case IN:{
			StringBuffer sb=new StringBuffer(elements.get(0).toString()).append(" ");
			sb.append("IN").append(" (");
			boolean flag=true;
			for(int i=1;i<elements.size();i++){
				if (!flag) {
					sb.append(",").append(elements.get(i).toString());
				} else {
					sb.append(elements.get(i).toString());
					flag = false;
				}
			}
			sb.append(")");
			return sb.toString();
		}			
		case EXIST:
			return Keyword.EXIST+ "("+elements.get(0).toString()+")";
		default:{
			return elements.get(0).toString()+" "+this.operator.getValue()+" "+elements.get(1).toString();
		}
		}
	}

}
