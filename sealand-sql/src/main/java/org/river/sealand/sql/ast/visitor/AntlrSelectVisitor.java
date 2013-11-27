package org.river.sealand.sql.ast.visitor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.river.sealand.sql.ast.ASTStructUtils;
import org.river.sealand.sql.ast.ISqlStruct;
import org.river.sealand.sql.ast.Keyword;
import org.river.sealand.sql.ast.SQLBoolExpr;
import org.river.sealand.sql.ast.SQLGroupBy;
import org.river.sealand.sql.ast.SQLJoin;
import org.river.sealand.sql.ast.SQLLimit;
import org.river.sealand.sql.ast.SQLSelect;
import org.river.sealand.sql.ast.SQLSort;
import org.river.sealand.sql.ast.SQLTabReference;
import org.river.sealand.sql.ast.SQLTabReference.RefType;
import org.river.sealand.sql.ast.SQLTable;
import org.river.sealand.sql.ast.SQLUnion;
import org.river.sealand.utils.SQLException;

/**
 * <p>
 * 对规则select_stmt进行访问解析
 * 
 * @author river
 * @since Nov 22, 2013
 */
public class AntlrSelectVisitor extends AntlrTreeVisitor {

	@Override
	protected ISqlStruct doVisit(ParseTree tree, Parser parser) throws SQLException {
		Rule rule = AntlrTreeUtils.getRule(tree, parser);
		switch (rule) {
		case SELECT_STMT:
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
	private ISqlStruct visitStatement(ParseTree tree, Parser parser) throws SQLException {
		ISqlStruct stmt = null;
		int len = tree.getChildCount();
		if (len > 1) {
			SQLUnion union = new SQLUnion();

			ParseTree firstTree = tree.getChild(0);
			SQLSelect firstSel = this.visitSelect(firstTree, parser);
			union.addSelect(firstSel);

			for (int i = 1; i < len; i = +2) {
				Token unionToken = ((TerminalNode) (tree.getChild(i))).getSymbol();
				ParseTree selNode = tree.getChild(i + 1);
				SQLSelect tmpSel = this.visitSelect(selNode, parser);
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
	private SQLSelect visitSelect(ParseTree tree, Parser parser) throws SQLException {
		SQLSelect select = new SQLSelect();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree tmp = tree.getChild(i);

			if (!(tmp instanceof RuleNode)) {
				continue;
			}
			Rule rule = AntlrTreeUtils.getRule(tmp, parser);
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
				select.setHaving(this.visitHaving(tmp, parser));
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
	private List<String> visitSelectList(ParseTree tree, Parser parser) throws SQLException {
		List<String> columns = new ArrayList<String>();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (!(node instanceof RuleNode)) {
				continue;
			}

			Rule rule = AntlrTreeUtils.getRule(node, parser);
			if (rule != Rule.DISPLAY_COLUMN) {
				continue;
			}

			columns.add(this.visitDisplayColumn(node, parser));
		}
		return columns;
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
	private List<SQLTabReference> visitTableRefs(ParseTree tree, Parser parser) throws SQLException {
		List<SQLTabReference> refs = new ArrayList<SQLTabReference>();

		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (!(node instanceof RuleNode)) {
				continue;
			}

			refs.add(this.visitTableAtom(node, parser));
		}
		return refs;
	}

	/*
	 * 解析访问规则table_atom
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLTabReference visitTableAtom(ParseTree tree, Parser parser) throws SQLException {

		ParseTree node = tree.getChild(0);
		if (!(node instanceof RuleNode)) {
			return null;
		}

		Rule rule = AntlrTreeUtils.getRule(node, parser);
		if (rule == Rule.SQL_ID) {
			return this.visitTableAtom4Table(tree, parser);
		} else if (rule == Rule.SUB_QUERY) {
			return this.visitTableAtom4SubQuery(tree, parser);
		} else if (rule == Rule.TABLE_ATOM) {
			return this.visitTableAtom4Join(tree, parser);
		}

		return null;
	}

	/*
	 * 解析访问规则table_atom
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLTabReference visitTableAtom4Table(ParseTree tree, Parser parser) {
		SQLTabReference ref = new SQLTabReference();

		ParseTree child0 = tree.getChild(0);
		SQLTable tab = new SQLTable();
		tab.setTableName(this.visitSqlId(child0, parser));
		ref.setRef(tab);
		ref.setRefType(RefType.TABLE);

		final int count = tree.getChildCount();
		if (count == 2) {
			ParseTree child1 = tree.getChild(1);
			ref.setAlias(this.visitSqlId(child1, parser));
		} else if (count == 3) {
			ParseTree child2 = tree.getChild(2);
			ref.setAlias(this.visitSqlId(child2, parser));
		}

		return ref;
	}

	/*
	 * 解析访问规则table_atom
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLTabReference visitTableAtom4Join(ParseTree tree, Parser parser) throws SQLException {
		SQLTabReference ref = new SQLTabReference();
		ref.setRefType(RefType.JOIN);
		SQLJoin join = new SQLJoin();
		ref.setRef(join);
		join.setLeft(this.visitTableAtom(tree.getChild(0), parser));
		join.setOn(this.visitWhere(tree, parser));
		join.setRight(this.visitTableAtom(tree.getChild(2), parser));
		return ref;
	}

	/*
	 * 解析访问规则table_atom
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private SQLTabReference visitTableAtom4SubQuery(ParseTree tree, Parser parser) throws SQLException {
		SQLTabReference ref = new SQLTabReference();
		ref.setRefType(RefType.SUB_SELECT);
		ref.setRef(this.visit(tree.getChild(0), parser));

		final int count = tree.getChildCount();
		if (count == 2) {
			ParseTree child1 = tree.getChild(1);
			ref.setAlias(this.visitSqlId(child1, parser));
		} else if (count == 3) {
			ParseTree child2 = tree.getChild(2);
			ref.setAlias(this.visitSqlId(child2, parser));
		}
		return ref;
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
	private SQLBoolExpr visitWhere(ParseTree tree, Parser parser) throws SQLException {
		ParseTree criteria = null;
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node=tree.getChild(i);
			if(node  instanceof TerminalNode){
				continue;
			}
			
			Rule rule=AntlrTreeUtils.getRule(node, parser);
			if(rule==Rule.CRITERIA){
				criteria=node;
				break;
			}
		}
		return (SQLBoolExpr) ASTStructUtils.getVisitor(Rule.CRITERIA).visit(criteria, parser);
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
	private SQLGroupBy visitGroupBy(ParseTree tree, Parser parser) throws SQLException {
		String fields[] = new String[tree.getChildCount()];
		SQLGroupBy groupBy = new SQLGroupBy(fields);
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (node instanceof RuleNode) {
				fields[i] = ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(node, parser).toString();
			}
		}
		return groupBy;
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
	private SQLBoolExpr visitHaving(ParseTree tree, Parser parser) throws SQLException {
		return (SQLBoolExpr) ASTStructUtils.getVisitor(Rule.WHERE_CLAUSE).visit(tree, parser);
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
	private SQLSort visitOrderBy(ParseTree tree, Parser parser) throws SQLException {
		SQLSort sort = new SQLSort();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			String fieldName = ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(node.getChild(0), parser).toString();
			if (node.getChildCount() == 2) {
				Token symbol = ((TerminalNode) node).getSymbol();
				if (Keyword.ASC.equals(symbol.getText().trim().toUpperCase())) {
					sort.asc(fieldName);
				} else {
					sort.desc(fieldName);
				}
			} else {
				sort.asc(fieldName);
			}
		}
		return sort;
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
	private SQLLimit visitLimit(ParseTree tree, Parser parser) throws SQLException {
		int row = 0;
		int offset = 0;
		int count = tree.getChildCount();
		if (count == 2) {
			offset = Integer.valueOf(ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(1), parser).toString().trim());
		} else if (count == 4) {
			row = Integer.valueOf(ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(1), parser).toString().trim());
			offset = Integer.valueOf(ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(tree.getChild(3), parser).toString().trim());
		}
		SQLLimit limit = new SQLLimit(row, offset);
		return limit;
	}

	/*
	 * 解析访问规则display_column
	 * 
	 * @param tree
	 * 
	 * @param parser
	 * 
	 * @return
	 */
	private String visitDisplayColumn(ParseTree tree, Parser parser) throws SQLException {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (node instanceof RuleNode) {
				sb.append(ASTStructUtils.getVisitor(Rule.EXPRESSION).visit(node, parser));
				sb.append(" ");
			} else if (node instanceof TerminalNode) {
				String text = ((TerminalNode) node).getText();
				sb.append(text);
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}

	@Override
	protected Rule getRule() {
		return Rule.SELECT_STMT;
	}

	@Override
	public boolean accept(ParseTree tree, Parser parser) {
		Rule rule = AntlrTreeUtils.getRule(tree, parser);
		return Rule.SELECT_STMT == rule || Rule.SELECT_CLAUSE == rule;
	}

}
