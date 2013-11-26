package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.river.sealand.sql.ast.ASTStructUtils;
import org.river.sealand.sql.ast.Keyword;
import org.river.sealand.sql.ast.SqlBoolExpr;
import org.river.sealand.sql.ast.SqlExpr;
import org.river.sealand.sql.ast.SqlExpr.Type;
import org.river.sealand.sql.ast.SqlOperator;
import org.river.sealand.sql.util.SQLException;

/**
 * <p>
 * 条件语句解析访问，对应于规则criteria,主要访问where,on,having
 * 
 * @author river
 * @since Nov 24, 2013
 */
public class AntlrCriteriaVisitor extends AntlrTreeVisitor {

	@Override
	protected SqlBoolExpr doVisit(ParseTree tree, Parser parser) throws SQLException {

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
			return new SqlBoolExpr(this.visitOperate(tree, parser));
		} else if (rule == Rule.BETWEEN_EXPR) {
			return new SqlBoolExpr(this.visitBetweenExpr(tree, parser));
		} else if (rule == Rule.IN_EXPR) {
			return new SqlBoolExpr(this.visitInExpr(tree, parser));
		} else if (rule == Rule.EXIST_EXPR) {
			return new SqlBoolExpr(this.visitExistExpr(tree, parser));
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
	private SqlBoolExpr visitNotToken(ParseTree tree, Parser parser) throws SQLException {

		for (int i = 1; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule == Rule.CRITERIA) {
				return SqlBoolExpr.not(this.doVisit(node, parser));
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
	private SqlBoolExpr visitGroup(ParseTree tree, Parser parser) throws SQLException {
		SqlBoolExpr expr = this.doVisit(tree.getChild(0), parser);
		for (int i = 1; i < tree.getChildCount(); i = +2) {
			ParseTree op = tree.getChild(i);
			ParseTree node = tree.getChild(i);
			String operatorStr = ((TerminalNode) op).getSymbol().getText();
			SqlBoolExpr nodeExpr = this.doVisit(node, parser);

			if (SqlOperator.AND.getValue().equals(operatorStr.toUpperCase())) {
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
	private SqlExpr visitBetweenExpr(ParseTree tree, Parser parser) throws SQLException {
		SqlExpr between = new SqlExpr();
		between.setOperator(SqlOperator.BETWEEN);
		between.setType(Type.COMP);
		IAntlrTreeVisitor visitor = ASTStructUtils.getVisitor(Rule.EXPRESSION);
		SqlExpr columnExpr = (SqlExpr) visitor.visit(tree.getChild(0), parser);
		SqlExpr firstVal = (SqlExpr) visitor.visit(tree.getChild(2), parser);
		SqlExpr sencondVal = (SqlExpr) visitor.visit(tree.getChild(4), parser);
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
	private SqlExpr visitInExpr(ParseTree tree, Parser parser) throws SQLException {
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
	private SqlExpr visitInValues(ParseTree tree, Parser parser) throws SQLException {
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

		SqlExpr expr = new SqlExpr();
		expr.setOperator(SqlOperator.IN);
		expr.setType(Type.COMP);
		for (int i = 0; i < valueList.getChildCount(); i++) {
			ParseTree tmp = valueList.getChild(i);
			if (!(tmp instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(tmp, parser);
			if (rule == Rule.EXPRESSION) {
				expr.getElements().add((SqlExpr) ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tmp, parser));
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
	private SqlExpr visitInSubQuery(ParseTree tree, Parser parser) throws SQLException {
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

		SqlExpr expr = new SqlExpr();
		expr.setOperator(SqlOperator.IN);
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
	private SqlExpr visitExistExpr(ParseTree tree, Parser parser) throws SQLException {
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

		SqlExpr expr = new SqlExpr();
		expr.setOperator(SqlOperator.EXIST);
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
	private SqlExpr visitOperate(ParseTree tree, Parser parser) throws SQLException {
		SqlExpr left = (SqlExpr) ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(0), parser);
		SqlExpr right = (SqlExpr) ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(2), parser);
		String operatorStr = ((TerminalNode) tree.getChild(2)).getText();
		SqlExpr expr = new SqlExpr();
		expr.getElements().add(left);
		expr.getElements().add(right);
		expr.setType(Type.COMP);

		if (SqlOperator.EQ.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.EQ);
		} else if (SqlOperator.GT.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.GT);
		} else if (SqlOperator.LT.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.LT);
		} else if (SqlOperator.LE.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.LE);
		} else if (SqlOperator.GE.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.GE);
		} else if (SqlOperator.LIKE.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.LIKE);
		} else if (SqlOperator.NE.getValue().equals(operatorStr)) {
			expr.setOperator(SqlOperator.NE);
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
		return rule == Rule.HAVING_CLAUSE || rule == Rule.WHERE_CLAUSE || rule == Rule.JOIN_CONDITION;
	}

}
