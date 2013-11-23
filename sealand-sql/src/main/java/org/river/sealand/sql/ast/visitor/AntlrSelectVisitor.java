package org.river.sealand.sql.ast.visitor;

import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.river.sealand.sql.ast.ISqlStruct;
import org.river.sealand.sql.ast.Keyword;
import org.river.sealand.sql.ast.SqlExpr;
import org.river.sealand.sql.ast.SqlGroupBy;
import org.river.sealand.sql.ast.SqlLimit;
import org.river.sealand.sql.ast.SqlSelect;
import org.river.sealand.sql.ast.SqlSort;
import org.river.sealand.sql.ast.SqlUnion;

/**
 * <p>
 * 对规则select_stmt进行访问解析
 * 
 * @author river
 * @since Nov 22, 2013
 */
public class AntlrSelectVisitor extends AntlrTreeVisitor {

	@Override
	protected ISqlStruct doVisit(ParseTree tree, Parser parser) {
		Rule rule = AntlrTreeUtils.getRule(tree, parser);
		switch (rule) {
		case STATEMENT:
			return this.visitStatement(tree, parser);
		case SELECT_CLAUSE:
			return this.visitSelect(tree, parser);
		default:
			return null;
		}
	}

	/*
	 * 访问规则select_stmt
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private ISqlStruct visitStatement(ParseTree tree, Parser parser) {
		ISqlStruct stmt = null;
		int len = tree.getChildCount();
		if (len > 1) {
			SqlUnion union = new SqlUnion();

			ParseTree firstTree = tree.getChild(0);
			SqlSelect firstSel = this.visitSelect(firstTree, parser);
			union.addSelect(firstSel);

			for (int i = 1; i < len; i = +2) {
				Token unionToken = ((TerminalNode) (tree.getChild(i))).getSymbol();
				ParseTree selNode = tree.getChild(i + 1);
				SqlSelect tmpSel = this.visitSelect(selNode, parser);
				String tokenStr = unionToken.getText();
				if (tokenStr != null && tokenStr.matches(Keyword.UNION_ALL_PATTERN)) {
					tmpSel.setUnionAll(true);
				}
				union.addSelect(tmpSel);
			}
			stmt = union;
		} else {
			ParseTree firstTree = tree.getChild(0);
			stmt = this.visitSelect(firstTree, parser);
		}
		return stmt;
	}

	/*
	 * 访问规则select_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlSelect visitSelect(ParseTree tree, Parser parser) {
		SqlSelect select = new SqlSelect();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree tmp = tree.getChild(i);

			if (!(tmp instanceof RuleNode)) {
				continue;
			}
			Rule rule = AntlrTreeUtils.getRule(tree, parser);
			if (rule == Rule.SELECT_LIST) {
				select.setSelectFields(this.visitSelectList(tmp, parser));
				continue;
			}

			if (rule == Rule.TABLE_REFS) {
				select.setFromTbls(this.visitTableRefs(tmp, parser));
				continue;
			}

			if (rule == Rule.WHERE_CLAUSE) {
				select.setCriteria(this.visitWhere(tmp, parser));
				continue;
			}

			if (rule == Rule.GROUP_BY_CLAUSE) {
				select.setGroupBy(this.visitGroupBy(tmp, parser));
				continue;
			}

			if (rule == Rule.HAVING_CLAUSE) {
				select.setHaving(this.visithaving(tmp, parser));
				continue;
			}

			if (rule == Rule.ORDER_BY_CLAUSE) {
				select.setOrderby(this.visitOrderBy(tmp, parser));
				continue;
			}

			if (rule == Rule.LIMIT_CLAUSE) {
				select.setLimit(this.visitLimit(tmp, parser));
			}
		}
		return select;
	}

	/*
	 * 解析访问规则select_list
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private List<String> visitSelectList(ParseTree tree, Parser parser) {
		return null;
	}

	/*
	 * 解析访问规则table_refs
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private List<SqlSelect> visitTableRefs(ParseTree tree, Parser parser) {
		return null;
	}

	/*
	 * 解析访问规则where_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlExpr visitWhere(ParseTree tree, Parser parser) {
		return null;
	}

	/*
	 * 解析访问规则group_by_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlGroupBy visitGroupBy(ParseTree tree, Parser parser) {
		return null;
	}

	/*
	 * 解析访问规则having_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlExpr visithaving(ParseTree tree, Parser parser) {
		return null;
	}

	/*
	 * 解析访问规则order_by_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlSort visitOrderBy(ParseTree tree, Parser parser) {
		return null;
	}
	
	/*
	 * 解析访问规则limit_clause
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SqlLimit visitLimit(ParseTree tree, Parser parser) {
		return null;
	}

	@Override
	protected Rule getRule() {
		return Rule.STATEMENT;
	}

	@Override
	public boolean accept(ParseTree tree, Parser parser) {
		Rule rule = AntlrTreeUtils.getRule(tree, parser);
		return Rule.STATEMENT == rule || Rule.SELECT_CLAUSE == rule;
	}

}
