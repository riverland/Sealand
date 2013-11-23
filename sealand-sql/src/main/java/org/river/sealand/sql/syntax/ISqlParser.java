package org.river.sealand.sql.syntax;

import org.river.sealand.sql.ast.ISqlStruct;
import org.river.sealand.sql.util.SQLException;

/**
 * <p>
 * sql词法解析
 * @author river
 * @since  Nov 18, 2013
 */
public interface ISqlParser {
	
	/**
	 * <p>
	 * 解析sql
	 * @param sql
	 * @return
	 * @throws SQLException 
	 */
	public ISqlStruct parse(SqlLexer lexer) throws SQLException;
}
