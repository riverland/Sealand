package org.river.sealand.node.data;

import org.gpy.fel.FelEngine;
import org.gpy.fel.FelEngineImpl;

/**
 * <p>
 * 执行布尔表达式
 * 
 * @author river
 * @since Dec 7, 2013
 */
public class ExprExcutor {
	
	/**
	 * <p>
	 * 执行bool表达式
	 * @param expr
	 * @return
	 */
	public static Object eval(String expr) {
		FelEngine fel = new FelEngineImpl();
		Object result = fel.eval(expr);
		return result;
	}
	
	/**
	 * <p>
	 * 把sql表达式转换为java表达式
	 * @param expr
	 * @return
	 */
	public static String fixBoolExpr(String expr){
		return "";
	}
}
