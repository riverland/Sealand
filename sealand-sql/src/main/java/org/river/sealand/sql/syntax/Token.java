//package org.river.sealand.sql.syntax;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <p>
// * SQL 关键词
// * @author river
// * @since  Nov 15, 2013
// */
//public enum Token {
//    SELECT("SELECT"), 
//    DELETE("DELETE"), 
//    INSERT("INSERT"), 
//    UPDATE("UPDATE"),     
//    FROM("FROM"), 
//    HAVING("HAVING"), 
//    WHERE("WHERE"), 
//    ORDER("ORDER"), 
//    BY("BY"),
//    GROUP("GROUP"), 
//    INTO("INTO"), 
//    AS("AS"),     
//    CREATE("CREATE"),
//    ALTER("ALTER"), 
//    DROP("DROP"), 
//    SET("SET"),    
//    NULL("NULL"), 
//    NOT("NOT"), 
//    DISTINCT("DISTINCT"),
//    TABLE("TABLE"), 
//    TABLESPACE("TABLESPACE"), 
//    VIEW("VIEW"), 
//    SEQUENCE("SEQUENCE"), 
//    TRIGGER("TRIGGER"), 
//    USER("USER"), 
//    INDEX("INDEX"), 
//    SESSION("SESSION"),
//    PROCEDURE("PROCEDURE"),
//    FUNCTION("FUNCTION"),    
//    PRIMARY("PRIMARY"), 
//    KEY("KEY"), 
//    DEFAULT("DEFAULT"), 
//    CONSTRAINT("CONSTRAINT"), 
//    CHECK("CHECK"), 
//    UNIQUE("UNIQUE"), 
//    FOREIGN("FOREIGN"), 
//    REFERENCES("REFERENCES"),     
//    EXPLAIN("EXPLAIN"), 
//    FOR("FOR"), 
//    IF("IF"),    
//    ALL("ALL"), 
//    UNION("UNION"), 
//    EXCEPT("EXCEPT"), 
//    INTERSECT("INTERSECT"), 
//    MINUS("MINUS"),
//    INNER("INNER"), 
//    LEFT("LEFT"), 
//    RIGHT("RIGHT"), 
//    FULL("FULL"), 
//    OUTER("OUTER"), 
//    JOIN("JOIN"), 
//    ON("ON"), 
//    SCHEMA("SCHEMA"), 
//    CAST("CAST"),
//    COLUMN("COLUMN"),
//    USE("USE"),
//    DATABASE("DATABASE"),
//    TO("TO"),
//    AND("AND"), 
//    OR("OR"), 
//    XOR("XOR"), 
//    CASE("CASE"), 
//    WHEN("WHEN"), 
//    THEN("THEN"), 
//    ELSE("ELSE"), 
//    END("END"), 
//    EXISTS("EXISTS"), 
//    IN("IN"),
//    NEW("NEW"), 
//    ASC("ASC"), 
//    DESC("DESC"), 
//    IS("IS"), 
//    LIKE("LIKE"), 
//    ESCAPE("ESCAPE"), 
//    BETWEEN("BETWEEN"), 
//    VALUES("VALUES"), 
//    INTERVAL("INTERVAL"),
//    LOCK("LOCK"), 
//    SOME("SOME"), 
//    ANY("ANY"),
//    TRUNCATE("TRUNCATE"),
//    
//    //符号
//    LPAREN("("), 
//    RPAREN(")"), 
//    LBRACE("{"), 
//    RBRACE("}"), 
//    LBRACKET("["), 
//    RBRACKET("]"), 
//    SEMI(";"), 
//    COMMA(","), 
//    DOT("."), 
//    DOTDOT(".."), 
//    DOTDOTDOT("..,"), 
//    EQ("="), 
//    GT(">"), 
//    LT("<"), 
//    BANG("!"),
//    TILDE("~"), 
//    QUES("?"), 
//    COLON(":"), 
//    COLONCOLON(":"), 
//    COLONEQ(":="), 
//    EQEQ("=="), 
//    LTEQ("<="), 
//    LTEQGT("<=>"), 
//    LTGT("<>"), 
//    GTEQ(">="), 
//    BANGEQ("!="), 
//    BANGGT("!>"), 
//    BANGLT("!<"),
//    AMPAMP("&&"), 
//    BARBAR("||"), 
//    PLUS("+"), 
//    SUB("-"), 
//    STAR("*"), 
//    SLASH("/"), 
//    AMP("&"), 
//    BAR("|"), 
//    CARET("^"), 
//    PERCENT("%"), 
//    LTLT("<<"), 
//    GTGT(">>"),
//    MONKEYS_AT("@"),
//    
//    // oracle
//    START("START"),
//    PRIOR("PRIOR"),
//    CONNECT("CONNECT"),
//    WITH("WITH"),
//    EXTRACT("EXTRACT"),
//    CURSOR("CURSOR"),
//    MODEL("MODEL"),
//    MERGE("MERGE"),
//    MATCHED("MATCHED"),
//    ERRORS("ERRORS"),
//    REJECT("REJECT"),
//    UNLIMITED("UNLIMITED"),
//    BEGIN("BEGIN"),
//    EXCLUSIVE("EXCLUSIVE"),
//    MODE("MODE"),
//    WAIT("WAIT"),
//    ADVISE("ADVISE"),
//    SYSDATE("SYSDATE"),
//    DECLARE("DECLARE"),
//    EXCEPTION("EXCEPTION"),
//    GRANT("GRANT"),
//    LOOP("LOOP"),
//    GOTO("GOTO"),
//    COMMIT("COMMIT"),
//    SAVEPOINT("SAVEPOINT"),
//    CROSS("CROSS"),    
//    PCTFREE("PCTFREE"),
//    INITRANS("INITRANS"),
//    MAXTRANS("MAXTRANS"),
//    INITIALLY("INITIALLY"),
//    ENABLE("ENABLE"),
//    DISABLE("DISABLE"),
//    SEGMENT("SEGMENT"),
//    CREATION("CREATION"),
//    IMMEDIATE("IMMEDIATE"),
//    DEFERRED("DEFERRED"),
//    STORAGE("STORAGE"),
//    MINEXTENTS("MINEXTENTS"),
//    MAXEXTENTS("MAXEXTENTS"),
//    MAXSIZE("MAXSIZE"),
//    PCTINCREASE("PCTINCREASE"),
//    FLASH_CACHE("FLASH_CACHE"),
//    CELL_FLASH_CACHE("CELL_FLASH_CACHE"),
//    KEEP("KEEP"),
//    NONE("NONE"),
//    LOB("LOB"),
//    STORE("STORE"),
//    CHUNK("CHUNK"),
//    CACHE("CACHE"),
//    NOCACHE("NOCACHE"),
//    LOGGING("LOGGING"),
//    NOCOMPRESS("NOCOMPRESS"),
//    KEEP_DUPLICATES("KEEP_DUPLICATES"),
//    EXCEPTIONS("EXCEPTIONS"),
//    PURGE("PURGE"),    
//    COMPUTE("COMPUTE"),
//    ANALYZE("ANALYZE"),
//    OPTIMIZE("OPTIMIZE"),
//    
//    // mysql
//    TRUE("TRUE"), 
//    FALSE("FALSE"),
//    LIMIT("LIMIT"),
//    KILL("KILL"),
//    IDENTIFIED("IDENTIFIED"),
//    PASSWORD("PASSWORD"),
//    DUAL("DUAL"),
//    BINARY("BINARY"),
//    SHOW("SHOW"),
//    REPLACE("REPLACE"),
//    
//    //postgresql
//    WINDOW("WINDOW"),
//    OFFSET("OFFSET"),
//    ROW("ROW"),
//    ROWS("ROWS"),
//    ONLY("ONLY"),
//    FIRST("FIRST"),
//    NEXT("NEXT"),
//    FETCH("FETCH"),
//    OF("OF"),
//    SHARE("SHARE"),
//    NOWAIT("NOWAIT"),
//    RECURSIVE("RECURSIVE"),
//    TEMPORARY("TEMPORARY"),
//    TEMP("TEMP"),
//    UNLOGGED("UNLOGGED"),
//    RESTART("RESTART"),
//    IDENTITY("IDENTITY"),
//    CONTINUE("CONTINUE"),
//    CASCADE("CASCADE"),
//    RESTRICT("RESTRICT"),
//    USING("USING"),
//    CURRENT("CURRENT"),
//    RETURNING("RETURNING"),
//    COMMENT("COMMENT"),
//    OVER("OVER"),
//    
//    // transact-sql
//    TOP("TOP"), 
//
//    //其他
//    EOF(""), 
//    ERROR(""),
//    IDENTIFIER(""),
//    HINT(""),
//    VARIANT(""),
//    LITERAL_INT(""),
//    LITERAL_FLOAT(""),
//    LITERAL_HEX(""),
//    LITERAL_CHARS(""),
//    LITERAL_NCHARS(""),    
//    LITERAL_ALIAS(""),
//    LINE_COMMENT(""),
//    MULTI_LINE_COMMENT("");
//    
//    protected String value;
//    private static Map<String,Token> keywords=new HashMap<String,Token>();
//    
//    public static Token getKeyword(String keyword) {
//    	if(keyword==null){
//    		return null;
//    	}
//    	keyword=keyword.trim().toUpperCase();
//		return keywords.get(keyword);
//	}
//
//
//	public String getValue(){
//    	return value;
//    }
//    
//
//	private Token(String value) {
//		this.value = value;
//	}
//	
//	static{
//        keywords.put("ALL", Token.ALL);
//        keywords.put("ALTER", Token.ALTER);
//        keywords.put("AND", Token.AND);
//        keywords.put("ANY", Token.ANY);
//        keywords.put("AS", Token.AS);
//
//        keywords.put("ENABLE", Token.ENABLE);
//        keywords.put("DISABLE", Token.DISABLE);
//
//        keywords.put("ASC", Token.ASC);
//        keywords.put("BETWEEN", Token.BETWEEN);
//        keywords.put("BY", Token.BY);
//        keywords.put("CASE", Token.CASE);
//        keywords.put("CAST", Token.CAST);
//
//        keywords.put("CHECK", Token.CHECK);
//        keywords.put("CONSTRAINT", Token.CONSTRAINT);
//        keywords.put("CREATE", Token.CREATE);
//        keywords.put("DATABASE", Token.DATABASE);
//        keywords.put("DEFAULT", Token.DEFAULT);
//        keywords.put("COLUMN", Token.COLUMN);
//        keywords.put("TABLESPACE", Token.TABLESPACE);
//        keywords.put("PROCEDURE", Token.PROCEDURE);
//        keywords.put("FUNCTION", Token.FUNCTION);
//
//        keywords.put("DELETE", Token.DELETE);
//        keywords.put("DESC", Token.DESC);
//        keywords.put("DISTINCT", Token.DISTINCT);
//        keywords.put("DROP", Token.DROP);
//        keywords.put("ELSE", Token.ELSE);
//        keywords.put("EXPLAIN", Token.EXPLAIN);
//        keywords.put("EXCEPT", Token.EXCEPT);
//
//        keywords.put("END", Token.END);
//        keywords.put("ESCAPE", Token.ESCAPE);
//        keywords.put("EXISTS", Token.EXISTS);
//        keywords.put("FOR", Token.FOR);
//        keywords.put("FOREIGN", Token.FOREIGN);
//
//        keywords.put("FROM", Token.FROM);
//        keywords.put("FULL", Token.FULL);
//        keywords.put("GROUP", Token.GROUP);
//        keywords.put("HAVING", Token.HAVING);
//        keywords.put("IN", Token.IN);
//
//        keywords.put("INDEX", Token.INDEX);
//        keywords.put("INNER", Token.INNER);
//        keywords.put("INSERT", Token.INSERT);
//        keywords.put("INTERSECT", Token.INTERSECT);
//        keywords.put("INTERVAL", Token.INTERVAL);
//
//        keywords.put("INTO", Token.INTO);
//        keywords.put("IS", Token.IS);
//        keywords.put("JOIN", Token.JOIN);
//        keywords.put("KEY", Token.KEY);
//        keywords.put("LEFT", Token.LEFT);
//
//        keywords.put("LIKE", Token.LIKE);
//        keywords.put("LOCK", Token.LOCK);
//        keywords.put("MINUS", Token.MINUS);
//        keywords.put("NOT", Token.NOT);
//
//        keywords.put("NULL", Token.NULL);
//        keywords.put("ON", Token.ON);
//        keywords.put("OR", Token.OR);
//        keywords.put("ORDER", Token.ORDER);
//        keywords.put("OUTER", Token.OUTER);
//
//        keywords.put("PRIMARY", Token.PRIMARY);
//        keywords.put("REFERENCES", Token.REFERENCES);
//        keywords.put("RIGHT", Token.RIGHT);
//        keywords.put("SCHEMA", Token.SCHEMA);
//        keywords.put("SELECT", Token.SELECT);
//
//        keywords.put("SET", Token.SET);
//        keywords.put("SOME", Token.SOME);
//        keywords.put("TABLE", Token.TABLE);
//        keywords.put("THEN", Token.THEN);
//        keywords.put("TRUNCATE", Token.TRUNCATE);
//
//        keywords.put("UNION", Token.UNION);
//        keywords.put("UNIQUE", Token.UNIQUE);
//        keywords.put("UPDATE", Token.UPDATE);
//        keywords.put("VALUES", Token.VALUES);
//        keywords.put("VIEW", Token.VIEW);
//        keywords.put("SEQUENCE", Token.SEQUENCE);
//        keywords.put("TRIGGER", Token.TRIGGER);
//        keywords.put("USER", Token.USER);
//
//        keywords.put("WHEN", Token.WHEN);
//        keywords.put("WHERE", Token.WHERE);
//        keywords.put("XOR", Token.XOR);
//
//        keywords.put("OVER", Token.OVER);
//        keywords.put("TO", Token.TO);
//        keywords.put("USE", Token.USE);
//
//        keywords.put("REPLACE", Token.REPLACE);
//
//        keywords.put("COMMENT", Token.COMMENT);
//        keywords.put("COMPUTE", Token.COMPUTE);
//        keywords.put("WITH", Token.WITH);
//        keywords.put("GRANT", Token.GRANT);
//	}
//    
//}
