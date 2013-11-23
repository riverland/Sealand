// Generated from SQLCommon.g by ANTLR 4.1

  package org.river.sealand.sql.syntex;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLCommonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLCommonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull SQLCommonParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#set_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_clause(@NotNull SQLCommonParser.Set_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#exist_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExist_expr(@NotNull SQLCommonParser.Exist_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#set_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_list(@NotNull SQLCommonParser.Set_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#order_by_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_item(@NotNull SQLCommonParser.Order_by_itemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#sql_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_id(@NotNull SQLCommonParser.Sql_idContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#in_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_expr(@NotNull SQLCommonParser.In_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#select_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_stmt(@NotNull SQLCommonParser.Select_stmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#having_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHaving_clause(@NotNull SQLCommonParser.Having_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#display_column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay_column(@NotNull SQLCommonParser.Display_columnContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#column_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_list(@NotNull SQLCommonParser.Column_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#case_when_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_when_clause(@NotNull SQLCommonParser.Case_when_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#between_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetween_expr(@NotNull SQLCommonParser.Between_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#select_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_clause(@NotNull SQLCommonParser.Select_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#criteria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCriteria(@NotNull SQLCommonParser.CriteriaContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#where_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere_clause(@NotNull SQLCommonParser.Where_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#values_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues_list(@NotNull SQLCommonParser.Values_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull SQLCommonParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(@NotNull SQLCommonParser.Expr_stmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#sub_query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub_query(@NotNull SQLCommonParser.Sub_queryContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#delete_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_clause(@NotNull SQLCommonParser.Delete_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#group_by_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by_item(@NotNull SQLCommonParser.Group_by_itemContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull SQLCommonParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#insert_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_clause(@NotNull SQLCommonParser.Insert_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#table_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_atom(@NotNull SQLCommonParser.Table_atomContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#select_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_list(@NotNull SQLCommonParser.Select_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#limit_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit_clause(@NotNull SQLCommonParser.Limit_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#literal_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_value(@NotNull SQLCommonParser.Literal_valueContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#update_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_clause(@NotNull SQLCommonParser.Update_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#order_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder_by_clause(@NotNull SQLCommonParser.Order_by_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#number_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_literal(@NotNull SQLCommonParser.Number_literalContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#group_by_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_by_clause(@NotNull SQLCommonParser.Group_by_clauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#case_when_clause_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_when_clause_1(@NotNull SQLCommonParser.Case_when_clause_1Context ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#case_when_clause_0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_when_clause_0(@NotNull SQLCommonParser.Case_when_clause_0Context ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#join_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_condition(@NotNull SQLCommonParser.Join_conditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SQLCommonParser#table_refs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_refs(@NotNull SQLCommonParser.Table_refsContext ctx);
}