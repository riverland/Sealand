package org.river.sealand.schedule.visitor;

import org.river.sealand.schedule.node.ScheduleNode;
import org.river.sealand.schedule.node.ScheduleNode.NodeType;
import org.river.sealand.sql.ast.ISqlStruct;

/**
 * <p>
 * 抽象语法树访问者抽象类
 * 
 * @author river
 * @since Nov 27, 2013
 */
public abstract class ASTVisitor implements IAstVisitor {

	/**
	 * <p>
	 * 实际访问逻辑
	 * 
	 * @param ast
	 * @return
	 */
	protected abstract ScheduleNode doVisit(ISqlStruct ast);

	public ScheduleNode visit(ISqlStruct ast) {
		if (!this.accept(ast)) {
			return null;
		}
		return this.doVisit(ast);
	}
	
	/**
	 * <p>
	 * 判断节点类型
	 * @param ast
	 * @return
	 */
	protected NodeType getNodeType(ISqlStruct ast){
		return null;
	}

}
