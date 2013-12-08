package org.river.sealand.utils;

import java.util.Arrays;
import java.util.List;

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
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}

	/**
	 * <p>
	 * 逗号分组
	 * @param var
	 * @return
	 */
	public static List<String> commaSplit(String var) {
		if (isEmpty(var)) {
			return null;
		}
		String[] arr = var.split(",");
		return Arrays.asList(arr);
	}
}
