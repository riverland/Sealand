package org.river.sealand.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 时间相关工具方法
 * 
 * @author river
 * @since Jan 8, 2014
 */
public class DateUtils {
	public final static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

	/**
	 * <p>
	 * 解析时间
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}
}
