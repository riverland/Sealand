package org.river.sealand.sql.ast;

import java.util.HashMap;
import java.util.Map;

import org.river.sealand.sql.DbType;
import org.river.sealand.sql.ast.visitor.AntlrSelectVisitor;
import org.river.sealand.sql.ast.visitor.IAntlrTreeVisitor;
import org.river.sealand.sql.ast.visitor.Rule;

/**
 * <p>
 * 抽象语法树结构构造工具类
 * @author river
 * @since  Nov 21, 2013
 */
public class ASTStructUtils {
	private static final ThreadLocal<ISqlStruct> sqlStruct = new ThreadLocal<ISqlStruct>();

	private static Map<Rule,IAntlrTreeVisitor> visitors = new HashMap<Rule,IAntlrTreeVisitor>();

	static {
		visitors.put(Rule.SELECT_STMT,new AntlrSelectVisitor());
	}
	
	public static ISqlStruct build(String sql,DbType dbType){
		return sqlStruct.get();
	}	
	
	public static IAntlrTreeVisitor getVisitor(Rule rule){
		return visitors.get(rule);
	}
}
