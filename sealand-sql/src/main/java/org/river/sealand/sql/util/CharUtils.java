package org.river.sealand.sql.util;

/**
 * <p>
 * 字符工具类
 * 
 * @author river
 * @since Nov 16, 2013
 */
public class CharUtils {

	private final static boolean[] HEX_FLAGS = new boolean[128];
	private final static boolean[] FIRST_IDENTIFIER_FLAGS = new boolean[256];
	private final static boolean[] IDENTIFIER_FLAGS = new boolean[256];
	private final static boolean[] WHITE_SPACE_FLAGS = new boolean[256];

	// 初始化HEX_FLAGS
	static {
		for (char c = 0; c < HEX_FLAGS.length; ++c) {
			if ((c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f')
					|| (c >= '0' && c <= '9')) {
				HEX_FLAGS[c] = true;
			}
		}
	}

	// 初始化FIRST_IDENTIFIER_FLAGS,IDENTIFIER_FLAGS
	static {
		for (char c = 0; c < FIRST_IDENTIFIER_FLAGS.length; ++c) {
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
				FIRST_IDENTIFIER_FLAGS[c] = true;
				IDENTIFIER_FLAGS[c] = true;
			}

			if (c >= '0' && c <= '9') {
				IDENTIFIER_FLAGS[c] = true;
			}
		}
		FIRST_IDENTIFIER_FLAGS['`'] = true;
		FIRST_IDENTIFIER_FLAGS['_'] = true;
		FIRST_IDENTIFIER_FLAGS['$'] = true;

		IDENTIFIER_FLAGS['`'] = true;
		IDENTIFIER_FLAGS['_'] = true;
		IDENTIFIER_FLAGS['$'] = true;
	}

	// 初始化WHITE_SPACE_FLAGS
	static {
		for (int i = 0; i <= 32; ++i) {
			WHITE_SPACE_FLAGS[i] = true;
		}

		WHITE_SPACE_FLAGS[Format.EOT] = false;
		for (int i = 0x7F; i <= 0xA0; ++i) {
			WHITE_SPACE_FLAGS[i] = true;
		}

		WHITE_SPACE_FLAGS[160] = true;
	}

	/**
	 * <p>
	 * 判断是否是16进制字符
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isHex(char c) {
		return c < 256 && HEX_FLAGS[c];
	}

	/**
	 * <p>
	 * 判断是否数字字符
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	/**
	 * <p>
	 * 判断字符是否可以作为标识否的第一个字符
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isFirstable4Identifier(char c) {
		if (c <= FIRST_IDENTIFIER_FLAGS.length) {
			return FIRST_IDENTIFIER_FLAGS[c];
		}
		return c != '　' && c != '，';
	}

	/**
	 * <p>
	 * 判断字符是否可以作为标识字符
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isIdentifierChar(char c) {
		if (c <= IDENTIFIER_FLAGS.length) {
			return IDENTIFIER_FLAGS[c];
		}
		return c != '　' && c != '，';
	}

	/**
	 * <p>
	 * 判断是否为空白字符
	 */
	public static boolean isWhitespace(char c) {
		return (c <= WHITE_SPACE_FLAGS.length && WHITE_SPACE_FLAGS[c]);
	}
	
	/**
	 * <p>
	 * 判断是否是操作符
	 * @param ch
	 * @return
	 */
    public static boolean isOperator(char ch) {
        switch (ch) {
            case '!':
            case '%':
            case '&':
            case '*':
            case '+':
            case '-':
            case '<':
            case '=':
            case '>':
            case '^':
            case '|':
            case '~':
            case ';':
                return true;
            default:
                return false;
        }
    }

}
