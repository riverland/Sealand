package org.river.sealand.sql.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.syntax.SQLCommonLexer;
import org.river.sealand.sql.syntax.SQLCommonParser;

/**
 * <p>
 * antlr 相关单元测试
 * @author river
 * @since  Nov 21, 2013
 */
public class AntlrTestCase extends TestCase {
	
	public void testParser() throws IOException{
//		final String sql="select a.id AS ID,123,S.a.* from T_A a left join T_B b on a.id=b.id where a.id=123";		
		
//		final String sql="select * from T_A a where a.k=123 and a.id between 1 and 123 and (a.name='z' or a.sex='m')";		
//		final String sql="select ab,-1,'zhangsan' from T_A where id=1";		
		final String sql="select (id+2)*4,bc from T_A where id=1";
		InputStream ins=new ByteArrayInputStream(sql.getBytes());
		
		ANTLRInputStream input=new ANTLRInputStream(ins);
		SQLCommonLexer lexer=new SQLCommonLexer(input);
		
		CommonTokenStream tokenStream=new CommonTokenStream(lexer);
		
		SQLCommonParser sqlParser=new SQLCommonParser(tokenStream);
		
		ParseTree tree=sqlParser.statement();
		
		System.out.println(tree.toStringTree(sqlParser));
//		(expression (expression (number 1)) + (expression (number 1)))
	}
}
