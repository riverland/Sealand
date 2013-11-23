package org.river.sealand.sql.ast;

/**
 * <p>
 * sql结构标志抽象
 * @author river
 * @since  Nov 18, 2013
 */
public interface ISqlStruct {
	public SqlType getSqlType();
	
	public static enum SqlType{
		SELECT,UPDATE,INSERT,DELETE,TABLE,UNION,EXPRESSION,JOIN,GROUP_BY,FRAGMENT;
	}
}
