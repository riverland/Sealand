package org.river.sealand.schedule.node;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * sql执行计划树
 * 
 * @author river
 * @since Nov 27, 2013
 */
public abstract class ScheduleNode {

	/** 数据源节点 */
	private List<ScheduleNode> srcNodes;

	/** 目标节点 */
	private ScheduleNode destNode;

	/** 是否为顶级节点 */
	private boolean isTop;

	/** 是否为叶子节点 */
	private boolean isLeaf;

	/** 节点宿主 */
	private Set<String> hosts;
	
	/**该节点计算结果的列名*/
	private List<String> fields;
	
	/**该节点计算结果集的别名*/
	private String alias;

	public List<String> getFields() {
		return fields;
	}


	public abstract NodeType getNodeType();

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<ScheduleNode> getSrcNodes() {
		return srcNodes;
	}

	public void setSrcNodes(List<ScheduleNode> srcNodes) {
		this.srcNodes = srcNodes;
	}

	public ScheduleNode getDestNode() {
		return destNode;
	}

	public void setDestNode(ScheduleNode destNode) {
		this.destNode = destNode;
	}

	public Set<String> getHosts() {
		return hosts;
	}

	public void setHosts(Set<String> hosts) {
		this.hosts = hosts;
	}	

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * <p>
	 * 执行节点类型
	 * 
	 * @author river
	 * @since Nov 27, 2013
	 */
	public static enum NodeType {
		JOIN, SORT, AGGREGATE, LIMIT, HAVING, SCAN;
	}
}
