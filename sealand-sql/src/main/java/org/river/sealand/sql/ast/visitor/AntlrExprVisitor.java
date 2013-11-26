package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.river.sealand.sql.ast.Keyword;
import org.river.sealand.sql.ast.SqlCalcExpr;
import org.river.sealand.sql.ast.SqlExpr.Type;
import org.river.sealand.sql.ast.SqlOperator;
import org.river.sealand.sql.util.SQLException;

/**
 * <p>
 * 对规则expression进行访问解析
 * 
 * @author river
 * @since Nov 25, 2013
 */
public class AntlrExprVisitor extends AntlrTreeVisitor {

	@Override
	protected SqlCalcExpr doVisit(ParseTree tree, Parser parser) throws SQLException {

		int firstIndex = 0;
		ParseTree firstExpr = tree.getChild(firstIndex);
		while ((firstExpr instanceof TerminalNode) && firstIndex < tree.getChildCount()) {
			String token = ((TerminalNode) firstExpr).getText();
			if (Keyword.LPAREN.equals(token)) {
				firstIndex++;
				firstExpr = tree.getChild(firstIndex);
			} else {
				break;
			}
		}
		
		Rule firstRule = AntlrTreeUtils.getRule(firstExpr, parser);
		if (firstRule == Rule.NUMBER) {
			return this.visitNumber(firstExpr, parser);
		} else if (firstRule == Rule.CHAR_LITERAL) {
			return this.visitString(firstExpr, parser);
		} else if (firstRule == Rule.SQL_ID) {
			return this.visitSqlIdExpr(firstExpr, parser);
		}

		SqlCalcExpr calc = (SqlCalcExpr) this.visit(firstExpr, parser);
		for (int i = firstIndex+1; i < tree.getChildCount(); i += 2) {
			ParseTree node = tree.getChild(i);
			String operator = ((TerminalNode) node).getText();
			SqlCalcExpr tmp = (SqlCalcExpr) this.visit(tree.getChild(i + 1), parser);
			if (SqlOperator.PLUS.getValue().equals(operator)) {
				calc = calc.operate(SqlOperator.PLUS, tmp);
			} else if (SqlOperator.MINUS.getValue().equals(operator)) {
				calc = calc.operate(SqlOperator.MINUS, tmp);
			} else if (SqlOperator.MULTI.getValue().equals(operator)) {
				calc = calc.operate(SqlOperator.MULTI, tmp);
			} else if (SqlOperator.DIV.getValue().equals(operator)) {
				calc = calc.operate(SqlOperator.DIV, tmp);
			} else if (SqlOperator.MOD.getValue().equals(operator)) {
				calc = calc.operate(SqlOperator.MOD, tmp);
			}
		}

		return calc;
	}

	/*
	 * 解析规则number表达式
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlCalcExpr visitNumber(ParseTree tree, Parser parser) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String text = ((TerminalNode) node).getText();
			sb.append(text.trim());
		}

		String numberStr = sb.toString();
		SqlCalcExpr expr = new SqlCalcExpr();
		expr.setType(Type.VALUE);
		if (numberStr.indexOf(".") > 0) {
			expr.setValue(Double.valueOf(numberStr));
		} else {
			expr.setValue(Integer.valueOf(numberStr));
		}

		return expr;
	}

	/*
	 * 解析规则char_literal表达式
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlCalcExpr visitString(ParseTree tree, Parser parser) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String text = ((TerminalNode) node).getText();
			sb.append(text.trim());
		}

		String numberStr = sb.toString();
		SqlCalcExpr expr = new SqlCalcExpr();
		expr.setType(Type.VALUE);
		expr.setValue(numberStr);

		return expr;
	}

	/*
	 * 解析规则sql_id表达式
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlCalcExpr visitSqlIdExpr(ParseTree tree, Parser parser) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String text = ((TerminalNode) node).getText();
			sb.append(text.trim());
		}

		String numberStr = sb.toString();
		SqlCalcExpr expr = new SqlCalcExpr();
		expr.setType(Type.VARIABLE);
		expr.setValue(numberStr);

		return expr;
	}

	@Override
	protected Rule getRule() {
		return Rule.EXPRESSION;
	}

}
