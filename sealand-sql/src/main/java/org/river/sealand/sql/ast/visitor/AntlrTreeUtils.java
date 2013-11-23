package org.river.sealand.sql.ast.visitor;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.Tree;

/**
 * <p>
 * antlr语法树工具类
 * 
 * @author river
 * @since Nov 22, 2013
 */
public class AntlrTreeUtils {

	/**
	 * <p>
	 * 获取规则类型
	 * 
	 * @param treeNode
	 * @return
	 */
	public static Rule getRule(Tree treeNode, Parser parser) {
		if (treeNode == null || parser == null) {
			return null;
		}

		List<String> ruleNames = Arrays.asList(parser.getRuleNames());
		if (ruleNames == null || ruleNames.isEmpty()) {
			return null;
		}
		
		Rule rule=null;
		if ( treeNode instanceof RuleNode ) {
			int ruleIndex = ((RuleNode)treeNode).getRuleContext().getRuleIndex();
			String ruleName = ruleNames.get(ruleIndex);
			rule= Rule.getRule(ruleName);
		}
		
		return rule;
	}
}
