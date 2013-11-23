package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.ast.ISqlStruct;

/**
 * <p>
 * antlr 语法树访问者接口
 * @author river
 * @since  Nov 21, 2013
 */
public interface IAntlrTreeVisitor {
	
	/**
	 * <p>
	 * 访问语法树的一个节点
	 * @param tree
	 * @return
	 */
	public ISqlStruct visit(ParseTree tree,Parser parser);	
}
