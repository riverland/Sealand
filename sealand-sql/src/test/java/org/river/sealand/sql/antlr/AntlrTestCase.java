package org.river.sealand.sql.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.syntex.SQLCommonLexer;
import org.river.sealand.sql.syntex.SQLCommonParser;
/**
 * <p>
 * antlr 相关单元测试
 * @author river
 * @since  Nov 21, 2013
 */
public class AntlrTestCase extends TestCase {
	
	public void testParser() throws IOException{
		final String sql="select * from T_A a where a.id=123 union all select * from T_B";		
		InputStream ins=new ByteArrayInputStream(sql.getBytes());
		
		ANTLRInputStream input=new ANTLRInputStream(ins);
		SQLCommonLexer lexer=new SQLCommonLexer(input);
		
		CommonTokenStream tokenStream=new CommonTokenStream(lexer);
		
		SQLCommonParser sqlParser=new SQLCommonParser(tokenStream);
		
		ParseTree tree=sqlParser.statement();
		
		System.out.println(tree.toStringTree(sqlParser));
	}
}
