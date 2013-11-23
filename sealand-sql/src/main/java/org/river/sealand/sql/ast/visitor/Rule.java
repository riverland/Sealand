package org.river.sealand.sql.ast.visitor;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 语法规则类型
 * 
 * @author river
 * @since Nov 22, 2013
 */
public enum Rule {

	STATEMENT("statement"),
	SELECT_STMT("select_stmt"), 
	SELECT_CLAUSE("select_clause"), 
	INSERT_CLAUSE("insert_clause"),
	UPDATE_CLAUSE("update_clause"), 
	DELETE_CLAUSE("delete_clause"), 
	EXPRESSION("expression"), 
	VALUE_LIST("values_list"),
	SELECT_LIST("select_list"), 
	COLUMN_LIST("column_list"), 
	SET_LIST("set_list"), 
	SET_CLAUSE("set_clause"), 
	WHERE_CLAUSE("where_clause"), 
	HAVING_CLAUSE("having_clause"), 
	GROUP_BY_CLAUSE("group_by_clause"),
	GROUP_BY_ITEM("group_by_item"), 
	ORDER_BY_CLAUSE("order_by_clause"),
	ORDER_BY_ITEM("order_by_item"), 
	LIMIT_CLAUSE("limit_clause"), 
	DISPLAY_COLUMN("display_column"), 
	CRITERIA("criteria"), 
	BETWEEN_EXPR("between_expr"), 
	EXIST_EXPR("exist_expr"), 
	IN_EXPR("in_expr"), 
	CASE_WHEN_CLAUSE("case_when_clause"), 
	TABLE_REFS("table_refs"), 
	TABLE_ATOM("table_atom"), 
	JOIN_CONDITION("join_condition"), 
	SUB_QUERY("sub_query"), 
	LITERAL_VALUE("literal_value"), 
	NUMBER("number"), 
	NUMBER_LITERAL("number_literal"), 
	SQL_ID("sql_id");
	

	private static Map<String, Rule> ALL = new HashMap<String, Rule>();

	private String value;

	public String getValue() {
		return value;
	}

	private Rule(String value) {
		this.value = value;
	}

	/**
	 * <p>
	 * 根据value获取Rule
	 * 
	 * @param value
	 * @return
	 */
	public static Rule getRule(String value) {
		return ALL.get(value);
	}

	static {
		Rule[] rules = Rule.values();
		for (Rule tmp : rules) {
			ALL.put(tmp.value, tmp);
		}
	}

}
