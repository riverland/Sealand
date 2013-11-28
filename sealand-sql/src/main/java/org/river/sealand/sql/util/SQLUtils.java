package org.river.sealand.sql.util;

import java.util.List;

/**
 * <p>
 * sql相关工具类
 * @author river
 * @since  Nov 28, 2013
 */
public class SQLUtils {
	
	/**
	 * <p>
	 * 构建选择列表
	 * @param fields
	 * @return
	 */
	public static String buildSelectList(List<String> fields){
		StringBuffer sb=new StringBuffer();
		boolean flag=true;
		for(String tmp:fields){
			if(flag){
				sb.append(tmp);
				flag=false;
			}else{
				sb.append(",").append(tmp);
			}
		}
		return sb.toString();
	}
}
