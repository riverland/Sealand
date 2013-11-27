package org.river.sealand.schedule.visitor;

import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.sql.ast.ISqlStruct;

/**
 * <p>
 * 抽象语法树访问者接口
 * @author river
 * @since  Nov 27, 2013
 */
public interface IAstVisitor {
	
	/**
	 * <p>
	 * 抽象语法树访问者接口
	 * @param ast
	 * @return
	 */
	public ScheduleNode visit(ISqlStruct ast);
	
	/**
	 * <p>
	 * 判断ast是否接受访问
	 * @param ast
	 * @return
	 */
	public boolean accept(ISqlStruct ast);
}
