package org.river.sealand.sql.ast;

/**
 * <p>
 * sql中出现的操作类型
 * @author river
 * @since  Nov 25, 2013
 */
public enum SQLOperator implements ISqlStruct {
	
	NOT("NOT"),
	AND("AND"), 
	OR("OR"), 
	IN("IN"),
	EXIST("EXIST"), 
	BETWEEN("BETWEEN"), 
	EQ("="), 
	LT("<"), 
	GT(">"), 
	GE(">="), 
	LE("<="), 
	NE("<>"), 
	LIKE("LIKE"),
	PLUS("+"),
	MINUS("-"),
	MULTI("*"),
	DIV("/"),
	MOD("%"),
	FUNC("FUNC");

	private String value;
	
	public String getValue(){
		return this.value;
	}
	
	
	private SQLOperator(String value) {
		this.value = value;
	}


	@Override
	public SqlType getSqlType() {
		return SqlType.EXPRESSION;
	}

}
