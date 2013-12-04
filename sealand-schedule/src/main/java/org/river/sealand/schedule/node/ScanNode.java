package org.river.sealand.schedule.node;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * SCAN 节点主要对应于一个SQL执行节点
 * 
 * @author river
 * @since Nov 27, 2013
 */
public class ScanNode extends ScheduleNode implements Serializable {

	private static final long serialVersionUID = 4674906084285155336L;

	private String sql;

	private boolean isGlobal;
	
	private List<String> tables;

	public List<String> getTables() {
		return tables;
	}

	public void setTables(List<String> tables) {
		this.tables = tables;
	}

	public boolean isGlobal() {
		return isGlobal;
	}

	public void setGlobal(boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public NodeType getNodeType() {
		return NodeType.SCAN;
	}

}
