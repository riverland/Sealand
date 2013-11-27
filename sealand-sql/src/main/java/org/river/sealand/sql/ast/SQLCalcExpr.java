package org.river.sealand.sql.ast;

/**
 * <p>
 * 
 * @author river
 * @since Nov 25, 2013
 */
public class SQLCalcExpr extends SQLExpr {

	/** 对应于PLUS MINUS MULTI DIV MODE */
	public SQLCalcExpr operate(SQLOperator operator, SQLExpr... args) {
		SQLCalcExpr expr = new SQLCalcExpr();
		expr.setOperator(operator);
		expr.setType(Type.COMP);
		expr.getElements().add(this);

		if (args == null || args.length == 0) {
			return expr;
		}

		for (SQLExpr tmp : args) {
			expr.elements.add(tmp);
		}
		return expr;
	}

	/**
	 * 构建函数表达式
	 * @param funcName
	 * @param args
	 * @return
	 */
	public static SQLCalcExpr function(String funcName, SQLExpr... args) {
		SQLCalcExpr func = new SQLCalcExpr();
		SQLExpr funcNameExpr = new SQLExpr(funcName);
		func.elements.add(funcNameExpr);
		func.setType(Type.FUNC);

		if (args == null || args.length == 0) {
			return func;
		}

		for (SQLExpr tmp : args) {
			func.getElements().add(tmp);
		}

		return func;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.EXPRESSION;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
