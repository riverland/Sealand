//package org.river.sealand.sql.syntax;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//import org.river.sealand.sql.ast.SqlBoolExpr;
//import org.river.sealand.sql.ast.SqlBoolExpr.Type;
//import org.river.sealand.sql.ast.SqlSelect;
//import org.river.sealand.sql.syntax.Word.WordType;
//import org.river.sealand.sql.util.SQLException;
//
///**
// * <p>
// * 表达语法分析器
// * 
// * @author river
// * @since Nov 18, 2013
// */
//public class ExprParser implements ISqlParser {
//	private static final ThreadLocal<SqlBoolExpr> exprLocal = new ThreadLocal<SqlBoolExpr>();
//	private static final ThreadLocal<AtomicInteger> leftBraceNumLocal = new ThreadLocal<AtomicInteger>();
//
//	public SqlBoolExpr parse(SqlLexer lexer) throws SQLException {
//
//		if (!lexer.next() || !this.isNeedMoreParse(lexer)) {
//			return null;
//		}
//
//		Word word = lexer.getWord();
//		WordType wordType = word.getType();
//
//		switch (wordType) {
//		case KEYWORD:
//			return this.parseKeyword(lexer);
//		case IDENTIFIER:
//			return this.parseIdentifier(lexer);
//		case OPERATOR:
//			return this.parseOperator(lexer);
//		case VARIANT:
//			return this.parseVariable(lexer);
//		case VALUE:
//			return this.parseValue(lexer);
//		default:
//			;
//		}
//
//		if (leftBraceNumLocal.get().get() != 0) {
//			throw new SQLException("syntax error:')' expected");
//		}
//
//		return exprLocal.get();
//	}
//
//	/*
//	 * 判断条件表达式是否到结尾
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 */
//	private boolean isNeedMoreParse(SqlLexer lexer) {
//		Word word = lexer.getWord();
//		WordType wordType = word.getType();
//		Token token = word.getToken();
//		if (wordType == WordType.KEYWORD && token != Token.NOT && token != Token.AND && token != Token.OR && token != Token.BETWEEN && token != Token.EXISTS && token != Token.IN) {
//			return false;
//		}
//
//		return true;
//
//	}
//
//	/*
//	 * 关键字语法分析
//	 * 
//	 * @param lexer
//	 */
//	private SqlBoolExpr parseKeyword(SqlLexer lexer) throws SQLException {
//		Word word = lexer.getWord();
//		switch (word.getToken()) {
//		case NOT:
//			return this.parseNot(lexer);
//		case AND:
//			return this.parseAnd(lexer);
//		case OR:
//			return this.parseOr(lexer);
//		case EXISTS:
//			return this.parseExist(lexer);
//		case IN:
//			return this.parseIn(lexer);
//		case BETWEEN:
//			return this.parseBetween(lexer);
//		default:
//			return null;// do nothing
//		}
//
//	}
//
//	/*
//	 * 解析标识符
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseIdentifier(SqlLexer lexer) throws SQLException {
//		lexer.mark();
//		lexer.next();
//		Token token = lexer.getWord().getToken();
//		if (token == Token.DOT) {
//			lexer.next();
//		}
//
//		lexer.next();
//		Word word = lexer.getWord();
//		WordType wordType = word.getType();
//		if (wordType == WordType.KEYWORD) {
//			return this.parseKeyword(lexer);
//		} else if (wordType == WordType.OPERATOR) {
//			return this.parseOperator(lexer);
//		} else {
//			throw new SQLException("syntax error:IN or operator is expected after identifier");
//		}
//	}
//
//	private SqlBoolExpr parseOperator(SqlLexer lexer) throws SQLException {
//		lexer.reset();
//		SqlBoolExpr identifer = new SqlBoolExpr();
//		Word word = lexer.getWord();
//		identifer.setType(Type.COLUMN);
//		String columnName = word.getValue();
//		lexer.next();
//		if (lexer.getWord().getToken() == Token.DOT) {
//			columnName = columnName + ".";
//			lexer.next();
//			columnName = columnName + lexer.getWord().getValue();
//		}
//		identifer.setValue(columnName);
//		
//		SqlBoolExpr operator=new SqlBoolExpr();
//		lexer.next();
//		word=lexer.getWord();
//		Token token=word.getToken();
////		operator.setType(Type.)
//		
//		return null;
//	}
//
//	private SqlBoolExpr parseVariable(SqlLexer lexer) {
//		return null;
//	}
//
//	private SqlBoolExpr parseValue(SqlLexer lexer) {
//		return null;
//	}
//
//	/*
//	 * 分析NOT关键字
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseNot(SqlLexer lexer) throws SQLException {
//		SqlBoolExpr not = new SqlBoolExpr();
//		not.setType(Type.NOT);
//		SqlBoolExpr nextExpr = this.parse(lexer);
//		not.getElements().add(nextExpr);
//		SqlBoolExpr threadLocal = exprLocal.get();
//
//		if (threadLocal == null) {
//			exprLocal.set(not);
//		}
//		return not;
//	}
//
//	/*
//	 * 分析and关键字
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseAnd(SqlLexer lexer) throws SQLException {
//		SqlBoolExpr threadLocal = exprLocal.get();
//		SqlBoolExpr nextExpr = this.parse(lexer);
//		threadLocal = threadLocal.and(nextExpr);
//		exprLocal.set(threadLocal);
//		return threadLocal;
//	}
//
//	/*
//	 * 分析or关键字
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseOr(SqlLexer lexer) throws SQLException {
//		SqlBoolExpr threadLocal = exprLocal.get();
//		SqlBoolExpr nextExpr = this.parse(lexer);
//		threadLocal = threadLocal.or(nextExpr);
//		exprLocal.set(threadLocal);
//		return threadLocal;
//	}
//
//	/*
//	 * 分析IN关键字
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseIn(SqlLexer lexer) throws SQLException {
//		lexer.reset();
//		SqlBoolExpr identifer = new SqlBoolExpr();
//		Word word = lexer.getWord();
//		identifer.setType(Type.COLUMN);
//		String columnName = word.getValue();
//
//		lexer.next();
//		if (lexer.getWord().getToken() == Token.DOT) {
//			columnName = columnName + ".";
//			lexer.next();
//			columnName = columnName + lexer.getWord().getValue();
//		}
//		identifer.setValue(columnName);
//
//		SqlBoolExpr in = new SqlBoolExpr();
//		in.setType(Type.IN);
//		in.getElements().add(identifer);
//
//		lexer.next();
//		Token token = lexer.getWord().getToken();
//		if (token != Token.LPAREN) {
//			throw new SQLException("syntax error:'(' expected after IN");
//		}
//		int leftParenCount = 1;
//		lexer.mark();
//		lexer.next();
//		token = lexer.getWord().getToken();
//		if (token == Token.SELECT) {
//			lexer.reset();
//			SqlSelect select = this.parseSubSelect(lexer);
//			SqlBoolExpr expr = new SqlBoolExpr();
//			expr.setType(Type.SUBSELECT);
//			expr.setValue(select);
//			in.getElements().add(expr);
//		} else {
//			while (leftParenCount > 0) {
//				lexer.next();
//				word = lexer.getWord();
//				token = word.getToken();
//				if (token == Token.RPAREN) {
//					leftParenCount--;
//				} else if (token == Token.COMMA) {
//					continue;
//				} else if (word.getType() == WordType.IDENTIFIER) {
//					in.getElements().add(this.parseIdentifier(lexer));
//				} else if (word.getType() == WordType.VALUE) {
//					in.getElements().add(this.parseValue(lexer));
//				} else if (word.getType() == WordType.VARIANT) {
//					in.getElements().add(this.parseVariable(lexer));
//				}
//			}
//		}
//
//		SqlBoolExpr threadLocal = exprLocal.get();
//		if (threadLocal == null) {
//			exprLocal.set(in);
//		}
//		return in;
//	}
//
//	/*
//	 * 分析EXIST关键字
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseExist(SqlLexer lexer) throws SQLException {
//		SqlBoolExpr exist = new SqlBoolExpr();
//		exist.setType(Type.EXIST);
//
//		lexer.next();
//		Token token = lexer.getWord().getToken();
//		if (token != Token.LPAREN) {
//			throw new SQLException("syntax error:'(' expected after EXIST");
//		}
//
//		lexer.mark();
//		lexer.next();
//		token = lexer.getWord().getToken();
//		if (token == Token.SELECT) {
//			lexer.reset();
//			SqlSelect select = this.parseSubSelect(lexer);
//			SqlBoolExpr expr = new SqlBoolExpr();
//			expr.setType(Type.SUBSELECT);
//			expr.setValue(select);
//			exist.getElements().add(expr);
//		} else {
//			throw new SQLException("syntax error:'SELECT' expected after EXIST");
//		}
//
//		SqlBoolExpr threadLocal = exprLocal.get();
//		if (threadLocal == null) {
//			exprLocal.set(exist);
//		}
//		return exist;
//	}
//
//	/*
//	 * 分析EXIST关键字
//	 * 
//	 * @param lexer
//	 * 
//	 * @return
//	 * 
//	 * @throws SQLException
//	 */
//	private SqlBoolExpr parseBetween(SqlLexer lexer) throws SQLException {
//		lexer.reset();
//		SqlBoolExpr identifer = new SqlBoolExpr();
//		Word word = lexer.getWord();
//		identifer.setType(Type.COLUMN);
//		String columnName = word.getValue();
//
//		lexer.next();
//		if (lexer.getWord().getToken() == Token.DOT) {
//			columnName = columnName + ".";
//			lexer.next();
//			columnName = columnName + lexer.getWord().getValue();
//		}
//		identifer.setValue(columnName);
//
//		SqlBoolExpr between = new SqlBoolExpr();
//		between.setType(Type.BETWEEN);
//		between.getElements().add(identifer);
//
//		lexer.next();
//		word = lexer.getWord();
//		String leftValue = "";
//		while (word.getToken() != Token.AND) {
//			leftValue = leftValue + word.getValue();
//			lexer.next();
//			word = lexer.getWord();
//		}
//		SqlBoolExpr leftExpr = new SqlBoolExpr();
//		leftExpr.setType(Type.VALUE);
//		leftExpr.setValue(leftValue);
//
//		lexer.next();
//		word = lexer.getWord();
//		String rightValue = "";
//		while (word.getType() != WordType.KEYWORD) {
//			rightValue = rightValue + word.getValue();
//			lexer.next();
//			word = lexer.getWord();
//		}
//		SqlBoolExpr rightExpr = new SqlBoolExpr();
//		rightExpr.setType(Type.VALUE);
//		rightExpr.setValue(rightValue);
//
//		SqlBoolExpr threadLocal = exprLocal.get();
//		if (threadLocal == null) {
//			exprLocal.set(between);
//		}
//		return between;
//	}
//
//	private SqlSelect parseSubSelect(SqlLexer lexer) {
//		return null;
//	}
//
//}
