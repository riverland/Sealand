package org.river.sealand.sql.syntax;

import java.util.concurrent.atomic.AtomicInteger;

import org.river.sealand.sql.ast.SqlExpr;
import org.river.sealand.sql.ast.SqlExpr.Type;
import org.river.sealand.sql.ast.SqlSelect;
import org.river.sealand.sql.syntax.Word.WordType;
import org.river.sealand.sql.util.SQLException;

/**
 * <p>
 * 表达语法分析器
 * 
 * @author river
 * @since Nov 18, 2013
 */
public class ExprParser implements ISqlParser {
	private static final ThreadLocal<SqlExpr> exprLocal = new ThreadLocal<SqlExpr>();
	private static final ThreadLocal<AtomicInteger> leftBraceNumLocal = new ThreadLocal<AtomicInteger>();

	public SqlExpr parse(SqlLexer lexer) throws SQLException {

		if (!lexer.next() || !this.isNeedMoreParse(lexer)) {
			return null;
		}

		Word word = lexer.getWord();
		WordType wordType = word.getType();

		switch (wordType) {
		case KEYWORD:
			return this.parseKeyword(lexer);
		case IDENTIFIER:
			return this.parseIdentifier(lexer);
		case OPERATOR:
			return this.parseOperator(lexer);
		case VARIANT:
			return this.parseVariable(lexer);
		case VALUE:
			return this.parseValue(lexer);
		default:
			;
		}

		if (leftBraceNumLocal.get().get() != 0) {
			throw new SQLException("syntax error:')' expected");
		}

		return exprLocal.get();
	}

	/*
	 * 判断条件表达式是否到结尾
	 * 
	 * @param lexer
	 * 
	 * @return
	 */
	private boolean isNeedMoreParse(SqlLexer lexer) {
		Word word = lexer.getWord();
		WordType wordType = word.getType();
		Token token = word.getToken();
		if (wordType == WordType.KEYWORD && token != Token.NOT && token != Token.AND && token != Token.OR && token != Token.BETWEEN && token != Token.EXISTS && token != Token.IN) {
			return false;
		}

		return true;

	}

	/*
	 * 关键字语法分析
	 * 
	 * @param lexer
	 */
	private SqlExpr parseKeyword(SqlLexer lexer) throws SQLException {
		Word word = lexer.getWord();
		switch (word.getToken()) {
		case NOT:
			return this.parseNot(lexer);
		case AND:
			return this.parseAnd(lexer);
		case OR:
			return this.parseOr(lexer);
		case EXISTS:
			return this.parseExist(lexer);
		case IN:
			return this.parseIn(lexer);
		case BETWEEN:
			return this.parseBetween(lexer);
		default:
			return null;// do nothing
		}

	}

	/*
	 * 解析标识符
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseIdentifier(SqlLexer lexer) throws SQLException {
		lexer.mark();
		lexer.next();
		Token token = lexer.getWord().getToken();
		if (token == Token.DOT) {
			lexer.next();
		}

		lexer.next();
		Word word = lexer.getWord();
		WordType wordType = word.getType();
		if (wordType == WordType.KEYWORD) {
			return this.parseKeyword(lexer);
		} else if (wordType == WordType.OPERATOR) {
			return this.parseOperator(lexer);
		} else {
			throw new SQLException("syntax error:IN or operator is expected after identifier");
		}
	}

	private SqlExpr parseOperator(SqlLexer lexer) throws SQLException {
		lexer.reset();
		SqlExpr identifer = new SqlExpr();
		Word word = lexer.getWord();
		identifer.setType(Type.COLUMN);
		String columnName = word.getValue();
		lexer.next();
		if (lexer.getWord().getToken() == Token.DOT) {
			columnName = columnName + ".";
			lexer.next();
			columnName = columnName + lexer.getWord().getValue();
		}
		identifer.setValue(columnName);
		
		SqlExpr operator=new SqlExpr();
		lexer.next();
		word=lexer.getWord();
		Token token=word.getToken();
//		operator.setType(Type.)
		
		return null;
	}

	private SqlExpr parseVariable(SqlLexer lexer) {
		return null;
	}

	private SqlExpr parseValue(SqlLexer lexer) {
		return null;
	}

	/*
	 * 分析NOT关键字
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseNot(SqlLexer lexer) throws SQLException {
		SqlExpr not = new SqlExpr();
		not.setType(Type.NOT);
		SqlExpr nextExpr = this.parse(lexer);
		not.getElements().add(nextExpr);
		SqlExpr threadLocal = exprLocal.get();

		if (threadLocal == null) {
			exprLocal.set(not);
		}
		return not;
	}

	/*
	 * 分析and关键字
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseAnd(SqlLexer lexer) throws SQLException {
		SqlExpr threadLocal = exprLocal.get();
		SqlExpr nextExpr = this.parse(lexer);
		threadLocal = threadLocal.and(nextExpr);
		exprLocal.set(threadLocal);
		return threadLocal;
	}

	/*
	 * 分析or关键字
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseOr(SqlLexer lexer) throws SQLException {
		SqlExpr threadLocal = exprLocal.get();
		SqlExpr nextExpr = this.parse(lexer);
		threadLocal = threadLocal.or(nextExpr);
		exprLocal.set(threadLocal);
		return threadLocal;
	}

	/*
	 * 分析IN关键字
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseIn(SqlLexer lexer) throws SQLException {
		lexer.reset();
		SqlExpr identifer = new SqlExpr();
		Word word = lexer.getWord();
		identifer.setType(Type.COLUMN);
		String columnName = word.getValue();

		lexer.next();
		if (lexer.getWord().getToken() == Token.DOT) {
			columnName = columnName + ".";
			lexer.next();
			columnName = columnName + lexer.getWord().getValue();
		}
		identifer.setValue(columnName);

		SqlExpr in = new SqlExpr();
		in.setType(Type.IN);
		in.getElements().add(identifer);

		lexer.next();
		Token token = lexer.getWord().getToken();
		if (token != Token.LPAREN) {
			throw new SQLException("syntax error:'(' expected after IN");
		}
		int leftParenCount = 1;
		lexer.mark();
		lexer.next();
		token = lexer.getWord().getToken();
		if (token == Token.SELECT) {
			lexer.reset();
			SqlSelect select = this.parseSubSelect(lexer);
			SqlExpr expr = new SqlExpr();
			expr.setType(Type.SUBSELECT);
			expr.setValue(select);
			in.getElements().add(expr);
		} else {
			while (leftParenCount > 0) {
				lexer.next();
				word = lexer.getWord();
				token = word.getToken();
				if (token == Token.RPAREN) {
					leftParenCount--;
				} else if (token == Token.COMMA) {
					continue;
				} else if (word.getType() == WordType.IDENTIFIER) {
					in.getElements().add(this.parseIdentifier(lexer));
				} else if (word.getType() == WordType.VALUE) {
					in.getElements().add(this.parseValue(lexer));
				} else if (word.getType() == WordType.VARIANT) {
					in.getElements().add(this.parseVariable(lexer));
				}
			}
		}

		SqlExpr threadLocal = exprLocal.get();
		if (threadLocal == null) {
			exprLocal.set(in);
		}
		return in;
	}

	/*
	 * 分析EXIST关键字
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseExist(SqlLexer lexer) throws SQLException {
		SqlExpr exist = new SqlExpr();
		exist.setType(Type.EXIST);

		lexer.next();
		Token token = lexer.getWord().getToken();
		if (token != Token.LPAREN) {
			throw new SQLException("syntax error:'(' expected after EXIST");
		}

		lexer.mark();
		lexer.next();
		token = lexer.getWord().getToken();
		if (token == Token.SELECT) {
			lexer.reset();
			SqlSelect select = this.parseSubSelect(lexer);
			SqlExpr expr = new SqlExpr();
			expr.setType(Type.SUBSELECT);
			expr.setValue(select);
			exist.getElements().add(expr);
		} else {
			throw new SQLException("syntax error:'SELECT' expected after EXIST");
		}

		SqlExpr threadLocal = exprLocal.get();
		if (threadLocal == null) {
			exprLocal.set(exist);
		}
		return exist;
	}

	/*
	 * 分析EXIST关键字
	 * 
	 * @param lexer
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private SqlExpr parseBetween(SqlLexer lexer) throws SQLException {
		lexer.reset();
		SqlExpr identifer = new SqlExpr();
		Word word = lexer.getWord();
		identifer.setType(Type.COLUMN);
		String columnName = word.getValue();

		lexer.next();
		if (lexer.getWord().getToken() == Token.DOT) {
			columnName = columnName + ".";
			lexer.next();
			columnName = columnName + lexer.getWord().getValue();
		}
		identifer.setValue(columnName);

		SqlExpr between = new SqlExpr();
		between.setType(Type.BETWEEN);
		between.getElements().add(identifer);

		lexer.next();
		word = lexer.getWord();
		String leftValue = "";
		while (word.getToken() != Token.AND) {
			leftValue = leftValue + word.getValue();
			lexer.next();
			word = lexer.getWord();
		}
		SqlExpr leftExpr = new SqlExpr();
		leftExpr.setType(Type.VALUE);
		leftExpr.setValue(leftValue);

		lexer.next();
		word = lexer.getWord();
		String rightValue = "";
		while (word.getType() != WordType.KEYWORD) {
			rightValue = rightValue + word.getValue();
			lexer.next();
			word = lexer.getWord();
		}
		SqlExpr rightExpr = new SqlExpr();
		rightExpr.setType(Type.VALUE);
		rightExpr.setValue(rightValue);

		SqlExpr threadLocal = exprLocal.get();
		if (threadLocal == null) {
			exprLocal.set(between);
		}
		return between;
	}

	private SqlSelect parseSubSelect(SqlLexer lexer) {
		return null;
	}

}
