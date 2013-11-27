package org.river.sealand.sql.ast;

import java.io.IOException;

import junit.framework.TestCase;

import org.river.sealand.utils.DBType;
import org.river.sealand.sql.util.SQLException;

/**
 * <p>
 * 抽象语法树单元测试
 * @author river
 * @since  Nov 26, 2013
 */
public class ASTStructUtilsTestCase extends TestCase {
	public void testBuild() throws IOException, SQLException{
//		final String sql="select a.id AS ID,123,S.a.* from T_A a left join T_B b on a.id=b.id where a.id=123";		
		
//		final String sql="select * from T_A a where a.k=123 and a.id between 1 and 123 and (a.name='z' or a.sex='m')";		
		final String sql="select (id+2),bc from T_A where id=1";	
		ISqlStruct ast=ASTStructUtils.build(sql, DBType.MYSQL);
		System.out.println("test completed");
	}
}
