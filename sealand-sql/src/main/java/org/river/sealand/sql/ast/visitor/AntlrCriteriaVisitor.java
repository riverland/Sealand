package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.river.sealand.sql.ast.ASTStructUtils;
import org.river.sealand.sql.ast.Keyword;
import org.river.sealand.sql.ast.SQLBoolExpr;
import org.river.sealand.sql.ast.SQLExpr;
import org.river.sealand.sql.ast.SQLExpr.Type;
import org.river.sealand.sql.ast.SQLOperator;
import org.river.sealand.utils.SQLException;

/**
 * <p>
 * 条件语句解析访问，对应于规则criteria,主要访问where,on,having
 * 
 * @author river
 * @since Nov 24, 2013
 */
public class AntlrCriteriaVisitor extends AntlrTreeVisitor {

	@Override
	protected SQLBoolExpr doVisit(ParseTree tree, Parser parser) throws SQLException {

		ParseTree node = tree.getChild(0);
		if (node instanceof TerminalNode) {
			Token token = ((TerminalNode) node).getSymbol();
			String tokenStr = token.getText();
			if (tokenStr != null && token.equals(Keyword.LPAREN)) {
				return this.doVisit(tree.getChild(1), parser);
			} else if (tokenStr != null && Keyword.NOT.equals(tokenStr.trim().toUpperCase())) {
				return this.visitNotToken(tree, parser);
			}
		}

		Rule rule = AntlrTreeUtils.getRule(node, parser);
		if (rule == Rule.CRITERIA) {
			return this.visitGroup(tree, parser);
		} else if (rule == Rule.EXPRESSION) {
			return new SQLBoolExpr(this.visitOperate(tree, parser));
		} else if (rule == Rule.BETWEEN_EXPR) {
			return new SQLBoolExpr(this.visitBetweenExpr(tree, parser));
		} else if (rule == Rule.IN_EXPR) {
			return new SQLBoolExpr(this.visitInExpr(tree, parser));
		} else if (rule == Rule.EXIST_EXPR) {
			return new SQLBoolExpr(this.visitExistExpr(tree, parser));
		}

		return null;
	}

	/*
	 * 解析访问NOT token
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLBoolExpr visitNotToken(ParseTree tree, Parser parser) throws SQLException {

		for (int i = 1; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule == Rule.CRITERIA) {
				return SQLBoolExpr.not(this.doVisit(node, parser));
			}
		}

		return null;
	}

	/*
	 * <p> 访问条件表达式组合
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLBoolExpr visitGroup(ParseTree tree, Parser parser) throws SQLException {
		SQLBoolExpr expr = this.doVisit(tree.getChild(0), parser);
		for (int i = 1; i < tree.getChildCount(); i = +2) {
			ParseTree op = tree.getChild(i);
			ParseTree node = tree.getChild(i);
			String operatorStr = ((TerminalNode) op).getSymbol().getText();
			SQLBoolExpr nodeExpr = this.doVisit(node, parser);

			if (SQLOperator.AND.getValue().equals(operatorStr.toUpperCase())) {
				expr = expr.and(nodeExpr);
			} else {
				expr = expr.or(nodeExpr);
			}
		}

		return expr;

	}

	/*
	 * 解析between_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLExpr visitBetweenExpr(ParseTree tree, Parser parser) throws SQLException {
		SQLExpr between = new SQLExpr();
		between.setOperator(SQLOperator.BETWEEN);
		between.setType(Type.COMP);
		IAntlrTreeVisitor visitor = ASTStructUtils.getVisitor(Rule.EXPRESSION);
		SQLExpr columnExpr = (SQLExpr) visitor.visit(tree.getChild(0), parser);
		SQLExpr firstVal = (SQLExpr) visitor.visit(tree.getChild(2), parser);
		SQLExpr sencondVal = (SQLExpr) visitor.visit(tree.getChild(4), parser);
		between.getElements().add(columnExpr);
		between.getElements().add(firstVal);
		between.getElements().add(sencondVal);
		return between;
	}

	/*
	 * 解析in_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLExpr visitInExpr(ParseTree tree, Parser parser) throws SQLException {
		boolean isInValues = false;
		for (int i = 2; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (!(node instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule == Rule.VALUE_LIST) {
				isInValues = true;
				break;
			}
		}

		if (isInValues) {
			return this.visitInValues(tree, parser);
		} else {
			return this.visitInSubQuery(tree, parser);
		}
	}

	/*
	 * 解析in_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLExpr visitInValues(ParseTree tree, Parser parser) throws SQLException {
		ParseTree valueList = null;
		for (int i = 2; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (!(node instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule == Rule.VALUE_LIST) {
				valueList = node;
				break;
			}
		}

		if (valueList == null) {
			throw new SQLException("sql syntex error: value list expected after IN");
		}

		SQLExpr expr = new SQLExpr();
		expr.setOperator(SQLOperator.IN);
		expr.setType(Type.COMP);
		for (int i = 0; i < valueList.getChildCount(); i++) {
			ParseTree tmp = valueList.getChild(i);
			if (!(tmp instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(tmp, parser);
			if (rule == Rule.EXPRESSION) {
				expr.getElements().add((SQLExpr) ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tmp, parser));
			}
		}

		return expr;
	}

	/*
	 * 解析in_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLExpr visitInSubQuery(ParseTree tree, Parser parser) throws SQLException {
		ParseTree subQuery = null;
		for (int i = 2; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (!(node instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule == Rule.SUB_QUERY) {
				subQuery = node;
				break;
			}
		}

		if (subQuery == null) {
			throw new SQLException("sql syntex error: sub_select expected after IN");
		}

		SQLExpr expr = new SQLExpr();
		expr.setOperator(SQLOperator.IN);
		expr.setType(Type.COMP);
		expr.setValue(ASTStructUtils.getVisitor(Rule.SELECT_CLAUSE).visit(subQuery, parser));

		return expr;
	}

	/*
	 * 解析exist_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLExpr visitExistExpr(ParseTree tree, Parser parser) throws SQLException {
		ParseTree subQuery = null;
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (!(node instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule == Rule.SUB_QUERY) {
				subQuery = node;
				break;
			}
		}

		if (subQuery == null) {
			throw new SQLException("sql syntex error: sub_select expected after EXIST");
		}

		SQLExpr expr = new SQLExpr();
		expr.setOperator(SQLOperator.EXIST);
		expr.setType(Type.COMP);
		expr.setValue(ASTStructUtils.getVisitor(Rule.SELECT_CLAUSE).visit(subQuery, parser));

		return expr;
	}

	/*
	 * 解析like EQ GT LT GE LE NE
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLExpr visitOperate(ParseTree tree, Parser parser) throws SQLException {
		SQLExpr left = (SQLExpr) ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(0), parser);
		SQLExpr right = (SQLExpr) ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(2), parser);
		String operatorStr = ((TerminalNode) tree.getChild(1)).getText();
		SQLExpr expr = new SQLExpr();
		expr.getElements().add(left);
		expr.getElements().add(right);
		expr.setType(Type.COMP);

		if (SQLOperator.EQ.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.EQ);
		} else if (SQLOperator.GT.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.GT);
		} else if (SQLOperator.LT.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.LT);
		} else if (SQLOperator.LE.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.LE);
		} else if (SQLOperator.GE.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.GE);
		} else if (SQLOperator.LIKE.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.LIKE);
		} else if (SQLOperator.NE.getValue().equals(operatorStr)) {
			expr.setOperator(SQLOperator.NE);
		} else{
			throw new SQLException("sql syntex error: > ,= ,< ,>= ,<= <> expected for criteria expression");
		}
		
		return expr;
	}

	@Override
	protected Rule getRule() {
		return Rule.CRITERIA;
	}

	@Override
	public boolean accept(ParseTree tree, Parser parser) {
		Rule rule = AntlrTreeUtils.getRule(tree, parser);
		return rule == Rule.CRITERIA;
	}

}
