// Generated from SQLCommon.g by ANTLR 4.1

  package org.river.sealand.sql.syntex;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLCommonParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARMSCII8=1, ASCII=2, BIG5=3, BINARY=4, CP1250=5, CP1251=6, CP1256=7, CP1257=8, 
		CP850=9, CP852=10, CP866=11, CP932=12, DEC8=13, EUCJPMS=14, EUCKR=15, 
		GB2312=16, GBK=17, GEOSTD8=18, GREEK=19, HEBREW=20, HP8=21, KEYBCS2=22, 
		KOI8R=23, KOI8U=24, LATIN1=25, LATIN2=26, LATIN5=27, LATIN7=28, MACCE=29, 
		MACROMAN=30, SJIS=31, SWE7=32, TIS620=33, UCS2=34, UJIS=35, UTF8=36, CHARSET_NAME=37, 
		E_SYM=38, SELECT=39, INSERT=40, UPDATE=41, DELETE=42, INTO=43, SET=44, 
		FROM=45, UNION=46, UNION_ALL=47, ALL=48, DISTINCT=49, GROUP_BY=50, HAVING=51, 
		WHERE=52, ON=53, ORDER_BY=54, LIMIT=55, AS=56, CASE=57, WHEN=58, ELSE=59, 
		THEN=60, INNER=61, JOIN=62, ASC=63, DESC=64, END=65, LEFT=66, RIGHT=67, 
		OUTER=68, NOT=69, AND=70, OR=71, IN=72, EXIST=73, BETWEEN=74, NULL=75, 
		VALUES=76, DOT=77, VERTICAL_BAR=78, DOUBLE_VERTICAL_BAR=79, PLUS=80, DIV=81, 
		MINUS=82, PERCENT=83, COMMA=84, SEMI=85, COLON=86, RBRACK=87, LBRACK=88, 
		NEGATION=89, BITAND=90, POWER_OP=91, LPAREN=92, RPAREN=93, ASTERISK=94, 
		GT=95, GE=96, EQ=97, LT=98, LE=99, LIKE=100, ID=101, INT=102, FLOAT=103, 
		CHAR_LITERAL=104, HEX=105, BIT=106, BOOLEAN=107, NEWLINE=108, WS=109;
	public static final String[] tokenNames = {
		"<INVALID>", "ARMSCII8", "ASCII", "BIG5", "BINARY", "CP1250", "CP1251", 
		"CP1256", "CP1257", "CP850", "CP852", "CP866", "CP932", "DEC8", "EUCJPMS", 
		"EUCKR", "GB2312", "GBK", "GEOSTD8", "GREEK", "HEBREW", "HP8", "KEYBCS2", 
		"KOI8R", "KOI8U", "LATIN1", "LATIN2", "LATIN5", "LATIN7", "MACCE", "MACROMAN", 
		"SJIS", "SWE7", "TIS620", "UCS2", "UJIS", "UTF8", "CHARSET_NAME", "E_SYM", 
		"SELECT", "INSERT", "UPDATE", "DELETE", "INTO", "SET", "FROM", "UNION", 
		"UNION_ALL", "ALL", "DISTINCT", "GROUP_BY", "HAVING", "WHERE", "ON", "ORDER_BY", 
		"LIMIT", "AS", "CASE", "WHEN", "ELSE", "THEN", "INNER", "JOIN", "ASC", 
		"DESC", "END", "LEFT", "RIGHT", "OUTER", "NOT", "AND", "OR", "IN", "EXIST", 
		"BETWEEN", "NULL", "VALUES", "DOT", "'|'", "'||'", "'+'", "'/'", "'-'", 
		"'%'", "','", "';'", "':'", "']'", "'['", "'~'", "'&'", "'^'", "'('", 
		"')'", "'*'", "'>'", "'>='", "'='", "'<'", "'<='", "LIKE", "ID", "INT", 
		"FLOAT", "CHAR_LITERAL", "HEX", "BIT", "BOOLEAN", "NEWLINE", "WS"
	};
	public static final int
		RULE_statement = 0, RULE_select_stmt = 1, RULE_expr_stmt = 2, RULE_select_clause = 3, 
		RULE_insert_clause = 4, RULE_update_clause = 5, RULE_delete_clause = 6, 
		RULE_values_list = 7, RULE_select_list = 8, RULE_column_list = 9, RULE_set_list = 10, 
		RULE_set_clause = 11, RULE_where_clause = 12, RULE_having_clause = 13, 
		RULE_group_by_clause = 14, RULE_group_by_item = 15, RULE_order_by_clause = 16, 
		RULE_order_by_item = 17, RULE_limit_clause = 18, RULE_display_column = 19, 
		RULE_criteria = 20, RULE_between_expr = 21, RULE_exist_expr = 22, RULE_in_expr = 23, 
		RULE_expression = 24, RULE_case_when_clause = 25, RULE_case_when_clause_0 = 26, 
		RULE_case_when_clause_1 = 27, RULE_table_refs = 28, RULE_table_atom = 29, 
		RULE_join_condition = 30, RULE_sub_query = 31, RULE_literal_value = 32, 
		RULE_number = 33, RULE_char_literal = 34, RULE_sql_id = 35;
	public static final String[] ruleNames = {
		"statement", "select_stmt", "expr_stmt", "select_clause", "insert_clause", 
		"update_clause", "delete_clause", "values_list", "select_list", "column_list", 
		"set_list", "set_clause", "where_clause", "having_clause", "group_by_clause", 
		"group_by_item", "order_by_clause", "order_by_item", "limit_clause", "display_column", 
		"criteria", "between_expr", "exist_expr", "in_expr", "expression", "case_when_clause", 
		"case_when_clause_0", "case_when_clause_1", "table_refs", "table_atom", 
		"join_condition", "sub_query", "literal_value", "number", "char_literal", 
		"sql_id"
	};

	@Override
	public String getGrammarFileName() { return "SQLCommon.g"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLCommonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatementContext extends ParserRuleContext {
		public Update_clauseContext update_clause() {
			return getRuleContext(Update_clauseContext.class,0);
		}
		public Delete_clauseContext delete_clause() {
			return getRuleContext(Delete_clauseContext.class,0);
		}
		public Insert_clauseContext insert_clause() {
			return getRuleContext(Insert_clauseContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			setState(76);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(72); select_stmt();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); insert_clause();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(74); update_clause();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 4);
				{
				setState(75); delete_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_stmtContext extends ParserRuleContext {
		public List<TerminalNode> UNION() { return getTokens(SQLCommonParser.UNION); }
		public List<Select_clauseContext> select_clause() {
			return getRuleContexts(Select_clauseContext.class);
		}
		public List<TerminalNode> ALL() { return getTokens(SQLCommonParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(SQLCommonParser.ALL, i);
		}
		public Select_clauseContext select_clause(int i) {
			return getRuleContext(Select_clauseContext.class,i);
		}
		public TerminalNode UNION(int i) {
			return getToken(SQLCommonParser.UNION, i);
		}
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSelect_stmt(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); select_clause();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNION) {
				{
				{
				{
				setState(79); match(UNION);
				setState(81);
				_la = _input.LA(1);
				if (_la==ALL) {
					{
					setState(80); match(ALL);
					}
				}

				}
				setState(83); select_clause();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SQLCommonParser.NEWLINE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr_stmt);
		try {
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); expression(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90); expression(0);
				setState(91); match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_clauseContext extends ParserRuleContext {
		public Group_by_clauseContext group_by_clause() {
			return getRuleContext(Group_by_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode ALL() { return getToken(SQLCommonParser.ALL, 0); }
		public TerminalNode DISTINCT() { return getToken(SQLCommonParser.DISTINCT, 0); }
		public Table_refsContext table_refs() {
			return getRuleContext(Table_refsContext.class,0);
		}
		public Limit_clauseContext limit_clause() {
			return getRuleContext(Limit_clauseContext.class,0);
		}
		public Order_by_clauseContext order_by_clause() {
			return getRuleContext(Order_by_clauseContext.class,0);
		}
		public Having_clauseContext having_clause() {
			return getRuleContext(Having_clauseContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(SQLCommonParser.SELECT, 0); }
		public Select_listContext select_list() {
			return getRuleContext(Select_listContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLCommonParser.FROM, 0); }
		public Select_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSelect_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSelect_clause(this);
		}
	}

	public final Select_clauseContext select_clause() throws RecognitionException {
		Select_clauseContext _localctx = new Select_clauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_select_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(SELECT);
			setState(97);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==ALL || _la==DISTINCT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(99); select_list();
			setState(100); match(FROM);
			setState(101); table_refs();
			setState(103);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(102); where_clause();
				}
			}

			setState(106);
			_la = _input.LA(1);
			if (_la==GROUP_BY) {
				{
				setState(105); group_by_clause();
				}
			}

			setState(109);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(108); having_clause();
				}
			}

			setState(112);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(111); order_by_clause();
				}
			}

			setState(115);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(114); limit_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_clauseContext extends ParserRuleContext {
		public TerminalNode LPAREN(int i) {
			return getToken(SQLCommonParser.LPAREN, i);
		}
		public TerminalNode RPAREN(int i) {
			return getToken(SQLCommonParser.RPAREN, i);
		}
		public TerminalNode INTO() { return getToken(SQLCommonParser.INTO, 0); }
		public List<TerminalNode> RPAREN() { return getTokens(SQLCommonParser.RPAREN); }
		public Column_listContext column_list() {
			return getRuleContext(Column_listContext.class,0);
		}
		public Values_listContext values_list() {
			return getRuleContext(Values_listContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(SQLCommonParser.INSERT, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(SQLCommonParser.LPAREN); }
		public TerminalNode VALUES() { return getToken(SQLCommonParser.VALUES, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public Sub_queryContext sub_query() {
			return getRuleContext(Sub_queryContext.class,0);
		}
		public Insert_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterInsert_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitInsert_clause(this);
		}
	}

	public final Insert_clauseContext insert_clause() throws RecognitionException {
		Insert_clauseContext _localctx = new Insert_clauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_insert_clause);
		try {
			setState(149);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117); match(INSERT);
				setState(118); match(INTO);
				setState(119); sql_id();
				setState(120); sub_query();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122); match(INSERT);
				setState(123); match(INTO);
				setState(124); sql_id();
				setState(125); match(VALUES);
				setState(126); match(LPAREN);
				setState(127); values_list();
				setState(128); match(RPAREN);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); match(INSERT);
				setState(131); match(INTO);
				setState(132); sql_id();
				setState(133); match(LPAREN);
				setState(134); column_list();
				setState(135); match(RPAREN);
				setState(136); sub_query();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(138); match(INSERT);
				setState(139); match(INTO);
				setState(140); sql_id();
				setState(141); match(LPAREN);
				setState(142); column_list();
				setState(143); match(RPAREN);
				setState(144); match(VALUES);
				setState(145); match(LPAREN);
				setState(146); values_list();
				setState(147); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_clauseContext extends ParserRuleContext {
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode SET() { return getToken(SQLCommonParser.SET, 0); }
		public Set_listContext set_list() {
			return getRuleContext(Set_listContext.class,0);
		}
		public TerminalNode UPDATE() { return getToken(SQLCommonParser.UPDATE, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public Update_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterUpdate_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitUpdate_clause(this);
		}
	}

	public final Update_clauseContext update_clause() throws RecognitionException {
		Update_clauseContext _localctx = new Update_clauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_update_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(UPDATE);
			setState(152); sql_id();
			setState(153); match(SET);
			setState(154); set_list();
			setState(156);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(155); where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_clauseContext extends ParserRuleContext {
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SQLCommonParser.DELETE, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLCommonParser.FROM, 0); }
		public Delete_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterDelete_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitDelete_clause(this);
		}
	}

	public final Delete_clauseContext delete_clause() throws RecognitionException {
		Delete_clauseContext _localctx = new Delete_clauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_delete_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(DELETE);
			setState(159); match(FROM);
			setState(160); sql_id();
			setState(162);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(161); where_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Values_listContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Values_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterValues_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitValues_list(this);
		}
	}

	public final Values_listContext values_list() throws RecognitionException {
		Values_listContext _localctx = new Values_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_values_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); expression(0);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(165); match(COMMA);
				setState(166); expression(0);
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_listContext extends ParserRuleContext {
		public List<Display_columnContext> display_column() {
			return getRuleContexts(Display_columnContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public Display_columnContext display_column(int i) {
			return getRuleContext(Display_columnContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Select_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSelect_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSelect_list(this);
		}
	}

	public final Select_listContext select_list() throws RecognitionException {
		Select_listContext _localctx = new Select_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172); display_column();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173); match(COMMA);
				setState(174); display_column();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_listContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public Sql_idContext sql_id(int i) {
			return getRuleContext(Sql_idContext.class,i);
		}
		public List<Sql_idContext> sql_id() {
			return getRuleContexts(Sql_idContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Column_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterColumn_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitColumn_list(this);
		}
	}

	public final Column_listContext column_list() throws RecognitionException {
		Column_listContext _localctx = new Column_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_column_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); sql_id();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(181); match(COMMA);
				setState(182); sql_id();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_listContext extends ParserRuleContext {
		public List<Set_clauseContext> set_clause() {
			return getRuleContexts(Set_clauseContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public Set_clauseContext set_clause(int i) {
			return getRuleContext(Set_clauseContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Set_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSet_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSet_list(this);
		}
	}

	public final Set_listContext set_list() throws RecognitionException {
		Set_listContext _localctx = new Set_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); set_clause();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(189); match(COMMA);
				setState(190); set_clause();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_clauseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SQLCommonParser.EQ, 0); }
		public Set_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSet_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSet_clause(this);
		}
	}

	public final Set_clauseContext set_clause() throws RecognitionException {
		Set_clauseContext _localctx = new Set_clauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_set_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); sql_id();
			setState(197); match(EQ);
			setState(198); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLCommonParser.WHERE, 0); }
		public CriteriaContext criteria() {
			return getRuleContext(CriteriaContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitWhere_clause(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(WHERE);
			setState(201); criteria(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Having_clauseContext extends ParserRuleContext {
		public CriteriaContext criteria() {
			return getRuleContext(CriteriaContext.class,0);
		}
		public TerminalNode HAVING() { return getToken(SQLCommonParser.HAVING, 0); }
		public Having_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterHaving_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitHaving_clause(this);
		}
	}

	public final Having_clauseContext having_clause() throws RecognitionException {
		Having_clauseContext _localctx = new Having_clauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(HAVING);
			setState(204); criteria(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Group_by_clauseContext extends ParserRuleContext {
		public List<Group_by_itemContext> group_by_item() {
			return getRuleContexts(Group_by_itemContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public TerminalNode GROUP_BY() { return getToken(SQLCommonParser.GROUP_BY, 0); }
		public Group_by_itemContext group_by_item(int i) {
			return getRuleContext(Group_by_itemContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Group_by_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_by_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterGroup_by_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitGroup_by_clause(this);
		}
	}

	public final Group_by_clauseContext group_by_clause() throws RecognitionException {
		Group_by_clauseContext _localctx = new Group_by_clauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_group_by_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(GROUP_BY);
			setState(207); group_by_item();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(208); match(COMMA);
				setState(209); group_by_item();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Group_by_itemContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SQLCommonParser.INT, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public Group_by_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_by_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterGroup_by_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitGroup_by_item(this);
		}
	}

	public final Group_by_itemContext group_by_item() throws RecognitionException {
		Group_by_itemContext _localctx = new Group_by_itemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_group_by_item);
		try {
			setState(217);
			switch (_input.LA(1)) {
			case ASTERISK:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(215); sql_id();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(216); match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_clauseContext extends ParserRuleContext {
		public Order_by_itemContext order_by_item(int i) {
			return getRuleContext(Order_by_itemContext.class,i);
		}
		public List<Order_by_itemContext> order_by_item() {
			return getRuleContexts(Order_by_itemContext.class);
		}
		public TerminalNode ORDER_BY() { return getToken(SQLCommonParser.ORDER_BY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Order_by_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterOrder_by_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitOrder_by_clause(this);
		}
	}

	public final Order_by_clauseContext order_by_clause() throws RecognitionException {
		Order_by_clauseContext _localctx = new Order_by_clauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_order_by_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(ORDER_BY);
			setState(220); order_by_item();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(221); match(COMMA);
				setState(222); order_by_item();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_itemContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(SQLCommonParser.DESC, 0); }
		public TerminalNode INT() { return getToken(SQLCommonParser.INT, 0); }
		public TerminalNode ASC() { return getToken(SQLCommonParser.ASC, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public Order_by_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterOrder_by_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitOrder_by_item(this);
		}
	}

	public final Order_by_itemContext order_by_item() throws RecognitionException {
		Order_by_itemContext _localctx = new Order_by_itemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_order_by_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			switch (_input.LA(1)) {
			case ASTERISK:
			case ID:
				{
				setState(228); sql_id();
				}
				break;
			case INT:
				{
				setState(229); match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(233);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(232);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Limit_clauseContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SQLCommonParser.LIMIT, 0); }
		public List<TerminalNode> INT() { return getTokens(SQLCommonParser.INT); }
		public TerminalNode COMMA() { return getToken(SQLCommonParser.COMMA, 0); }
		public TerminalNode INT(int i) {
			return getToken(SQLCommonParser.INT, i);
		}
		public Limit_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterLimit_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitLimit_clause(this);
		}
	}

	public final Limit_clauseContext limit_clause() throws RecognitionException {
		Limit_clauseContext _localctx = new Limit_clauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(LIMIT);
			{
			setState(238);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(236); match(INT);
				setState(237); match(COMMA);
				}
				break;
			}
			setState(240); match(INT);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Display_columnContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(SQLCommonParser.AS, 0); }
		public TerminalNode ASTERISK() { return getToken(SQLCommonParser.ASTERISK, 0); }
		public TerminalNode DOT() { return getToken(SQLCommonParser.DOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public Case_when_clauseContext case_when_clause() {
			return getRuleContext(Case_when_clauseContext.class,0);
		}
		public Display_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_display_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterDisplay_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitDisplay_column(this);
		}
	}

	public final Display_columnContext display_column() throws RecognitionException {
		Display_columnContext _localctx = new Display_columnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_display_column);
		int _la;
		try {
			setState(259);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242); expression(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243); expression(0);
				setState(245);
				_la = _input.LA(1);
				if (_la==ASTERISK || _la==ID) {
					{
					setState(244); sql_id();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247); expression(0);
				setState(250);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(248); match(AS);
					setState(249); sql_id();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(252); case_when_clause();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(253); sql_id();
				setState(254); match(DOT);
				setState(255); match(ASTERISK);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(257); match(ASTERISK);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(258); sql_id();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CriteriaContext extends ParserRuleContext {
		public int _p;
		public List<CriteriaContext> criteria() {
			return getRuleContexts(CriteriaContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(SQLCommonParser.AND); }
		public List<TerminalNode> OR() { return getTokens(SQLCommonParser.OR); }
		public TerminalNode LE() { return getToken(SQLCommonParser.LE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(SQLCommonParser.AND, i);
		}
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public TerminalNode EQ() { return getToken(SQLCommonParser.EQ, 0); }
		public TerminalNode GE() { return getToken(SQLCommonParser.GE, 0); }
		public CriteriaContext criteria(int i) {
			return getRuleContext(CriteriaContext.class,i);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public In_exprContext in_expr() {
			return getRuleContext(In_exprContext.class,0);
		}
		public TerminalNode LT() { return getToken(SQLCommonParser.LT, 0); }
		public TerminalNode NOT() { return getToken(SQLCommonParser.NOT, 0); }
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public Exist_exprContext exist_expr() {
			return getRuleContext(Exist_exprContext.class,0);
		}
		public Between_exprContext between_expr() {
			return getRuleContext(Between_exprContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SQLCommonParser.LIKE, 0); }
		public TerminalNode GT() { return getToken(SQLCommonParser.GT, 0); }
		public TerminalNode OR(int i) {
			return getToken(SQLCommonParser.OR, i);
		}
		public CriteriaContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CriteriaContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_criteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitCriteria(this);
		}
	}

	public final CriteriaContext criteria(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CriteriaContext _localctx = new CriteriaContext(_ctx, _parentState, _p);
		CriteriaContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, RULE_criteria);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(262); match(NOT);
				setState(263); criteria(5);
				}
				break;

			case 2:
				{
				setState(264); match(LPAREN);
				setState(265); criteria(0);
				setState(266); match(RPAREN);
				}
				break;

			case 3:
				{
				setState(268); expression(0);
				setState(269);
				_la = _input.LA(1);
				if ( !(((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (GT - 95)) | (1L << (GE - 95)) | (1L << (EQ - 95)) | (1L << (LT - 95)) | (1L << (LE - 95)) | (1L << (LIKE - 95)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(270); expression(0);
				}
				break;

			case 4:
				{
				setState(272); between_expr();
				}
				break;

			case 5:
				{
				setState(273); in_expr();
				}
				break;

			case 6:
				{
				setState(274); exist_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CriteriaContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_criteria);
					setState(277);
					if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
					setState(280); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(278);
							_la = _input.LA(1);
							if ( !(_la==AND || _la==OR) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(279); criteria(0);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(282); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					} while ( _alt!=2 && _alt!=-1 );
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Between_exprContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(SQLCommonParser.BETWEEN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SQLCommonParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Between_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterBetween_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitBetween_expr(this);
		}
	}

	public final Between_exprContext between_expr() throws RecognitionException {
		Between_exprContext _localctx = new Between_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_between_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); expression(0);
			setState(290); match(BETWEEN);
			setState(291); expression(0);
			setState(292); match(AND);
			setState(293); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exist_exprContext extends ParserRuleContext {
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public TerminalNode EXIST() { return getToken(SQLCommonParser.EXIST, 0); }
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public Sub_queryContext sub_query() {
			return getRuleContext(Sub_queryContext.class,0);
		}
		public Exist_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exist_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterExist_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitExist_expr(this);
		}
	}

	public final Exist_exprContext exist_expr() throws RecognitionException {
		Exist_exprContext _localctx = new Exist_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exist_expr);
		try {
			setState(302);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295); match(EXIST);
				setState(296); sub_query();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297); match(EXIST);
				setState(298); match(LPAREN);
				setState(299); sub_query();
				setState(300); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_exprContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SQLCommonParser.IN, 0); }
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public Values_listContext values_list() {
			return getRuleContext(Values_listContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public Sub_queryContext sub_query() {
			return getRuleContext(Sub_queryContext.class,0);
		}
		public In_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterIn_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitIn_expr(this);
		}
	}

	public final In_exprContext in_expr() throws RecognitionException {
		In_exprContext _localctx = new In_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_in_expr);
		try {
			setState(320);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304); expression(0);
				setState(305); match(IN);
				setState(306); match(LPAREN);
				setState(307); values_list();
				setState(308); match(RPAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310); expression(0);
				setState(311); match(IN);
				setState(312); sub_query();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(314); expression(0);
				setState(315); match(IN);
				setState(316); match(LPAREN);
				setState(317); sub_query();
				setState(318); match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SQLCommonParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SQLCommonParser.ASTERISK, 0); }
		public TerminalNode DIV() { return getToken(SQLCommonParser.DIV, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(SQLCommonParser.PLUS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(323); match(LPAREN);
				setState(324); expression(0);
				setState(325); match(RPAREN);
				}
				break;

			case 2:
				{
				setState(327); sql_id();
				setState(328); match(LPAREN);
				setState(329); expression(0);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(330); match(COMMA);
					setState(331); expression(0);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(337); match(RPAREN);
				}
				break;

			case 3:
				{
				setState(339); sql_id();
				setState(340); match(LPAREN);
				setState(341); match(RPAREN);
				}
				break;

			case 4:
				{
				setState(343); char_literal();
				}
				break;

			case 5:
				{
				setState(344); number();
				}
				break;

			case 6:
				{
				setState(345); sql_id();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(354);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(348);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(349);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==ASTERISK) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(350); expression(9);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(351);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(352);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(353); expression(8);
						}
						break;
					}
					} 
				}
				setState(358);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Case_when_clauseContext extends ParserRuleContext {
		public Case_when_clause_0Context case_when_clause_0() {
			return getRuleContext(Case_when_clause_0Context.class,0);
		}
		public Case_when_clause_1Context case_when_clause_1() {
			return getRuleContext(Case_when_clause_1Context.class,0);
		}
		public Case_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_when_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterCase_when_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitCase_when_clause(this);
		}
	}

	public final Case_when_clauseContext case_when_clause() throws RecognitionException {
		Case_when_clauseContext _localctx = new Case_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_case_when_clause);
		try {
			setState(361);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(359); case_when_clause_0();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360); case_when_clause_1();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_when_clause_0Context extends ParserRuleContext {
		public List<TerminalNode> THEN() { return getTokens(SQLCommonParser.THEN); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHEN(int i) {
			return getToken(SQLCommonParser.WHEN, i);
		}
		public TerminalNode THEN(int i) {
			return getToken(SQLCommonParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(SQLCommonParser.ELSE, 0); }
		public TerminalNode CASE() { return getToken(SQLCommonParser.CASE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<TerminalNode> WHEN() { return getTokens(SQLCommonParser.WHEN); }
		public TerminalNode END() { return getToken(SQLCommonParser.END, 0); }
		public Case_when_clause_0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_when_clause_0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterCase_when_clause_0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitCase_when_clause_0(this);
		}
	}

	public final Case_when_clause_0Context case_when_clause_0() throws RecognitionException {
		Case_when_clause_0Context _localctx = new Case_when_clause_0Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_case_when_clause_0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363); match(CASE);
			setState(369); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(364); match(WHEN);
				setState(365); expression(0);
				setState(366); match(THEN);
				setState(367); expression(0);
				}
				}
				setState(371); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(375);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(373); match(ELSE);
				setState(374); expression(0);
				}
			}

			setState(377); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_when_clause_1Context extends ParserRuleContext {
		public List<TerminalNode> THEN() { return getTokens(SQLCommonParser.THEN); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHEN(int i) {
			return getToken(SQLCommonParser.WHEN, i);
		}
		public TerminalNode THEN(int i) {
			return getToken(SQLCommonParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(SQLCommonParser.ELSE, 0); }
		public TerminalNode CASE() { return getToken(SQLCommonParser.CASE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<TerminalNode> WHEN() { return getTokens(SQLCommonParser.WHEN); }
		public TerminalNode END() { return getToken(SQLCommonParser.END, 0); }
		public Case_when_clause_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_when_clause_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterCase_when_clause_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitCase_when_clause_1(this);
		}
	}

	public final Case_when_clause_1Context case_when_clause_1() throws RecognitionException {
		Case_when_clause_1Context _localctx = new Case_when_clause_1Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_case_when_clause_1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); match(CASE);
			setState(380); expression(0);
			setState(386); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(381); match(WHEN);
				setState(382); expression(0);
				setState(383); match(THEN);
				setState(384); expression(0);
				}
				}
				setState(388); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(392);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(390); match(ELSE);
				setState(391); expression(0);
				}
			}

			setState(394); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_refsContext extends ParserRuleContext {
		public Table_atomContext table_atom(int i) {
			return getRuleContext(Table_atomContext.class,i);
		}
		public List<Table_atomContext> table_atom() {
			return getRuleContexts(Table_atomContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
		public Table_refsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_refs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterTable_refs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitTable_refs(this);
		}
	}

	public final Table_refsContext table_refs() throws RecognitionException {
		Table_refsContext _localctx = new Table_refsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_table_refs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); table_atom(0);
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(397); match(COMMA);
				setState(398); table_atom(0);
				}
				}
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_atomContext extends ParserRuleContext {
		public int _p;
		public List<TerminalNode> OUTER() { return getTokens(SQLCommonParser.OUTER); }
		public TerminalNode AS() { return getToken(SQLCommonParser.AS, 0); }
		public List<TerminalNode> JOIN() { return getTokens(SQLCommonParser.JOIN); }
		public List<Join_conditionContext> join_condition() {
			return getRuleContexts(Join_conditionContext.class);
		}
		public Table_atomContext table_atom(int i) {
			return getRuleContext(Table_atomContext.class,i);
		}
		public TerminalNode RIGHT(int i) {
			return getToken(SQLCommonParser.RIGHT, i);
		}
		public TerminalNode OUTER(int i) {
			return getToken(SQLCommonParser.OUTER, i);
		}
		public TerminalNode LEFT(int i) {
			return getToken(SQLCommonParser.LEFT, i);
		}
		public Sql_idContext sql_id(int i) {
			return getRuleContext(Sql_idContext.class,i);
		}
		public Join_conditionContext join_condition(int i) {
			return getRuleContext(Join_conditionContext.class,i);
		}
		public List<Sql_idContext> sql_id() {
			return getRuleContexts(Sql_idContext.class);
		}
		public List<TerminalNode> LEFT() { return getTokens(SQLCommonParser.LEFT); }
		public Sub_queryContext sub_query() {
			return getRuleContext(Sub_queryContext.class,0);
		}
		public List<Table_atomContext> table_atom() {
			return getRuleContexts(Table_atomContext.class);
		}
		public List<TerminalNode> RIGHT() { return getTokens(SQLCommonParser.RIGHT); }
		public TerminalNode JOIN(int i) {
			return getToken(SQLCommonParser.JOIN, i);
		}
		public Table_atomContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Table_atomContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_table_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterTable_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitTable_atom(this);
		}
	}

	public final Table_atomContext table_atom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Table_atomContext _localctx = new Table_atomContext(_ctx, _parentState, _p);
		Table_atomContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, RULE_table_atom);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(405); sql_id();
				setState(407);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(406); sql_id();
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(409); sql_id();
				setState(412);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(410); match(AS);
					setState(411); sql_id();
					}
					break;
				}
				}
				break;

			case 3:
				{
				setState(414); sub_query();
				setState(416);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(415); sql_id();
					}
					break;
				}
				}
				break;

			case 4:
				{
				setState(418); sub_query();
				setState(421);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(419); match(AS);
					setState(420); sql_id();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Table_atomContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_table_atom);
					setState(425);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(434); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(426);
							_la = _input.LA(1);
							if ( !(_la==LEFT || _la==RIGHT) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(428);
							_la = _input.LA(1);
							if (_la==OUTER) {
								{
								setState(427); match(OUTER);
								}
							}

							setState(430); match(JOIN);
							setState(431); table_atom(0);
							setState(432); join_condition();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(436); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					} while ( _alt!=2 && _alt!=-1 );
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Join_conditionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLCommonParser.ON, 0); }
		public CriteriaContext criteria() {
			return getRuleContext(CriteriaContext.class,0);
		}
		public Join_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterJoin_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitJoin_condition(this);
		}
	}

	public final Join_conditionContext join_condition() throws RecognitionException {
		Join_conditionContext _localctx = new Join_conditionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443); match(ON);
			setState(444); criteria(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sub_queryContext extends ParserRuleContext {
		public Select_clauseContext select_clause() {
			return getRuleContext(Select_clauseContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public Sub_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSub_query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSub_query(this);
		}
	}

	public final Sub_queryContext sub_query() throws RecognitionException {
		Sub_queryContext _localctx = new Sub_queryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_sub_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446); match(LPAREN);
			setState(447); select_clause();
			setState(448); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode BIT() { return getToken(SQLCommonParser.BIT, 0); }
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public TerminalNode BOOLEAN() { return getToken(SQLCommonParser.BOOLEAN, 0); }
		public TerminalNode FLOAT() { return getToken(SQLCommonParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(SQLCommonParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(SQLCommonParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLCommonParser.PLUS, 0); }
		public TerminalNode NULL() { return getToken(SQLCommonParser.NULL, 0); }
		public TerminalNode HEX() { return getToken(SQLCommonParser.HEX, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitLiteral_value(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_literal_value);
		int _la;
		try {
			setState(459);
			switch (_input.LA(1)) {
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(450); char_literal();
				}
				break;
			case PLUS:
			case MINUS:
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(451);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(454);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case HEX:
				enterOuterAlt(_localctx, 3);
				{
				setState(455); match(HEX);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(456); match(BOOLEAN);
				}
				break;
			case BIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(457); match(BIT);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(458); match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SQLCommonParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(SQLCommonParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(SQLCommonParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLCommonParser.PLUS, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(461);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(464);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR_LITERAL() { return getToken(SQLCommonParser.CHAR_LITERAL, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitChar_literal(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); match(CHAR_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_idContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(SQLCommonParser.ASTERISK, 0); }
		public List<TerminalNode> DOT() { return getTokens(SQLCommonParser.DOT); }
		public List<TerminalNode> ID() { return getTokens(SQLCommonParser.ID); }
		public TerminalNode DOT(int i) {
			return getToken(SQLCommonParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(SQLCommonParser.ID, i);
		}
		public Sql_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterSql_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitSql_id(this);
		}
	}

	public final Sql_idContext sql_id() throws RecognitionException {
		Sql_idContext _localctx = new Sql_idContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_sql_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(470);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(468); match(ID);
					setState(469); match(DOT);
					}
					break;
				}
				setState(472); match(ID);
				setState(473); match(DOT);
				}
				break;
			}
			setState(476);
			_la = _input.LA(1);
			if ( !(_la==ASTERISK || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20: return criteria_sempred((CriteriaContext)_localctx, predIndex);

		case 24: return expression_sempred((ExpressionContext)_localctx, predIndex);

		case 29: return table_atom_sempred((Table_atomContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 8 >= _localctx._p;

		case 2: return 7 >= _localctx._p;
		}
		return true;
	}
	private boolean table_atom_sempred(Table_atomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 1 >= _localctx._p;
		}
		return true;
	}
	private boolean criteria_sempred(CriteriaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3o\u01e1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\5\2O\n\2\3\3\3\3\3\3\5\3"+
		"T\n\3\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\4\3\4\3\4\3\4\5\4`\n\4\3\5\3\5\5\5"+
		"d\n\5\3\5\3\5\3\5\3\5\5\5j\n\5\3\5\5\5m\n\5\3\5\5\5p\n\5\3\5\5\5s\n\5"+
		"\3\5\5\5v\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\u0098\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u009f\n\7\3\b\3\b\3\b\3\b\5\b"+
		"\u00a5\n\b\3\t\3\t\3\t\7\t\u00aa\n\t\f\t\16\t\u00ad\13\t\3\n\3\n\3\n\7"+
		"\n\u00b2\n\n\f\n\16\n\u00b5\13\n\3\13\3\13\3\13\7\13\u00ba\n\13\f\13\16"+
		"\13\u00bd\13\13\3\f\3\f\3\f\7\f\u00c2\n\f\f\f\16\f\u00c5\13\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00d5"+
		"\n\20\f\20\16\20\u00d8\13\20\3\21\3\21\5\21\u00dc\n\21\3\22\3\22\3\22"+
		"\3\22\7\22\u00e2\n\22\f\22\16\22\u00e5\13\22\3\23\3\23\5\23\u00e9\n\23"+
		"\3\23\5\23\u00ec\n\23\3\24\3\24\3\24\5\24\u00f1\n\24\3\24\3\24\3\25\3"+
		"\25\3\25\5\25\u00f8\n\25\3\25\3\25\3\25\5\25\u00fd\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0106\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0116\n\26\3\26\3\26\3\26\6\26"+
		"\u011b\n\26\r\26\16\26\u011c\7\26\u011f\n\26\f\26\16\26\u0122\13\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0131"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0143\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u014f\n\32\f\32\16\32\u0152\13\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u015d\n\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0165\n\32\f\32\16\32\u0168\13\32\3\33\3\33\5\33\u016c\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\6\34\u0174\n\34\r\34\16\34\u0175\3\34\3\34\5"+
		"\34\u017a\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\6\35\u0185"+
		"\n\35\r\35\16\35\u0186\3\35\3\35\5\35\u018b\n\35\3\35\3\35\3\36\3\36\3"+
		"\36\7\36\u0192\n\36\f\36\16\36\u0195\13\36\3\37\3\37\3\37\5\37\u019a\n"+
		"\37\3\37\3\37\3\37\5\37\u019f\n\37\3\37\3\37\5\37\u01a3\n\37\3\37\3\37"+
		"\3\37\5\37\u01a8\n\37\5\37\u01aa\n\37\3\37\3\37\3\37\5\37\u01af\n\37\3"+
		"\37\3\37\3\37\3\37\6\37\u01b5\n\37\r\37\16\37\u01b6\7\37\u01b9\n\37\f"+
		"\37\16\37\u01bc\13\37\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\5\"\u01c7\n\"\3\"\3"+
		"\"\3\"\3\"\3\"\5\"\u01ce\n\"\3#\5#\u01d1\n#\3#\3#\3$\3$\3%\3%\5%\u01d9"+
		"\n%\3%\3%\5%\u01dd\n%\3%\3%\3%\2&\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\13\3\2\62\63\3\2AB\3\2af\3\2HI\4\2"+
		"SS``\4\2RRTT\3\2DE\3\2hi\4\2``gg\u020a\2N\3\2\2\2\4P\3\2\2\2\6_\3\2\2"+
		"\2\ba\3\2\2\2\n\u0097\3\2\2\2\f\u0099\3\2\2\2\16\u00a0\3\2\2\2\20\u00a6"+
		"\3\2\2\2\22\u00ae\3\2\2\2\24\u00b6\3\2\2\2\26\u00be\3\2\2\2\30\u00c6\3"+
		"\2\2\2\32\u00ca\3\2\2\2\34\u00cd\3\2\2\2\36\u00d0\3\2\2\2 \u00db\3\2\2"+
		"\2\"\u00dd\3\2\2\2$\u00e8\3\2\2\2&\u00ed\3\2\2\2(\u0105\3\2\2\2*\u0115"+
		"\3\2\2\2,\u0123\3\2\2\2.\u0130\3\2\2\2\60\u0142\3\2\2\2\62\u015c\3\2\2"+
		"\2\64\u016b\3\2\2\2\66\u016d\3\2\2\28\u017d\3\2\2\2:\u018e\3\2\2\2<\u01a9"+
		"\3\2\2\2>\u01bd\3\2\2\2@\u01c0\3\2\2\2B\u01cd\3\2\2\2D\u01d0\3\2\2\2F"+
		"\u01d4\3\2\2\2H\u01dc\3\2\2\2JO\5\4\3\2KO\5\n\6\2LO\5\f\7\2MO\5\16\b\2"+
		"NJ\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\3\3\2\2\2PX\5\b\5\2QS\7\60\2"+
		"\2RT\7\62\2\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UW\5\b\5\2VQ\3\2\2\2WZ\3\2"+
		"\2\2XV\3\2\2\2XY\3\2\2\2Y\5\3\2\2\2ZX\3\2\2\2[`\5\62\32\2\\]\5\62\32\2"+
		"]^\7n\2\2^`\3\2\2\2_[\3\2\2\2_\\\3\2\2\2`\7\3\2\2\2ac\7)\2\2bd\t\2\2\2"+
		"cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\5\22\n\2fg\7/\2\2gi\5:\36\2hj\5\32\16"+
		"\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\5\36\20\2lk\3\2\2\2lm\3\2\2\2mo\3\2"+
		"\2\2np\5\34\17\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qs\5\"\22\2rq\3\2\2\2rs"+
		"\3\2\2\2su\3\2\2\2tv\5&\24\2ut\3\2\2\2uv\3\2\2\2v\t\3\2\2\2wx\7*\2\2x"+
		"y\7-\2\2yz\5H%\2z{\5@!\2{\u0098\3\2\2\2|}\7*\2\2}~\7-\2\2~\177\5H%\2\177"+
		"\u0080\7N\2\2\u0080\u0081\7^\2\2\u0081\u0082\5\20\t\2\u0082\u0083\7_\2"+
		"\2\u0083\u0098\3\2\2\2\u0084\u0085\7*\2\2\u0085\u0086\7-\2\2\u0086\u0087"+
		"\5H%\2\u0087\u0088\7^\2\2\u0088\u0089\5\24\13\2\u0089\u008a\7_\2\2\u008a"+
		"\u008b\5@!\2\u008b\u0098\3\2\2\2\u008c\u008d\7*\2\2\u008d\u008e\7-\2\2"+
		"\u008e\u008f\5H%\2\u008f\u0090\7^\2\2\u0090\u0091\5\24\13\2\u0091\u0092"+
		"\7_\2\2\u0092\u0093\7N\2\2\u0093\u0094\7^\2\2\u0094\u0095\5\20\t\2\u0095"+
		"\u0096\7_\2\2\u0096\u0098\3\2\2\2\u0097w\3\2\2\2\u0097|\3\2\2\2\u0097"+
		"\u0084\3\2\2\2\u0097\u008c\3\2\2\2\u0098\13\3\2\2\2\u0099\u009a\7+\2\2"+
		"\u009a\u009b\5H%\2\u009b\u009c\7.\2\2\u009c\u009e\5\26\f\2\u009d\u009f"+
		"\5\32\16\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\r\3\2\2\2\u00a0"+
		"\u00a1\7,\2\2\u00a1\u00a2\7/\2\2\u00a2\u00a4\5H%\2\u00a3\u00a5\5\32\16"+
		"\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\17\3\2\2\2\u00a6\u00ab"+
		"\5\62\32\2\u00a7\u00a8\7V\2\2\u00a8\u00aa\5\62\32\2\u00a9\u00a7\3\2\2"+
		"\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\21"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b3\5(\25\2\u00af\u00b0\7V\2\2\u00b0"+
		"\u00b2\5(\25\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\23\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb"+
		"\5H%\2\u00b7\u00b8\7V\2\2\u00b8\u00ba\5H%\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\25\3\2\2"+
		"\2\u00bd\u00bb\3\2\2\2\u00be\u00c3\5\30\r\2\u00bf\u00c0\7V\2\2\u00c0\u00c2"+
		"\5\30\r\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\27\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7"+
		"\5H%\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\5\62\32\2\u00c9\31\3\2\2\2\u00ca"+
		"\u00cb\7\66\2\2\u00cb\u00cc\5*\26\2\u00cc\33\3\2\2\2\u00cd\u00ce\7\65"+
		"\2\2\u00ce\u00cf\5*\26\2\u00cf\35\3\2\2\2\u00d0\u00d1\7\64\2\2\u00d1\u00d6"+
		"\5 \21\2\u00d2\u00d3\7V\2\2\u00d3\u00d5\5 \21\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\37\3\2\2"+
		"\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\5H%\2\u00da\u00dc\7h\2\2\u00db\u00d9"+
		"\3\2\2\2\u00db\u00da\3\2\2\2\u00dc!\3\2\2\2\u00dd\u00de\78\2\2\u00de\u00e3"+
		"\5$\23\2\u00df\u00e0\7V\2\2\u00e0\u00e2\5$\23\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4#\3\2\2\2"+
		"\u00e5\u00e3\3\2\2\2\u00e6\u00e9\5H%\2\u00e7\u00e9\7h\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00ec\t\3\2\2\u00eb"+
		"\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec%\3\2\2\2\u00ed\u00f0\79\2\2\u00ee"+
		"\u00ef\7h\2\2\u00ef\u00f1\7V\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2"+
		"\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7h\2\2\u00f3\'\3\2\2\2\u00f4\u0106"+
		"\5\62\32\2\u00f5\u00f7\5\62\32\2\u00f6\u00f8\5H%\2\u00f7\u00f6\3\2\2\2"+
		"\u00f7\u00f8\3\2\2\2\u00f8\u0106\3\2\2\2\u00f9\u00fc\5\62\32\2\u00fa\u00fb"+
		"\7:\2\2\u00fb\u00fd\5H%\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0106\3\2\2\2\u00fe\u0106\5\64\33\2\u00ff\u0100\5H%\2\u0100\u0101\7O"+
		"\2\2\u0101\u0102\7`\2\2\u0102\u0106\3\2\2\2\u0103\u0106\7`\2\2\u0104\u0106"+
		"\5H%\2\u0105\u00f4\3\2\2\2\u0105\u00f5\3\2\2\2\u0105\u00f9\3\2\2\2\u0105"+
		"\u00fe\3\2\2\2\u0105\u00ff\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0104\3\2"+
		"\2\2\u0106)\3\2\2\2\u0107\u0108\b\26\1\2\u0108\u0109\7G\2\2\u0109\u0116"+
		"\5*\26\2\u010a\u010b\7^\2\2\u010b\u010c\5*\26\2\u010c\u010d\7_\2\2\u010d"+
		"\u0116\3\2\2\2\u010e\u010f\5\62\32\2\u010f\u0110\t\4\2\2\u0110\u0111\5"+
		"\62\32\2\u0111\u0116\3\2\2\2\u0112\u0116\5,\27\2\u0113\u0116\5\60\31\2"+
		"\u0114\u0116\5.\30\2\u0115\u0107\3\2\2\2\u0115\u010a\3\2\2\2\u0115\u010e"+
		"\3\2\2\2\u0115\u0112\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116"+
		"\u0120\3\2\2\2\u0117\u011a\6\26\2\3\u0118\u0119\t\5\2\2\u0119\u011b\5"+
		"*\26\2\u011a\u0118\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u0117\3\2\2\2\u011f\u0122\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121+\3\2\2\2\u0122\u0120"+
		"\3\2\2\2\u0123\u0124\5\62\32\2\u0124\u0125\7L\2\2\u0125\u0126\5\62\32"+
		"\2\u0126\u0127\7H\2\2\u0127\u0128\5\62\32\2\u0128-\3\2\2\2\u0129\u012a"+
		"\7K\2\2\u012a\u0131\5@!\2\u012b\u012c\7K\2\2\u012c\u012d\7^\2\2\u012d"+
		"\u012e\5@!\2\u012e\u012f\7_\2\2\u012f\u0131\3\2\2\2\u0130\u0129\3\2\2"+
		"\2\u0130\u012b\3\2\2\2\u0131/\3\2\2\2\u0132\u0133\5\62\32\2\u0133\u0134"+
		"\7J\2\2\u0134\u0135\7^\2\2\u0135\u0136\5\20\t\2\u0136\u0137\7_\2\2\u0137"+
		"\u0143\3\2\2\2\u0138\u0139\5\62\32\2\u0139\u013a\7J\2\2\u013a\u013b\5"+
		"@!\2\u013b\u0143\3\2\2\2\u013c\u013d\5\62\32\2\u013d\u013e\7J\2\2\u013e"+
		"\u013f\7^\2\2\u013f\u0140\5@!\2\u0140\u0141\7_\2\2\u0141\u0143\3\2\2\2"+
		"\u0142\u0132\3\2\2\2\u0142\u0138\3\2\2\2\u0142\u013c\3\2\2\2\u0143\61"+
		"\3\2\2\2\u0144\u0145\b\32\1\2\u0145\u0146\7^\2\2\u0146\u0147\5\62\32\2"+
		"\u0147\u0148\7_\2\2\u0148\u015d\3\2\2\2\u0149\u014a\5H%\2\u014a\u014b"+
		"\7^\2\2\u014b\u0150\5\62\32\2\u014c\u014d\7V\2\2\u014d\u014f\5\62\32\2"+
		"\u014e\u014c\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\7_\2\2\u0154"+
		"\u015d\3\2\2\2\u0155\u0156\5H%\2\u0156\u0157\7^\2\2\u0157\u0158\7_\2\2"+
		"\u0158\u015d\3\2\2\2\u0159\u015d\5F$\2\u015a\u015d\5D#\2\u015b\u015d\5"+
		"H%\2\u015c\u0144\3\2\2\2\u015c\u0149\3\2\2\2\u015c\u0155\3\2\2\2\u015c"+
		"\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d\u0166\3\2"+
		"\2\2\u015e\u015f\6\32\3\3\u015f\u0160\t\6\2\2\u0160\u0165\5\62\32\2\u0161"+
		"\u0162\6\32\4\3\u0162\u0163\t\7\2\2\u0163\u0165\5\62\32\2\u0164\u015e"+
		"\3\2\2\2\u0164\u0161\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\63\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016c\5\66\34"+
		"\2\u016a\u016c\58\35\2\u016b\u0169\3\2\2\2\u016b\u016a\3\2\2\2\u016c\65"+
		"\3\2\2\2\u016d\u0173\7;\2\2\u016e\u016f\7<\2\2\u016f\u0170\5\62\32\2\u0170"+
		"\u0171\7>\2\2\u0171\u0172\5\62\32\2\u0172\u0174\3\2\2\2\u0173\u016e\3"+
		"\2\2\2\u0174\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0179\3\2\2\2\u0177\u0178\7=\2\2\u0178\u017a\5\62\32\2\u0179\u0177\3"+
		"\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\7C\2\2\u017c"+
		"\67\3\2\2\2\u017d\u017e\7;\2\2\u017e\u0184\5\62\32\2\u017f\u0180\7<\2"+
		"\2\u0180\u0181\5\62\32\2\u0181\u0182\7>\2\2\u0182\u0183\5\62\32\2\u0183"+
		"\u0185\3\2\2\2\u0184\u017f\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0184\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0189\7=\2\2\u0189"+
		"\u018b\5\62\32\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3"+
		"\2\2\2\u018c\u018d\7C\2\2\u018d9\3\2\2\2\u018e\u0193\5<\37\2\u018f\u0190"+
		"\7V\2\2\u0190\u0192\5<\37\2\u0191\u018f\3\2\2\2\u0192\u0195\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194;\3\2\2\2\u0195\u0193\3\2\2\2"+
		"\u0196\u0197\b\37\1\2\u0197\u0199\5H%\2\u0198\u019a\5H%\2\u0199\u0198"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u01aa\3\2\2\2\u019b\u019e\5H%\2\u019c"+
		"\u019d\7:\2\2\u019d\u019f\5H%\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2"+
		"\2\u019f\u01aa\3\2\2\2\u01a0\u01a2\5@!\2\u01a1\u01a3\5H%\2\u01a2\u01a1"+
		"\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01aa\3\2\2\2\u01a4\u01a7\5@!\2\u01a5"+
		"\u01a6\7:\2\2\u01a6\u01a8\5H%\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2"+
		"\2\u01a8\u01aa\3\2\2\2\u01a9\u0196\3\2\2\2\u01a9\u019b\3\2\2\2\u01a9\u01a0"+
		"\3\2\2\2\u01a9\u01a4\3\2\2\2\u01aa\u01ba\3\2\2\2\u01ab\u01b4\6\37\5\3"+
		"\u01ac\u01ae\t\b\2\2\u01ad\u01af\7F\2\2\u01ae\u01ad\3\2\2\2\u01ae\u01af"+
		"\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7@\2\2\u01b1\u01b2\5<\37\2\u01b2"+
		"\u01b3\5> \2\u01b3\u01b5\3\2\2\2\u01b4\u01ac\3\2\2\2\u01b5\u01b6\3\2\2"+
		"\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01ab"+
		"\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"=\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01be\7\67\2\2\u01be\u01bf\5*\26\2"+
		"\u01bf?\3\2\2\2\u01c0\u01c1\7^\2\2\u01c1\u01c2\5\b\5\2\u01c2\u01c3\7_"+
		"\2\2\u01c3A\3\2\2\2\u01c4\u01ce\5F$\2\u01c5\u01c7\t\7\2\2\u01c6\u01c5"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ce\t\t\2\2\u01c9"+
		"\u01ce\7k\2\2\u01ca\u01ce\7m\2\2\u01cb\u01ce\7l\2\2\u01cc\u01ce\7M\2\2"+
		"\u01cd\u01c4\3\2\2\2\u01cd\u01c6\3\2\2\2\u01cd\u01c9\3\2\2\2\u01cd\u01ca"+
		"\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ceC\3\2\2\2\u01cf"+
		"\u01d1\t\7\2\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\3\2"+
		"\2\2\u01d2\u01d3\t\t\2\2\u01d3E\3\2\2\2\u01d4\u01d5\7j\2\2\u01d5G\3\2"+
		"\2\2\u01d6\u01d7\7g\2\2\u01d7\u01d9\7O\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9"+
		"\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\7g\2\2\u01db\u01dd\7O\2\2\u01dc"+
		"\u01d8\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\t\n"+
		"\2\2\u01dfI\3\2\2\28NSX_ciloru\u0097\u009e\u00a4\u00ab\u00b3\u00bb\u00c3"+
		"\u00d6\u00db\u00e3\u00e8\u00eb\u00f0\u00f7\u00fc\u0105\u0115\u011c\u0120"+
		"\u0130\u0142\u0150\u015c\u0164\u0166\u016b\u0175\u0179\u0186\u018a\u0193"+
		"\u0199\u019e\u01a2\u01a7\u01a9\u01ae\u01b6\u01ba\u01c6\u01cd\u01d0\u01d8"+
		"\u01dc";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}