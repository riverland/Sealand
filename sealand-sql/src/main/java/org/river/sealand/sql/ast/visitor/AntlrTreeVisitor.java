package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.ast.ISqlStruct;
import org.river.sealand.sql.util.SQLException;
/**
 * <p>
 * Antlr解析出的语法树访问者抽象类
 * @author river
 * @since  Nov 22, 2013
 */
public abstract class AntlrTreeVisitor implements IAntlrTreeVisitor {

	
	@Override
	public ISqlStruct visit(ParseTree tree,Parser parser) throws SQLException {
		if(!this.accept(tree, parser)){
			return null;
		}
		
		return this.doVisit(tree, parser);
	}
	
	/**
	 * <p>
	 * 是否接受访问
	 * @param tree
	 * @return
	 */
	public boolean accept(ParseTree tree,Parser parser){
		Rule rule=AntlrTreeUtils.getRule(tree, parser);
		return this.getRule()==rule;
	}
	
	/**
	 * <p>
	 * 实际的访问逻辑
	 * @param tree
	 * @return
	 * @throws SQLException 
	 */
	protected abstract ISqlStruct doVisit(ParseTree tree,Parser parser) throws SQLException;
	
	/**
	 * <p>
	 * 获取访问对应的语法类型
	 * @return
	 */
	protected abstract Rule getRule();
	
	/**
	 * <p>
	 * 获取sql_id的字符串
	 * @param tree
	 * @param parser
	 * @return
	 */
	protected String visitSqlId(ParseTree tree,Parser parser){
		return null;
	}
	
}
