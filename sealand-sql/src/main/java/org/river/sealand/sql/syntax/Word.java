package org.river.sealand.sql.syntax;
/**
 * <p>
 * sql语句中到词，类型有：关键字，标识符，操作符
 * @author river
 * @since  Nov 15, 2013
 */
public class Word {
	private String value;
	
	private WordType type;
	
	private Token token;
	
	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public WordType getType() {
		return type;
	}

	public void setType(WordType type) {
		this.type = type;
	}

	/**
	 * <p>
	 * sql词类型有：关键字，标识符，操作符
	 * @author river
	 * @since  Nov 15, 2013
	 */
	public static enum WordType{
		KEYWORD,IDENTIFIER,OPERATOR,VARIANT,VALUE,ALIAS;
	}
}
