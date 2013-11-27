package org.river.sealand.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String YYYYMMDDHHMMSS="yyyyMMddHHmmss";
	public static String format(Date date,String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
