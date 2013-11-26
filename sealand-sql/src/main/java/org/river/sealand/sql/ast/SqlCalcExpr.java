package org.river.sealand.sql.ast;

/**
 * <p>
 * 
 * @author river
 * @since Nov 25, 2013
 */
public class SqlCalcExpr extends SqlExpr {

	/** 对应于PLUS MINUS MULTI DIV MODE */
	public SqlCalcExpr operate(SqlOperator operator, SqlExpr... args) {
		SqlCalcExpr expr = new SqlCalcExpr();
		expr.setOperator(operator);
		expr.setType(Type.COMP);
		expr.getElements().add(this);

		if (args == null || args.length == 0) {
			return expr;
		}

		for (SqlExpr tmp : args) {
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
	public static SqlCalcExpr function(String funcName, SqlExpr... args) {
		SqlCalcExpr func = new SqlCalcExpr();
		SqlExpr funcNameExpr = new SqlExpr(funcName);
		func.elements.add(funcNameExpr);
		func.setType(Type.FUNC);

		if (args == null || args.length == 0) {
			return func;
		}

		for (SqlExpr tmp : args) {
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
