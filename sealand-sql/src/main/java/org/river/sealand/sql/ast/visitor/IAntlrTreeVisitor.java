package org.river.sealand.sql.ast.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.ast.ISqlStruct;
import org.river.sealand.utils.SQLException;

/**
 * <p>
 * antlr 语法树访问者接口
 * 
 * @author river
 * @since Nov 21, 2013
 */
public interface IAntlrTreeVisitor {

	/**
	 * <p>
	 * 访问语法树的一个节点
	 * 
	 * @param tree
	 * @return
	 * @throws SQLException
	 */
	public ISqlStruct visit(ParseTree tree, Parser parser) throws SQLException;
}
