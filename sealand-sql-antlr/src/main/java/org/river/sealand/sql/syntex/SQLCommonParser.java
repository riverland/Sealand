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
		E_=38, SELECT=39, INSERT=40, UPDATE=41, DELETE=42, INTO=43, SET=44, FROM=45, 
		UNION=46, ALL=47, DISTINCT=48, GROUP_BY=49, HAVING=50, WHERE=51, ON=52, 
		ORDER_BY=53, LIMIT=54, AS=55, CASE=56, WHEN=57, ELSE=58, THEN=59, INNER=60, 
		JOIN=61, ASC=62, DESC=63, END=64, LEFT=65, RIGHT=66, OUTER=67, NOT=68, 
		AND=69, OR=70, IN=71, EXIST=72, BETWEEN=73, NULL=74, VALUES=75, DOT=76, 
		VERTICAL_BAR=77, DOUBLE_VERTICAL_BAR=78, PLUS=79, DIV=80, MINUS=81, PERCENT=82, 
		COMMA=83, SEMI=84, COLON=85, RBRACK=86, LBRACK=87, NEGATION=88, BITAND=89, 
		POWER_OP=90, LPAREN=91, RPAREN=92, ASTERISK=93, GT=94, GE=95, EQ=96, LT=97, 
		LE=98, LIKE=99, ID=100, INT=101, FLOAT=102, CHAR_LITERAL=103, HEX=104, 
		BIT=105, BOOLEAN=106, NEWLINE=107, WS=108;
	public static final String[] tokenNames = {
		"<INVALID>", "ARMSCII8", "ASCII", "BIG5", "BINARY", "CP1250", "CP1251", 
		"CP1256", "CP1257", "CP850", "CP852", "CP866", "CP932", "DEC8", "EUCJPMS", 
		"EUCKR", "GB2312", "GBK", "GEOSTD8", "GREEK", "HEBREW", "HP8", "KEYBCS2", 
		"KOI8R", "KOI8U", "LATIN1", "LATIN2", "LATIN5", "LATIN7", "MACCE", "MACROMAN", 
		"SJIS", "SWE7", "TIS620", "UCS2", "UJIS", "UTF8", "CHARSET_NAME", "E_", 
		"SELECT", "INSERT", "UPDATE", "DELETE", "INTO", "SET", "FROM", "UNION", 
		"ALL", "DISTINCT", "GROUP_BY", "HAVING", "WHERE", "ON", "ORDER_BY", "LIMIT", 
		"AS", "CASE", "WHEN", "ELSE", "THEN", "INNER", "JOIN", "ASC", "DESC", 
		"END", "LEFT", "RIGHT", "OUTER", "NOT", "AND", "OR", "IN", "EXIST", "BETWEEN", 
		"NULL", "VALUES", "DOT", "'|'", "'||'", "'+'", "'/'", "'-'", "'%'", "','", 
		"';'", "':'", "']'", "'['", "'~'", "'&'", "'^'", "'('", "')'", "'*'", 
		"'>'", "'>='", "'='", "'<'", "'<='", "LIKE", "ID", "INT", "FLOAT", "CHAR_LITERAL", 
		"HEX", "BIT", "BOOLEAN", "NEWLINE", "WS"
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
		RULE_number = 33, RULE_number_literal = 34, RULE_sql_id = 35;
	public static final String[] ruleNames = {
		"statement", "select_stmt", "expr_stmt", "select_clause", "insert_clause", 
		"update_clause", "delete_clause", "values_list", "select_list", "column_list", 
		"set_list", "set_clause", "where_clause", "having_clause", "group_by_clause", 
		"group_by_item", "order_by_clause", "order_by_item", "limit_clause", "display_column", 
		"criteria", "between_expr", "exist_expr", "in_expr", "expression", "case_when_clause", 
		"case_when_clause_0", "case_when_clause_1", "table_refs", "table_atom", 
		"join_condition", "sub_query", "literal_value", "number", "number_literal", 
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
				setState(242); sql_id();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243); sql_id();
				setState(244); match(DOT);
				setState(245); match(ASTERISK);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247); match(ASTERISK);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248); expression(0);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(249); expression(0);
				setState(251);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(250); sql_id();
					}
				}

				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(253); expression(0);
				setState(256);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(254); match(AS);
					setState(255); sql_id();
					}
				}

				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(258); case_when_clause();
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
		public TerminalNode AND() { return getToken(SQLCommonParser.AND, 0); }
		public TerminalNode OR() { return getToken(SQLCommonParser.OR, 0); }
		public TerminalNode LE() { return getToken(SQLCommonParser.LE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(SQLCommonParser.NOT, 0); }
		public Exist_exprContext exist_expr() {
			return getRuleContext(Exist_exprContext.class,0);
		}
		public Between_exprContext between_expr() {
			return getRuleContext(Between_exprContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SQLCommonParser.LIKE, 0); }
		public TerminalNode GT() { return getToken(SQLCommonParser.GT, 0); }
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
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(262); match(NOT);
				setState(263); criteria(1);
				}
				break;

			case 2:
				{
				setState(264); expression(0);
				setState(265);
				_la = _input.LA(1);
				if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (AND - 69)) | (1L << (OR - 69)) | (1L << (GT - 69)) | (1L << (GE - 69)) | (1L << (EQ - 69)) | (1L << (LT - 69)) | (1L << (LE - 69)) | (1L << (LIKE - 69)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(266); expression(0);
				}
				break;

			case 3:
				{
				setState(268); between_expr();
				}
				break;

			case 4:
				{
				setState(269); in_expr();
				}
				break;

			case 5:
				{
				setState(270); exist_expr();
				}
				break;

			case 6:
				{
				setState(271); match(NOT);
				setState(272); expression(0);
				}
				break;

			case 7:
				{
				setState(273); match(LPAREN);
				setState(274); criteria(0);
				setState(275); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CriteriaContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_criteria);
					setState(279);
					if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
					setState(280);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(281); criteria(3);
					}
					} 
				}
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
			setState(287); expression(0);
			setState(288); match(BETWEEN);
			setState(289); expression(0);
			setState(290); match(AND);
			setState(291); expression(0);
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
			setState(300);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293); match(EXIST);
				setState(294); sub_query();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295); match(EXIST);
				setState(296); match(LPAREN);
				setState(297); sub_query();
				setState(298); match(RPAREN);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public Sub_queryContext sub_query() {
			return getRuleContext(Sub_queryContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
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
		int _la;
		try {
			setState(325);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302); expression(0);
				setState(303); match(IN);
				setState(304); match(LPAREN);
				setState(305); expression(0);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(306); match(COMMA);
					setState(307); expression(0);
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313); match(RPAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315); expression(0);
				setState(316); match(IN);
				setState(317); sub_query();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(319); expression(0);
				setState(320); match(IN);
				setState(321); match(LPAREN);
				setState(322); sub_query();
				setState(323); match(RPAREN);
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
		public TerminalNode ASTERISK() { return getToken(SQLCommonParser.ASTERISK, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(SQLCommonParser.DIV, 0); }
		public TerminalNode MINUS() { return getToken(SQLCommonParser.MINUS, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLCommonParser.COMMA); }
		public TerminalNode RPAREN() { return getToken(SQLCommonParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode PLUS() { return getToken(SQLCommonParser.PLUS, 0); }
		public TerminalNode LPAREN() { return getToken(SQLCommonParser.LPAREN, 0); }
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SQLCommonParser.COMMA, i);
		}
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
			setState(350);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(328); literal_value();
				}
				break;

			case 2:
				{
				setState(329); sql_id();
				}
				break;

			case 3:
				{
				setState(330); match(LPAREN);
				setState(331); expression(0);
				setState(332); match(RPAREN);
				}
				break;

			case 4:
				{
				setState(334); sql_id();
				setState(335); match(LPAREN);
				setState(336); expression(0);
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(337); match(COMMA);
					setState(338); expression(0);
					}
					}
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(344); match(RPAREN);
				}
				break;

			case 5:
				{
				setState(346); sql_id();
				setState(347); match(LPAREN);
				setState(348); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(360);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(358);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(352);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(353);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==ASTERISK) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(354); expression(8);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(355);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(356);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(357); expression(7);
						}
						break;
					}
					} 
				}
				setState(362);
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
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(363); case_when_clause_0();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364); case_when_clause_1();
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
			setState(367); match(CASE);
			setState(373); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(368); match(WHEN);
				setState(369); expression(0);
				setState(370); match(THEN);
				setState(371); expression(0);
				}
				}
				setState(375); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(379);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(377); match(ELSE);
				setState(378); expression(0);
				}
			}

			setState(381); match(END);
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
			setState(383); match(CASE);
			setState(384); expression(0);
			setState(390); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(385); match(WHEN);
				setState(386); expression(0);
				setState(387); match(THEN);
				setState(388); expression(0);
				}
				}
				setState(392); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(396);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(394); match(ELSE);
				setState(395); expression(0);
				}
			}

			setState(398); match(END);
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
			setState(400); table_atom(0);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(401); match(COMMA);
				setState(402); table_atom(0);
				}
				}
				setState(407);
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
		public TerminalNode ID() { return getToken(SQLCommonParser.ID, 0); }
		public Join_conditionContext join_condition(int i) {
			return getRuleContext(Join_conditionContext.class,i);
		}
		public Sql_idContext sql_id() {
			return getRuleContext(Sql_idContext.class,0);
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
			setState(427);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(409); sql_id();
				setState(411);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(410); match(ID);
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(413); sql_id();
				setState(416);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(414); match(AS);
					setState(415); match(ID);
					}
					break;
				}
				}
				break;

			case 3:
				{
				setState(418); sub_query();
				setState(420);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(419); match(ID);
					}
					break;
				}
				}
				break;

			case 4:
				{
				setState(422); sub_query();
				setState(425);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(423); match(AS);
					setState(424); match(ID);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(444);
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
					setState(429);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(438); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(430);
							_la = _input.LA(1);
							if ( !(_la==LEFT || _la==RIGHT) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(432);
							_la = _input.LA(1);
							if (_la==OUTER) {
								{
								setState(431); match(OUTER);
								}
							}

							setState(434); match(JOIN);
							setState(435); table_atom(0);
							setState(436); join_condition();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(440); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
					} while ( _alt!=2 && _alt!=-1 );
					}
					} 
				}
				setState(446);
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
			setState(447); match(ON);
			setState(448); criteria(0);
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
			setState(450); match(LPAREN);
			setState(451); select_clause();
			setState(452); match(RPAREN);
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
		public TerminalNode BOOLEAN() { return getToken(SQLCommonParser.BOOLEAN, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(SQLCommonParser.CHAR_LITERAL, 0); }
		public TerminalNode NULL() { return getToken(SQLCommonParser.NULL, 0); }
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
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
		try {
			setState(460);
			switch (_input.LA(1)) {
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(454); match(CHAR_LITERAL);
				}
				break;
			case DOT:
			case PLUS:
			case MINUS:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(455); number_literal();
				}
				break;
			case HEX:
				enterOuterAlt(_localctx, 3);
				{
				setState(456); match(HEX);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(457); match(BOOLEAN);
				}
				break;
			case BIT:
				enterOuterAlt(_localctx, 5);
				{
				setState(458); match(BIT);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(459); match(NULL);
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
		public TerminalNode E_() { return getToken(SQLCommonParser.E_, 0); }
		public TerminalNode DOT() { return getToken(SQLCommonParser.DOT, 0); }
		public List<TerminalNode> INT() { return getTokens(SQLCommonParser.INT); }
		public TerminalNode MINUS() { return getToken(SQLCommonParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLCommonParser.PLUS, 0); }
		public TerminalNode INT(int i) {
			return getToken(SQLCommonParser.INT, i);
		}
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
			setState(470);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(462); match(INT);
				setState(463); match(DOT);
				setState(464); match(INT);
				}
				break;

			case 2:
				{
				setState(465); match(INT);
				setState(466); match(DOT);
				}
				break;

			case 3:
				{
				setState(467); match(DOT);
				setState(468); match(INT);
				}
				break;

			case 4:
				{
				setState(469); match(INT);
				}
				break;
			}
			setState(477);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(472); match(E_);
				setState(474);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(473);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(476); match(INT);
				}
				break;
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

	public static class Number_literalContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode INT() { return getToken(SQLCommonParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(SQLCommonParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLCommonParser.PLUS, 0); }
		public Number_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).enterNumber_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLCommonListener ) ((SQLCommonListener)listener).exitNumber_literal(this);
		}
	}

	public final Number_literalContext number_literal() throws RecognitionException {
		Number_literalContext _localctx = new Number_literalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_number_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(479);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(484);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(482); match(INT);
				}
				break;

			case 2:
				{
				setState(483); number();
				}
				break;
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

	public static class Sql_idContext extends ParserRuleContext {
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(488);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(486); match(ID);
					setState(487); match(DOT);
					}
					break;
				}
				setState(490); match(ID);
				setState(491); match(DOT);
				}
				break;
			}
			setState(494); match(ID);
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
		case 1: return 7 >= _localctx._p;

		case 2: return 6 >= _localctx._p;
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
		case 0: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3n\u01f3\4\2\t\2\4"+
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
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fe\n\25\3\25\3\25\3\25"+
		"\5\25\u0103\n\25\3\25\5\25\u0106\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0118\n\26\3\26"+
		"\3\26\3\26\7\26\u011d\n\26\f\26\16\26\u0120\13\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u012f\n\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u0137\n\31\f\31\16\31\u013a\13\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0148\n\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0156\n\32"+
		"\f\32\16\32\u0159\13\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0161\n\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0169\n\32\f\32\16\32\u016c\13\32"+
		"\3\33\3\33\5\33\u0170\n\33\3\34\3\34\3\34\3\34\3\34\3\34\6\34\u0178\n"+
		"\34\r\34\16\34\u0179\3\34\3\34\5\34\u017e\n\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\6\35\u0189\n\35\r\35\16\35\u018a\3\35\3\35\5\35\u018f"+
		"\n\35\3\35\3\35\3\36\3\36\3\36\7\36\u0196\n\36\f\36\16\36\u0199\13\36"+
		"\3\37\3\37\3\37\5\37\u019e\n\37\3\37\3\37\3\37\5\37\u01a3\n\37\3\37\3"+
		"\37\5\37\u01a7\n\37\3\37\3\37\3\37\5\37\u01ac\n\37\5\37\u01ae\n\37\3\37"+
		"\3\37\3\37\5\37\u01b3\n\37\3\37\3\37\3\37\3\37\6\37\u01b9\n\37\r\37\16"+
		"\37\u01ba\7\37\u01bd\n\37\f\37\16\37\u01c0\13\37\3 \3 \3 \3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01cf\n\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01d9"+
		"\n#\3#\3#\5#\u01dd\n#\3#\5#\u01e0\n#\3$\5$\u01e3\n$\3$\3$\5$\u01e7\n$"+
		"\3%\3%\5%\u01eb\n%\3%\3%\5%\u01ef\n%\3%\3%\3%\2&\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\t\3\2\61\62\3\2@A\4"+
		"\2GH`e\3\2GH\4\2RR__\4\2QQSS\3\2CD\u0221\2N\3\2\2\2\4P\3\2\2\2\6_\3\2"+
		"\2\2\ba\3\2\2\2\n\u0097\3\2\2\2\f\u0099\3\2\2\2\16\u00a0\3\2\2\2\20\u00a6"+
		"\3\2\2\2\22\u00ae\3\2\2\2\24\u00b6\3\2\2\2\26\u00be\3\2\2\2\30\u00c6\3"+
		"\2\2\2\32\u00ca\3\2\2\2\34\u00cd\3\2\2\2\36\u00d0\3\2\2\2 \u00db\3\2\2"+
		"\2\"\u00dd\3\2\2\2$\u00e8\3\2\2\2&\u00ed\3\2\2\2(\u0105\3\2\2\2*\u0117"+
		"\3\2\2\2,\u0121\3\2\2\2.\u012e\3\2\2\2\60\u0147\3\2\2\2\62\u0160\3\2\2"+
		"\2\64\u016f\3\2\2\2\66\u0171\3\2\2\28\u0181\3\2\2\2:\u0192\3\2\2\2<\u01ad"+
		"\3\2\2\2>\u01c1\3\2\2\2@\u01c4\3\2\2\2B\u01ce\3\2\2\2D\u01d8\3\2\2\2F"+
		"\u01e2\3\2\2\2H\u01ee\3\2\2\2JO\5\4\3\2KO\5\n\6\2LO\5\f\7\2MO\5\16\b\2"+
		"NJ\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O\3\3\2\2\2PX\5\b\5\2QS\7\60\2"+
		"\2RT\7\61\2\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UW\5\b\5\2VQ\3\2\2\2WZ\3\2"+
		"\2\2XV\3\2\2\2XY\3\2\2\2Y\5\3\2\2\2ZX\3\2\2\2[`\5\62\32\2\\]\5\62\32\2"+
		"]^\7m\2\2^`\3\2\2\2_[\3\2\2\2_\\\3\2\2\2`\7\3\2\2\2ac\7)\2\2bd\t\2\2\2"+
		"cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\5\22\n\2fg\7/\2\2gi\5:\36\2hj\5\32\16"+
		"\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\5\36\20\2lk\3\2\2\2lm\3\2\2\2mo\3\2"+
		"\2\2np\5\34\17\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qs\5\"\22\2rq\3\2\2\2rs"+
		"\3\2\2\2su\3\2\2\2tv\5&\24\2ut\3\2\2\2uv\3\2\2\2v\t\3\2\2\2wx\7*\2\2x"+
		"y\7-\2\2yz\5H%\2z{\5@!\2{\u0098\3\2\2\2|}\7*\2\2}~\7-\2\2~\177\5H%\2\177"+
		"\u0080\7M\2\2\u0080\u0081\7]\2\2\u0081\u0082\5\20\t\2\u0082\u0083\7^\2"+
		"\2\u0083\u0098\3\2\2\2\u0084\u0085\7*\2\2\u0085\u0086\7-\2\2\u0086\u0087"+
		"\5H%\2\u0087\u0088\7]\2\2\u0088\u0089\5\24\13\2\u0089\u008a\7^\2\2\u008a"+
		"\u008b\5@!\2\u008b\u0098\3\2\2\2\u008c\u008d\7*\2\2\u008d\u008e\7-\2\2"+
		"\u008e\u008f\5H%\2\u008f\u0090\7]\2\2\u0090\u0091\5\24\13\2\u0091\u0092"+
		"\7^\2\2\u0092\u0093\7M\2\2\u0093\u0094\7]\2\2\u0094\u0095\5\20\t\2\u0095"+
		"\u0096\7^\2\2\u0096\u0098\3\2\2\2\u0097w\3\2\2\2\u0097|\3\2\2\2\u0097"+
		"\u0084\3\2\2\2\u0097\u008c\3\2\2\2\u0098\13\3\2\2\2\u0099\u009a\7+\2\2"+
		"\u009a\u009b\5H%\2\u009b\u009c\7.\2\2\u009c\u009e\5\26\f\2\u009d\u009f"+
		"\5\32\16\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\r\3\2\2\2\u00a0"+
		"\u00a1\7,\2\2\u00a1\u00a2\7/\2\2\u00a2\u00a4\5H%\2\u00a3\u00a5\5\32\16"+
		"\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\17\3\2\2\2\u00a6\u00ab"+
		"\5\62\32\2\u00a7\u00a8\7U\2\2\u00a8\u00aa\5\62\32\2\u00a9\u00a7\3\2\2"+
		"\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\21"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b3\5(\25\2\u00af\u00b0\7U\2\2\u00b0"+
		"\u00b2\5(\25\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\23\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb"+
		"\5H%\2\u00b7\u00b8\7U\2\2\u00b8\u00ba\5H%\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\25\3\2\2"+
		"\2\u00bd\u00bb\3\2\2\2\u00be\u00c3\5\30\r\2\u00bf\u00c0\7U\2\2\u00c0\u00c2"+
		"\5\30\r\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2"+
		"\u00c3\u00c4\3\2\2\2\u00c4\27\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7"+
		"\5H%\2\u00c7\u00c8\7b\2\2\u00c8\u00c9\5\62\32\2\u00c9\31\3\2\2\2\u00ca"+
		"\u00cb\7\65\2\2\u00cb\u00cc\5*\26\2\u00cc\33\3\2\2\2\u00cd\u00ce\7\64"+
		"\2\2\u00ce\u00cf\5*\26\2\u00cf\35\3\2\2\2\u00d0\u00d1\7\63\2\2\u00d1\u00d6"+
		"\5 \21\2\u00d2\u00d3\7U\2\2\u00d3\u00d5\5 \21\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\37\3\2\2"+
		"\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\5H%\2\u00da\u00dc\7g\2\2\u00db\u00d9"+
		"\3\2\2\2\u00db\u00da\3\2\2\2\u00dc!\3\2\2\2\u00dd\u00de\7\67\2\2\u00de"+
		"\u00e3\5$\23\2\u00df\u00e0\7U\2\2\u00e0\u00e2\5$\23\2\u00e1\u00df\3\2"+
		"\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"#\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\5H%\2\u00e7\u00e9\7g\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00ec\t\3"+
		"\2\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec%\3\2\2\2\u00ed\u00f0"+
		"\78\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f1\7U\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\7g\2\2\u00f3\'\3\2\2\2"+
		"\u00f4\u0106\5H%\2\u00f5\u00f6\5H%\2\u00f6\u00f7\7N\2\2\u00f7\u00f8\7"+
		"_\2\2\u00f8\u0106\3\2\2\2\u00f9\u0106\7_\2\2\u00fa\u0106\5\62\32\2\u00fb"+
		"\u00fd\5\62\32\2\u00fc\u00fe\5H%\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u0106\3\2\2\2\u00ff\u0102\5\62\32\2\u0100\u0101\79\2\2\u0101"+
		"\u0103\5H%\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0106\3\2\2"+
		"\2\u0104\u0106\5\64\33\2\u0105\u00f4\3\2\2\2\u0105\u00f5\3\2\2\2\u0105"+
		"\u00f9\3\2\2\2\u0105\u00fa\3\2\2\2\u0105\u00fb\3\2\2\2\u0105\u00ff\3\2"+
		"\2\2\u0105\u0104\3\2\2\2\u0106)\3\2\2\2\u0107\u0108\b\26\1\2\u0108\u0109"+
		"\7F\2\2\u0109\u0118\5*\26\2\u010a\u010b\5\62\32\2\u010b\u010c\t\4\2\2"+
		"\u010c\u010d\5\62\32\2\u010d\u0118\3\2\2\2\u010e\u0118\5,\27\2\u010f\u0118"+
		"\5\60\31\2\u0110\u0118\5.\30\2\u0111\u0112\7F\2\2\u0112\u0118\5\62\32"+
		"\2\u0113\u0114\7]\2\2\u0114\u0115\5*\26\2\u0115\u0116\7^\2\2\u0116\u0118"+
		"\3\2\2\2\u0117\u0107\3\2\2\2\u0117\u010a\3\2\2\2\u0117\u010e\3\2\2\2\u0117"+
		"\u010f\3\2\2\2\u0117\u0110\3\2\2\2\u0117\u0111\3\2\2\2\u0117\u0113\3\2"+
		"\2\2\u0118\u011e\3\2\2\2\u0119\u011a\6\26\2\3\u011a\u011b\t\5\2\2\u011b"+
		"\u011d\5*\26\2\u011c\u0119\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f+\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122"+
		"\5\62\32\2\u0122\u0123\7K\2\2\u0123\u0124\5\62\32\2\u0124\u0125\7G\2\2"+
		"\u0125\u0126\5\62\32\2\u0126-\3\2\2\2\u0127\u0128\7J\2\2\u0128\u012f\5"+
		"@!\2\u0129\u012a\7J\2\2\u012a\u012b\7]\2\2\u012b\u012c\5@!\2\u012c\u012d"+
		"\7^\2\2\u012d\u012f\3\2\2\2\u012e\u0127\3\2\2\2\u012e\u0129\3\2\2\2\u012f"+
		"/\3\2\2\2\u0130\u0131\5\62\32\2\u0131\u0132\7I\2\2\u0132\u0133\7]\2\2"+
		"\u0133\u0138\5\62\32\2\u0134\u0135\7U\2\2\u0135\u0137\5\62\32\2\u0136"+
		"\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7^\2\2\u013c"+
		"\u0148\3\2\2\2\u013d\u013e\5\62\32\2\u013e\u013f\7I\2\2\u013f\u0140\5"+
		"@!\2\u0140\u0148\3\2\2\2\u0141\u0142\5\62\32\2\u0142\u0143\7I\2\2\u0143"+
		"\u0144\7]\2\2\u0144\u0145\5@!\2\u0145\u0146\7^\2\2\u0146\u0148\3\2\2\2"+
		"\u0147\u0130\3\2\2\2\u0147\u013d\3\2\2\2\u0147\u0141\3\2\2\2\u0148\61"+
		"\3\2\2\2\u0149\u014a\b\32\1\2\u014a\u0161\5B\"\2\u014b\u0161\5H%\2\u014c"+
		"\u014d\7]\2\2\u014d\u014e\5\62\32\2\u014e\u014f\7^\2\2\u014f\u0161\3\2"+
		"\2\2\u0150\u0151\5H%\2\u0151\u0152\7]\2\2\u0152\u0157\5\62\32\2\u0153"+
		"\u0154\7U\2\2\u0154\u0156\5\62\32\2\u0155\u0153\3\2\2\2\u0156\u0159\3"+
		"\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015b\7^\2\2\u015b\u0161\3\2\2\2\u015c\u015d\5H%"+
		"\2\u015d\u015e\7]\2\2\u015e\u015f\7^\2\2\u015f\u0161\3\2\2\2\u0160\u0149"+
		"\3\2\2\2\u0160\u014b\3\2\2\2\u0160\u014c\3\2\2\2\u0160\u0150\3\2\2\2\u0160"+
		"\u015c\3\2\2\2\u0161\u016a\3\2\2\2\u0162\u0163\6\32\3\3\u0163\u0164\t"+
		"\6\2\2\u0164\u0169\5\62\32\2\u0165\u0166\6\32\4\3\u0166\u0167\t\7\2\2"+
		"\u0167\u0169\5\62\32\2\u0168\u0162\3\2\2\2\u0168\u0165\3\2\2\2\u0169\u016c"+
		"\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\63\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016d\u0170\5\66\34\2\u016e\u0170\58\35\2\u016f\u016d\3"+
		"\2\2\2\u016f\u016e\3\2\2\2\u0170\65\3\2\2\2\u0171\u0177\7:\2\2\u0172\u0173"+
		"\7;\2\2\u0173\u0174\5\62\32\2\u0174\u0175\7=\2\2\u0175\u0176\5\62\32\2"+
		"\u0176\u0178\3\2\2\2\u0177\u0172\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u0177"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u017c\7<\2\2\u017c"+
		"\u017e\5\62\32\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3"+
		"\2\2\2\u017f\u0180\7B\2\2\u0180\67\3\2\2\2\u0181\u0182\7:\2\2\u0182\u0188"+
		"\5\62\32\2\u0183\u0184\7;\2\2\u0184\u0185\5\62\32\2\u0185\u0186\7=\2\2"+
		"\u0186\u0187\5\62\32\2\u0187\u0189\3\2\2\2\u0188\u0183\3\2\2\2\u0189\u018a"+
		"\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018e\3\2\2\2\u018c"+
		"\u018d\7<\2\2\u018d\u018f\5\62\32\2\u018e\u018c\3\2\2\2\u018e\u018f\3"+
		"\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7B\2\2\u01919\3\2\2\2\u0192\u0197"+
		"\5<\37\2\u0193\u0194\7U\2\2\u0194\u0196\5<\37\2\u0195\u0193\3\2\2\2\u0196"+
		"\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198;\3\2\2\2"+
		"\u0199\u0197\3\2\2\2\u019a\u019b\b\37\1\2\u019b\u019d\5H%\2\u019c\u019e"+
		"\7f\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01ae\3\2\2\2\u019f"+
		"\u01a2\5H%\2\u01a0\u01a1\79\2\2\u01a1\u01a3\7f\2\2\u01a2\u01a0\3\2\2\2"+
		"\u01a2\u01a3\3\2\2\2\u01a3\u01ae\3\2\2\2\u01a4\u01a6\5@!\2\u01a5\u01a7"+
		"\7f\2\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01ae\3\2\2\2\u01a8"+
		"\u01ab\5@!\2\u01a9\u01aa\79\2\2\u01aa\u01ac\7f\2\2\u01ab\u01a9\3\2\2\2"+
		"\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad\u019a\3\2\2\2\u01ad\u019f"+
		"\3\2\2\2\u01ad\u01a4\3\2\2\2\u01ad\u01a8\3\2\2\2\u01ae\u01be\3\2\2\2\u01af"+
		"\u01b8\6\37\5\3\u01b0\u01b2\t\b\2\2\u01b1\u01b3\7E\2\2\u01b2\u01b1\3\2"+
		"\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\7?\2\2\u01b5"+
		"\u01b6\5<\37\2\u01b6\u01b7\5> \2\u01b7\u01b9\3\2\2\2\u01b8\u01b0\3\2\2"+
		"\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd"+
		"\3\2\2\2\u01bc\u01af\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf=\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\7\66\2\2"+
		"\u01c2\u01c3\5*\26\2\u01c3?\3\2\2\2\u01c4\u01c5\7]\2\2\u01c5\u01c6\5\b"+
		"\5\2\u01c6\u01c7\7^\2\2\u01c7A\3\2\2\2\u01c8\u01cf\7i\2\2\u01c9\u01cf"+
		"\5F$\2\u01ca\u01cf\7j\2\2\u01cb\u01cf\7l\2\2\u01cc\u01cf\7k\2\2\u01cd"+
		"\u01cf\7L\2\2\u01ce\u01c8\3\2\2\2\u01ce\u01c9\3\2\2\2\u01ce\u01ca\3\2"+
		"\2\2\u01ce\u01cb\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cf"+
		"C\3\2\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d2\7N\2\2\u01d2\u01d9\7g\2\2\u01d3"+
		"\u01d4\7g\2\2\u01d4\u01d9\7N\2\2\u01d5\u01d6\7N\2\2\u01d6\u01d9\7g\2\2"+
		"\u01d7\u01d9\7g\2\2\u01d8\u01d0\3\2\2\2\u01d8\u01d3\3\2\2\2\u01d8\u01d5"+
		"\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9\u01df\3\2\2\2\u01da\u01dc\7(\2\2\u01db"+
		"\u01dd\t\7\2\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01e0\7g\2\2\u01df\u01da\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"E\3\2\2\2\u01e1\u01e3\t\7\2\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2"+
		"\u01e3\u01e6\3\2\2\2\u01e4\u01e7\7g\2\2\u01e5\u01e7\5D#\2\u01e6\u01e4"+
		"\3\2\2\2\u01e6\u01e5\3\2\2\2\u01e7G\3\2\2\2\u01e8\u01e9\7f\2\2\u01e9\u01eb"+
		"\7N\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec"+
		"\u01ed\7f\2\2\u01ed\u01ef\7N\2\2\u01ee\u01ea\3\2\2\2\u01ee\u01ef\3\2\2"+
		"\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\7f\2\2\u01f1I\3\2\2\2;NSX_ciloru\u0097"+
		"\u009e\u00a4\u00ab\u00b3\u00bb\u00c3\u00d6\u00db\u00e3\u00e8\u00eb\u00f0"+
		"\u00fd\u0102\u0105\u0117\u011e\u012e\u0138\u0147\u0157\u0160\u0168\u016a"+
		"\u016f\u0179\u017d\u018a\u018e\u0197\u019d\u01a2\u01a6\u01ab\u01ad\u01b2"+
		"\u01ba\u01be\u01ce\u01d8\u01dc\u01df\u01e2\u01e6\u01ea\u01ee";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}