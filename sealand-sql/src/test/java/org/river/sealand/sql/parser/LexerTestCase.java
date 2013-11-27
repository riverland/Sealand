//package org.river.sealand.sql.parser;
//
//import org.river.sealand.sql.syntax.SqlLexer;
//import org.river.sealand.utils.SQLException/
//import junit.framework.TestCase;
///**
// * <p>
// * sql 分词器单元测试 {@link Lexer}
// * @author river
// * @since  Nov 17, 2013
// */
//public class LexerTestCase extends TestCase {
//
//	public void testNext() throws SQLException{
//		final String sql="select abs('a.c0'+a.c1),'zhangsan' from A a left join B b on a.id=b.id where (a.c1 is null or a.c2 is null) and a.id>-100 and a.name like '%haha%'";
//		SqlLexer lexer=new SqlLexer(sql);
//		while(lexer.next()){
//			System.out.println(lexer.getWord().getToken()+":"+lexer.getWord().getType()+":"+lexer.getWord().getValue());
//		}
//	}
//}
