// Generated from SQLCommon.g by ANTLR 4.1

  package org.river.sealand.sql.syntex;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLCommonParser}.
 */
public interface SQLCommonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull SQLCommonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull SQLCommonParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#set_clause}.
	 * @param ctx the parse tree
	 */
	void enterSet_clause(@NotNull SQLCommonParser.Set_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#set_clause}.
	 * @param ctx the parse tree
	 */
	void exitSet_clause(@NotNull SQLCommonParser.Set_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#exist_expr}.
	 * @param ctx the parse tree
	 */
	void enterExist_expr(@NotNull SQLCommonParser.Exist_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#exist_expr}.
	 * @param ctx the parse tree
	 */
	void exitExist_expr(@NotNull SQLCommonParser.Exist_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#set_list}.
	 * @param ctx the parse tree
	 */
	void enterSet_list(@NotNull SQLCommonParser.Set_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#set_list}.
	 * @param ctx the parse tree
	 */
	void exitSet_list(@NotNull SQLCommonParser.Set_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#order_by_item}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_item(@NotNull SQLCommonParser.Order_by_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#order_by_item}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_item(@NotNull SQLCommonParser.Order_by_itemContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#sql_id}.
	 * @param ctx the parse tree
	 */
	void enterSql_id(@NotNull SQLCommonParser.Sql_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#sql_id}.
	 * @param ctx the parse tree
	 */
	void exitSql_id(@NotNull SQLCommonParser.Sql_idContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#in_expr}.
	 * @param ctx the parse tree
	 */
	void enterIn_expr(@NotNull SQLCommonParser.In_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#in_expr}.
	 * @param ctx the parse tree
	 */
	void exitIn_expr(@NotNull SQLCommonParser.In_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelect_stmt(@NotNull SQLCommonParser.Select_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelect_stmt(@NotNull SQLCommonParser.Select_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#having_clause}.
	 * @param ctx the parse tree
	 */
	void enterHaving_clause(@NotNull SQLCommonParser.Having_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#having_clause}.
	 * @param ctx the parse tree
	 */
	void exitHaving_clause(@NotNull SQLCommonParser.Having_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#display_column}.
	 * @param ctx the parse tree
	 */
	void enterDisplay_column(@NotNull SQLCommonParser.Display_columnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#display_column}.
	 * @param ctx the parse tree
	 */
	void exitDisplay_column(@NotNull SQLCommonParser.Display_columnContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#column_list}.
	 * @param ctx the parse tree
	 */
	void enterColumn_list(@NotNull SQLCommonParser.Column_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#column_list}.
	 * @param ctx the parse tree
	 */
	void exitColumn_list(@NotNull SQLCommonParser.Column_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#case_when_clause}.
	 * @param ctx the parse tree
	 */
	void enterCase_when_clause(@NotNull SQLCommonParser.Case_when_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#case_when_clause}.
	 * @param ctx the parse tree
	 */
	void exitCase_when_clause(@NotNull SQLCommonParser.Case_when_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#between_expr}.
	 * @param ctx the parse tree
	 */
	void enterBetween_expr(@NotNull SQLCommonParser.Between_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#between_expr}.
	 * @param ctx the parse tree
	 */
	void exitBetween_expr(@NotNull SQLCommonParser.Between_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void enterSelect_clause(@NotNull SQLCommonParser.Select_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void exitSelect_clause(@NotNull SQLCommonParser.Select_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#criteria}.
	 * @param ctx the parse tree
	 */
	void enterCriteria(@NotNull SQLCommonParser.CriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#criteria}.
	 * @param ctx the parse tree
	 */
	void exitCriteria(@NotNull SQLCommonParser.CriteriaContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(@NotNull SQLCommonParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(@NotNull SQLCommonParser.Where_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#values_list}.
	 * @param ctx the parse tree
	 */
	void enterValues_list(@NotNull SQLCommonParser.Values_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#values_list}.
	 * @param ctx the parse tree
	 */
	void exitValues_list(@NotNull SQLCommonParser.Values_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SQLCommonParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SQLCommonParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(@NotNull SQLCommonParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(@NotNull SQLCommonParser.Expr_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#sub_query}.
	 * @param ctx the parse tree
	 */
	void enterSub_query(@NotNull SQLCommonParser.Sub_queryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#sub_query}.
	 * @param ctx the parse tree
	 */
	void exitSub_query(@NotNull SQLCommonParser.Sub_queryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#delete_clause}.
	 * @param ctx the parse tree
	 */
	void enterDelete_clause(@NotNull SQLCommonParser.Delete_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#delete_clause}.
	 * @param ctx the parse tree
	 */
	void exitDelete_clause(@NotNull SQLCommonParser.Delete_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by_item(@NotNull SQLCommonParser.Group_by_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#group_by_item}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by_item(@NotNull SQLCommonParser.Group_by_itemContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull SQLCommonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull SQLCommonParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#insert_clause}.
	 * @param ctx the parse tree
	 */
	void enterInsert_clause(@NotNull SQLCommonParser.Insert_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#insert_clause}.
	 * @param ctx the parse tree
	 */
	void exitInsert_clause(@NotNull SQLCommonParser.Insert_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#table_atom}.
	 * @param ctx the parse tree
	 */
	void enterTable_atom(@NotNull SQLCommonParser.Table_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#table_atom}.
	 * @param ctx the parse tree
	 */
	void exitTable_atom(@NotNull SQLCommonParser.Table_atomContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#select_list}.
	 * @param ctx the parse tree
	 */
	void enterSelect_list(@NotNull SQLCommonParser.Select_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#select_list}.
	 * @param ctx the parse tree
	 */
	void exitSelect_list(@NotNull SQLCommonParser.Select_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void enterLimit_clause(@NotNull SQLCommonParser.Limit_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#limit_clause}.
	 * @param ctx the parse tree
	 */
	void exitLimit_clause(@NotNull SQLCommonParser.Limit_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(@NotNull SQLCommonParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(@NotNull SQLCommonParser.Literal_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#update_clause}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_clause(@NotNull SQLCommonParser.Update_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#update_clause}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_clause(@NotNull SQLCommonParser.Update_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(@NotNull SQLCommonParser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(@NotNull SQLCommonParser.Order_by_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#number_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumber_literal(@NotNull SQLCommonParser.Number_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#number_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumber_literal(@NotNull SQLCommonParser.Number_literalContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#group_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterGroup_by_clause(@NotNull SQLCommonParser.Group_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#group_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitGroup_by_clause(@NotNull SQLCommonParser.Group_by_clauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#case_when_clause_1}.
	 * @param ctx the parse tree
	 */
	void enterCase_when_clause_1(@NotNull SQLCommonParser.Case_when_clause_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#case_when_clause_1}.
	 * @param ctx the parse tree
	 */
	void exitCase_when_clause_1(@NotNull SQLCommonParser.Case_when_clause_1Context ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#case_when_clause_0}.
	 * @param ctx the parse tree
	 */
	void enterCase_when_clause_0(@NotNull SQLCommonParser.Case_when_clause_0Context ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#case_when_clause_0}.
	 * @param ctx the parse tree
	 */
	void exitCase_when_clause_0(@NotNull SQLCommonParser.Case_when_clause_0Context ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#join_condition}.
	 * @param ctx the parse tree
	 */
	void enterJoin_condition(@NotNull SQLCommonParser.Join_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#join_condition}.
	 * @param ctx the parse tree
	 */
	void exitJoin_condition(@NotNull SQLCommonParser.Join_conditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SQLCommonParser#table_refs}.
	 * @param ctx the parse tree
	 */
	void enterTable_refs(@NotNull SQLCommonParser.Table_refsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLCommonParser#table_refs}.
	 * @param ctx the parse tree
	 */
	void exitTable_refs(@NotNull SQLCommonParser.Table_refsContext ctx);
}