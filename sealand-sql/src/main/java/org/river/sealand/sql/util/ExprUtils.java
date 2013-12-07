package org.river.sealand.sql.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.ast.visitor.AntlrTreeUtils;
import org.river.sealand.sql.ast.visitor.Rule;
import org.river.sealand.sql.syntax.SQLCommonLexer;
import org.river.sealand.sql.syntax.SQLCommonParser;

/**
 * <p>
 * 表达式相关
 * 
 * @author river
 * @since Dec 7, 2013
 */
public class ExprUtils {

	/**
	 * <p>
	 * 解析表达式中所有的变量
	 * 
	 * @param expr
	 * @return
	 * @throws IOException
	 */
	public static Set<String> allVariables(String expr){
		InputStream ins = new ByteArrayInputStream(expr.getBytes());
		ANTLRInputStream input=null;
		try {
			input = new ANTLRInputStream(ins);
		} catch (IOException e) {
			//TODO implements the error logic
		}
		
		SQLCommonLexer lexer = new SQLCommonLexer(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		SQLCommonParser sqlParser = new SQLCommonParser(tokenStream);
		ParseTree exprNode = sqlParser.expr_stmt().getChild(0);

		return allSqlId(exprNode, sqlParser);
	}

	public static Set<String> allSqlId(ParseTree node, Parser parser) {
		Set<String> vals = new HashSet<String>();
		Rule rule = AntlrTreeUtils.getRule(node, parser);
		if (rule == Rule.SQL_ID) {
			vals.add(node.getText());
			return vals;
		}

		for (int i = 0; i < node.getChildCount(); i++) {
			vals.addAll(allSqlId(node.getChild(i), parser));
		}
		return vals;
	}
}
