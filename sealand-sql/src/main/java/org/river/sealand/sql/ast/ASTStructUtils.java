package org.river.sealand.sql.ast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.river.sealand.sql.ast.visitor.AntlrCriteriaVisitor;
import org.river.sealand.sql.ast.visitor.AntlrExprVisitor;
import org.river.sealand.sql.ast.visitor.AntlrSelectVisitor;
import org.river.sealand.sql.ast.visitor.IAntlrTreeVisitor;
import org.river.sealand.sql.ast.visitor.Rule;
import org.river.sealand.utils.DBType;
import org.river.sealand.sql.syntax.SQLCommonLexer;
import org.river.sealand.sql.syntax.SQLCommonParser;
import org.river.sealand.sql.util.SQLException;

/**
 * SqlExprVisitor *
 * <p>
 * 抽象语法树结构构造工具类
 * 
 * @author river
 * @since Nov 21, 2013
 */
public class ASTStructUtils {
	private static Map<Rule, IAntlrTreeVisitor> visitors = new HashMap<Rule, IAntlrTreeVisitor>();

	static {
		visitors.put(Rule.SELECT_STMT, new AntlrSelectVisitor());
		visitors.put(Rule.EXPRESSION, new AntlrExprVisitor());
		visitors.put(Rule.CRITERIA, new AntlrCriteriaVisitor());
	}

	/**
	 * <p>
	 * 把sql语句语法解析成SQL抽象语法树结构
	 * @param sql
	 * @param dbType
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static ISqlStruct build(String sql, DBType dbType) throws IOException, SQLException {
		InputStream ins = new ByteArrayInputStream(sql.getBytes());
		ANTLRInputStream input = new ANTLRInputStream(ins);
		SQLCommonLexer lexer = new SQLCommonLexer(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		SQLCommonParser sqlParser = new SQLCommonParser(tokenStream);
		ParseTree stmt = sqlParser.statement().getChild(0);
		Set<Rule> keySet = visitors.keySet();

		ISqlStruct expr = null;
		for (Rule tmp : keySet) {
			IAntlrTreeVisitor visitor = visitors.get(tmp);
			expr = visitor.visit(stmt, sqlParser);
			if (expr != null) {
				break;
			}
		}
		return expr;
	}

	public static IAntlrTreeVisitor getVisitor(Rule rule) {
		return visitors.get(rule);
	}
}
