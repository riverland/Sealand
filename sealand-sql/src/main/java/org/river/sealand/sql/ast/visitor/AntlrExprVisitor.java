package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.river.sealand.sql.ast.Keyword;
import org.river.sealand.sql.ast.SQLCalcExpr;
import org.river.sealand.sql.ast.SQLExpr.Type;
import org.river.sealand.sql.ast.SQLOperator;
import org.river.sealand.utils.SQLException;

/**
 * <p>
 * 对规则expression进行访问解析
 * 
 * @author river
 * @since Nov 25, 2013
 */
public class AntlrExprVisitor extends AntlrTreeVisitor {

	@Override
	protected SQLCalcExpr doVisit(ParseTree tree, Parser parser) throws SQLException {

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

		SQLCalcExpr calc = (SQLCalcExpr) this.visit(firstExpr, parser);
		for (int i = firstIndex+1; i < tree.getChildCount(); i += 2) {
			ParseTree node = tree.getChild(i);
			String operator = ((TerminalNode) node).getText();
			SQLCalcExpr tmp = (SQLCalcExpr) this.visit(tree.getChild(i + 1), parser);
			if (SQLOperator.PLUS.getValue().equals(operator)) {
				calc = calc.operate(SQLOperator.PLUS, tmp);
			} else if (SQLOperator.MINUS.getValue().equals(operator)) {
				calc = calc.operate(SQLOperator.MINUS, tmp);
			} else if (SQLOperator.MULTI.getValue().equals(operator)) {
				calc = calc.operate(SQLOperator.MULTI, tmp);
			} else if (SQLOperator.DIV.getValue().equals(operator)) {
				calc = calc.operate(SQLOperator.DIV, tmp);
			} else if (SQLOperator.MOD.getValue().equals(operator)) {
				calc = calc.operate(SQLOperator.MOD, tmp);
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
	private SQLCalcExpr visitNumber(ParseTree tree, Parser parser) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String text = ((TerminalNode) node).getText();
			sb.append(text.trim());
		}

		String numberStr = sb.toString();
		SQLCalcExpr expr = new SQLCalcExpr();
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
	private SQLCalcExpr visitString(ParseTree tree, Parser parser) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String text = ((TerminalNode) node).getText();
			sb.append(text.trim());
		}

		String numberStr = sb.toString();
		SQLCalcExpr expr = new SQLCalcExpr();
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
	private SQLCalcExpr visitSqlIdExpr(ParseTree tree, Parser parser) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String text = ((TerminalNode) node).getText();
			sb.append(text.trim());
		}

		String numberStr = sb.toString();
		SQLCalcExpr expr = new SQLCalcExpr();
		expr.setType(Type.VARIABLE);
		expr.setValue(numberStr);

		return expr;
	}

	@Override
	protected Rule getRule() {
		return Rule.EXPRESSION;
	}

}
