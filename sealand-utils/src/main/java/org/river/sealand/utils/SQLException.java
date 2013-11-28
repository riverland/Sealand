package org.river.sealand.utils;

/**
 * <p>
 * sql解析相关的异常
 * @author river
 * @since  Nov 16, 2013
 */
public class SQLException extends Exception {
	private static final long serialVersionUID = 4946813593495391195L;
	public static final String ILLEGAL_VARIABLE="illegal variable";
	private Type type;

	public SQLException(Type type) {
		super();
		this.type = type;
	}
	
	public SQLException(String message) {
		super(message);
	}
	
	
	public SQLException(Type type,String message) {
		super(message);
		this.type = type;
	}

	public Type getType() {
		return type;
	}


	public static enum Type{
		PARSE,EXECUTE;
	}
}
