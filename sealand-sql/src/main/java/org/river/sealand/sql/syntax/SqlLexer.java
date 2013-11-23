package org.river.sealand.sql.syntax;

import java.util.Arrays;

import org.river.sealand.sql.syntax.Word.WordType;
import org.river.sealand.sql.util.CharUtils;
import org.river.sealand.sql.util.Format;
import org.river.sealand.sql.util.SQLException;
import org.river.sealand.sql.util.SQLException.Type;

/**
 * <p>
 * SQL分词器,该类非线程安全
 * 
 * @author river
 * @since Nov 15, 2013
 */
public class SqlLexer {
	/** 该词法分析器要分析到字符串 */
	private final String text;

	/** 当前字符 */
	private char ch;

	/** 当前分析到到位置 */
	private int pos = 0;

	/** next(),成功后该变量保存分析出到词 */
	private Word word;

	/** 记录mark()时的分析点 */
	private LexiPoint savePoint;

	/** 分词起始点 */
	private int markStart = 0;

	/** 分词结束点 */
	private int markOffset = 0;

	private char[] buffer;

	public SqlLexer(String text) {
		this.text = text;
		ch = this.charAt(0);
	}

	/**
	 * <p>
	 * 恢复到之前mark的标志点
	 */
	public void reset() {
		if (savePoint == null) {
			pos = 0;
			word = null;
		} else {
			pos = savePoint.pos;
			word = savePoint.word;
		}
	}

	/**
	 * <p>
	 * 设置可以恢复的分析点
	 */
	public void mark() {
		savePoint = new LexiPoint();
		savePoint.pos = this.pos;
		savePoint.word = this.word;
	}

	/**
	 * <p>
	 * 返回当前返回的分析
	 * 
	 * @return
	 */
	public Word getWord() {
		return this.word;
	}

	/**
	 * <p>
	 * 分析下一词汇，如果分析成功返回true
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean next() throws SQLException {
		if (pos >= text.length()) {
			return false;
		}
		while (true) {
			if (CharUtils.isWhitespace(ch)) {
				nextChar();
				continue;
			}

			if (ch == '$' && charAt(pos + 1) == '{') {
				return scanVariable();
			}

			if (CharUtils.isFirstable4Identifier(ch)) {
				if (charAt(pos + 1) == '\'') {
					++pos;
					ch = '\'';
					return scanString();
				} else {
					return scanIdentifier();
				}
			}

			switch (ch) {
			case '0':
				if (charAt(pos + 1) == 'x') {
					return scanHexDecimal();
				}
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				return scanNumber();
			case ',':
				word = new Word();
				word.setToken(Token.COMMA);
				word.setValue(Token.COMMA.getValue());
				word.setType(WordType.OPERATOR);
				nextChar();
				return true;
			case '(':
				nextChar();
				word = new Word();
				word.setToken(Token.LPAREN);
				word.setValue(Token.LPAREN.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case ')':
				nextChar();
				word = new Word();
				word.setToken(Token.RPAREN);
				word.setValue(Token.RPAREN.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case '[':
				nextChar();
				word = new Word();
				word.setToken(Token.LBRACKET);
				word.setValue(Token.LBRACKET.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case ']':
				nextChar();
				word = new Word();
				word.setToken(Token.RBRACKET);
				word.setValue(Token.RBRACKET.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case '{':
				nextChar();
				word = new Word();
				word.setToken(Token.LBRACE);
				word.setValue(Token.LBRACE.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case '}':
				nextChar();
				word = new Word();
				word.setToken(Token.RBRACE);
				word.setValue(Token.RBRACE.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case ':':
				nextChar();
				return this.scanColon();
			case '#': {
				scanSharp();
				Token token = word.getToken();
				if ((token == Token.LINE_COMMENT || token == Token.MULTI_LINE_COMMENT)) {
					continue;
				}
				return true;
			}
			case '.':
				return this.scanDot();
			case '\'':
				return scanString();
			case '\"':
				return scanAlias();
			case '*':
				nextChar();
				word = new Word();
				word.setToken(Token.STAR);
				word.setValue(Token.STAR.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case '?':
				nextChar();
				word = new Word();
				word.setToken(Token.QUES);
				word.setValue(Token.QUES.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case ';':
				nextChar();
				word = new Word();
				word.setToken(Token.SEMI);
				word.setValue(Token.SEMI.getValue());
				word.setType(WordType.OPERATOR);
				return true;
			case '`':
				throw new SQLException("TODO"); // TODO
			case '@':
				return scanVariable();
			case '-': {
				char subNextChar = charAt(pos + 1);
				if (subNextChar == '-') {
					scanComment();
					Token token = this.getWord().getToken();
					if ((token == Token.LINE_COMMENT || token == Token.MULTI_LINE_COMMENT)) {
						continue;
					}
				} else if (CharUtils.isDigit(subNextChar)) {
					return scanNumber();
				} else {
					return scanOperator();
				}
			}
			case '/':
				int nextChar = charAt(pos + 1);
				if (nextChar == '/' || nextChar == '*') {
					scanComment();
					Token token = this.getWord().getToken();
					if ((token == Token.LINE_COMMENT || token == Token.MULTI_LINE_COMMENT)) {
						continue;
					}
				} else {
					nextChar();
					word = new Word();
					word.setToken(Token.SLASH);
					word.setValue(Token.SLASH.getValue());
					word.setType(WordType.OPERATOR);
					return true;
				}
			default:
				if (Character.isLetter(ch)) {
					return scanIdentifier();
				}

				if (CharUtils.isOperator(ch)) {
					return scanOperator();
				}

				if (isEOF()) {
					word = new Word();
					word.setToken(Token.EOF);
					word.setValue(Token.EOF.getValue());
					return true;
				} else {
					nextChar();
					word = new Word();
					word.setToken(Token.ERROR);
					word.setValue(Token.ERROR.getValue());
					return true;
				}

			}
		}
	}

	/*
	 * 返回指定位置的字符
	 * 
	 * @param i
	 * 
	 * @return
	 */
	private final char charAt(int i) {
		if (i >= text.length()) {
			return Format.EOT;
		}

		return text.charAt(i);
	}

	/*
	 * 分析sql中的变量
	 * 
	 * @return
	 */
	protected boolean scanVariable() throws SQLException {
		if (ch != '@' && ch != ':' && ch != '#' && ch != '$') {
			throw new SQLException(Type.PARSE, SQLException.ILLEGAL_VARIABLE);
		}

		markStart = pos;
		markOffset = 1;
		char tmpCh;

		boolean hasLeftBrace = false;
		if (charAt(pos + 1) == '@') {
			tmpCh = charAt(++pos);

			markOffset++;
		} else if (charAt(pos + 1) == '{') {
			pos++;
			markOffset++;
			hasLeftBrace = true;
		}

		while (true) {
			tmpCh = charAt(++pos);

			if (!CharUtils.isIdentifierChar(tmpCh)) {
				break;
			}

			markOffset++;
			continue;
		}

		if (hasLeftBrace) {
			if (tmpCh != '}') {
				throw new SQLException(Type.PARSE, "syntax error:'}' expected");
			}
			++pos;
			markOffset++;
		}

		this.ch = charAt(pos);

		word = new Word();
		word.setType(WordType.VARIANT);
		word.setToken(Token.VARIANT);
		word.setValue(text.substring(markStart, markOffset));
		return true;
	}

	/**
	 * <p>
	 * 解析字符串
	 * 
	 * @return
	 */
	protected boolean scanString() {
		word = new Word();
		markStart = pos;
		markOffset = 0;
		boolean hasSpecial = false;

		while (true) {
			if (isEOF()) {
				word.setToken(Token.ERROR);
				return true;
			}

			ch = charAt(++pos);

			if (ch == '\'') {
				nextChar();
				if (ch != '\'') {
					word.setToken(Token.LITERAL_CHARS);
					break;
				} else {
					if (!hasSpecial) {
						resizeBuffer(markOffset);
						text.getChars(markStart + 1, markStart + markOffset, buffer, 0);
						hasSpecial = true;
					}
					add2Buf('\'');
					continue;
				}
			}

			if (!hasSpecial) {
				markOffset++;
				continue;
			}

			add2Buf(ch);
		}

		if (!hasSpecial) {
			word.setValue(text.substring(markStart + 1, markStart + markOffset + 1));
		} else {
			word.setValue(new String(buffer, 0, markOffset));
		}
		word.setType(WordType.VALUE);
		return true;
	}

	/**
	 * <p>
	 * 解析标识符
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected boolean scanIdentifier() throws SQLException {

		if (!CharUtils.isFirstable4Identifier(ch)) {
			throw new SQLException("illegal identifier");
		}

		markStart = pos;
		markOffset = 1;
		char ch;
		while (true) {
			ch = charAt(++pos);

			if (!CharUtils.isIdentifierChar(ch)) {
				break;
			}

			markOffset++;
			continue;
		}

		this.ch = charAt(pos);

		word = new Word();
		word.setValue(text.substring(markStart, markStart + markOffset));
		Token token = Token.getKeyword(word.getValue());
		WordType wordType = (token != null) ? WordType.KEYWORD : WordType.IDENTIFIER;
		if(token==Token.LIKE){
			wordType=WordType.OPERATOR;
		}
		word.setType(wordType);
		token = token != null ? token : Token.IDENTIFIER;
		word.setToken(token);
		return true;
	}

	/**
	 * <p>
	 * 
	 * @return
	 */
	protected boolean scanHexDecimal() {
		markStart = pos;

		if (ch == '-') {
			markOffset++;
			ch = charAt(++pos);
		}

		while (true) {
			if (CharUtils.isHex(ch)) {
				markOffset++;
			} else {
				break;
			}
			ch = charAt(++pos);
		}

		word = new Word();
		word.setToken(Token.LITERAL_HEX);
		word.setType(WordType.VALUE);
		return true;
	}

	/**
	 * <p>
	 * 解析sql中的数字
	 * 
	 * @return
	 */
	protected boolean scanNumber() {
		word = new Word();
		word.setToken(Token.LITERAL_INT);
		markStart = pos;
		markOffset = 0;

		if (ch == '-') {
			markOffset++;
			ch = charAt(++pos);
		}

		while (true) {
			if (ch >= '0' && ch <= '9') {
				markOffset++;
			} else {
				break;
			}
			ch = charAt(++pos);
		}

		boolean isFloat = false;

		if (ch == '.') {
			if (charAt(pos + 1) == '.') {
				word.setToken(Token.LITERAL_INT);
				return true;
			}
			markOffset++;
			ch = charAt(++pos);
			isFloat = true;
		}

		while (isFloat) {
			if (ch >= '0' && ch <= '9') {
				markOffset++;
			} else {
				break;
			}
			ch = charAt(++pos);
		}

		if (ch == 'e' || ch == 'E') {
			markOffset++;
			ch = charAt(++pos);

			if (ch == '+' || ch == '-') {
				markOffset++;
				ch = charAt(++pos);
			}

			while (true) {
				if (ch >= '0' && ch <= '9') {
					markOffset++;
				} else {
					break;
				}
				ch = charAt(++pos);
			}

			isFloat = true;
		}

		if (isFloat) {
			word.setToken(Token.LITERAL_FLOAT);
		}

		word.setValue(text.substring(markStart, markStart + markOffset));
		word.setType(WordType.VALUE);
		return true;
	}

	/**
	 * <p>
	 * 解析sql中的注释
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected boolean scanComment() throws SQLException {
		word = new Word();
		if (ch != '/') {
			throw new SQLException("syntax error:'/' expected");
		}

		markStart = pos;
		markOffset = 0;
		nextChar();

		if (ch == '*') {
			nextChar();
			markOffset++;

			while (true) {
				if (ch == '*' && charAt(pos + 1) == '/') {
					markOffset += 2;
					nextChar();
					nextChar();
					break;
				}

				nextChar();
				markOffset++;
			}

			word.setValue(text.substring(markStart, markStart + markOffset));
			word.setToken(Token.MULTI_LINE_COMMENT);
			return true;
		} else if (ch == '/') {
			nextChar();
			markOffset++;

			while (true) {
				if (ch == '\r') {
					if (charAt(pos + 1) == '\n') {
						markOffset += 2;
						nextChar();
						break;
					}
					markOffset++;
					break;
				}

				if (ch == '\n') {
					nextChar();
					markOffset++;
					break;
				}

				nextChar();
				markOffset++;
			}

			word.setValue(text.substring(markStart, markStart + markOffset));
			word.setToken(Token.LINE_COMMENT);
			return true;
		} else {
			throw new SQLException("syntax error:'/' or '*' expected");
		}
	}

	/**
	 * <p>
	 * 解析操作符
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected boolean scanOperator() throws SQLException {
		word = new Word();
		switch (ch) {
		case '+':
			nextChar();
			word.setToken(Token.PLUS);
			word.setValue("+");
			break;
		case '-':
			nextChar();
			word.setToken(Token.SUB);
			word.setValue("-");
			break;
		case '*':
			nextChar();
			word.setToken(Token.STAR);
			word.setValue("*");
			break;
		case '/':
			nextChar();
			word.setToken(Token.SLASH);
			word.setValue("/");
			break;
		case '&':
			nextChar();
			if (ch == '&') {
				nextChar();
				word.setToken(Token.AMPAMP);
				word.setValue("&&");
			} else {
				word.setToken(Token.AMP);
				word.setValue("&");
			}
			break;
		case '|':
			nextChar();
			if (ch == '|') {
				nextChar();
				word.setToken(Token.BARBAR);
				word.setValue("||");
			} else {
				word.setToken(Token.BAR);
				word.setValue("|");
			}
			break;
		case '^':
			nextChar();
			word.setToken(Token.CARET);
			word.setValue("^");
			break;
		case '%':
			nextChar();
			word.setToken(Token.PERCENT);
			word.setValue("%");
			break;
		case '=':
			nextChar();
			if (ch == '=') {
				nextChar();
				word.setToken(Token.EQEQ);
				word.setValue("==");
			} else {
				word.setToken(Token.EQ);
				word.setValue("=");
			}
			break;
		case '>':
			nextChar();
			if (ch == '=') {
				nextChar();
				word.setToken(Token.GTEQ);
				word.setValue(">=");
			} else if (ch == '>') {
				nextChar();
				word.setToken(Token.GTGT);
				word.setValue(">>");
			} else {
				word.setToken(Token.GT);
				word.setValue(">");
			}
			break;
		case '<':
			nextChar();
			if (ch == '=') {
				nextChar();
				word.setToken(Token.LTEQ);
				word.setValue("<=");
			} else if (ch == '<') {
				nextChar();
				word.setToken(Token.LTLT);
				word.setValue("<<");
			} else {
				word.setToken(Token.LT);
				word.setValue("<");
			}
			break;
		case '!':
			nextChar();
			if (ch == '=') {
				nextChar();
				word.setToken(Token.BANGEQ);
				word.setValue("!=");
			} else if (ch == '>') {
				nextChar();
				word.setToken(Token.BANGGT);
				word.setValue("!>");
			} else if (ch == '<') {
				nextChar();
				word.setToken(Token.BANGLT);
				word.setValue("!<");
			} else {
				word.setToken(Token.BANG);
				word.setValue("!");
			}
			break;
		case '?':
			nextChar();
			word.setToken(Token.QUES);
			word.setValue("?");
			break;
		case '~':
			nextChar();
			word.setToken(Token.TILDE);
			word.setValue("~");
			break;
		default:
			throw new SQLException("syntax error:operter" + ch + "not support");
		}
		word.setType(WordType.OPERATOR);
		return true;
	}

	/**
	 * <p>
	 * 解析sql中的.
	 * 
	 * @return
	 */
	protected boolean scanDot() {
		nextChar();
		if (CharUtils.isDigit(ch)) {
			previousChar();
			return scanNumber();
		} else {
			word = new Word();
			word.setToken(Token.DOT);
			word.setValue(Token.DOT.getValue());
			word.setType(WordType.OPERATOR);
			return true;
		}
	}

	protected boolean scanColon() throws SQLException {
		if (ch == '=') {
			nextChar();
			word = new Word();
			word.setToken(Token.COLONEQ);
			word.setValue(Token.COLONEQ.getValue());
			return true;
		} else if (ch == ':') {
			nextChar();
			word = new Word();
			word.setToken(Token.COLONCOLON);
			word.setValue(Token.COLONCOLON.getValue());
			return true;
		} else {
			if (CharUtils.isDigit(ch)) {
				nextChar();
			} else {
				previousChar();
			}
			return scanVariable();
		}
	}

	/**
	 * <p>
	 * 解析出sql中的别名
	 * 
	 * @return
	 */
	protected boolean scanAlias() {
		markStart = pos;
		buffer = new char[32];

		word = new Word();
		while (true) {
			if (isEOF()) {
				word.setToken(Token.ERROR);
				return true;
			}

			ch = charAt(++pos);

			if (ch == '\"') {
				nextChar();
				word.setToken(Token.LITERAL_ALIAS);
				break;
			}

			add2Buf(ch);
		}

		word.setValue(text.substring(markStart + 1, markStart + markOffset));
		word.setType(WordType.ALIAS);
		return true;
	}

	protected boolean scanSharp() throws SQLException {
		return scanVariable();
	}

	protected final void nextChar() {
		ch = charAt(++pos);
	}

	protected void previousChar() {
		ch = charAt(--pos);
	}

	public boolean isEOF() {
		return pos >= text.length();
	}

	protected void resizeBuffer(int size) {
		if (buffer == null) {
			if (size < 32) {
				buffer = new char[32];
			} else {
				buffer = new char[size + 32];
			}
		} else if (buffer.length < size) {
			buffer = Arrays.copyOf(buffer, size);
		}
	}

	protected final void add2Buf(char ch) {
		if (markOffset == buffer.length) {
			char[] newsbuf = new char[buffer.length * 2];
			System.arraycopy(buffer, 0, newsbuf, 0, buffer.length);
			buffer = newsbuf;
		}
		buffer[markOffset++] = ch;
	}

	/**
	 * <p>
	 * 语法分析点
	 * 
	 * @author river
	 * @since Nov 15, 2013
	 */
	private static class LexiPoint {
		/** 分析点位置 */
		int pos;

		/** 分析点分析到的词 */
		Word word;
	}
}
