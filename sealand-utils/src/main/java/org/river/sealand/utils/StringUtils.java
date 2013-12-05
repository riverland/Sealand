package org.river.sealand.utils;

/**
 * <p>
 * 字符串相关工具类
 * 
 * @author river
 * @since Dec 5, 2013
 */
public class StringUtils {
	/**
	 * <p>
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
}
