package org.river.sealand.metainfo.task;

/**
 * <p>
 * SQL执行任务
 * @author river
 * @since  Dec 1, 2013
 */
public class ScanTask extends Task {
	private static final long serialVersionUID = 6904977354729832888L;

	/** 可执行的sql */
	public String sql;

	@Override
	public Type getType() {
		return Type.SCAN;
	}
}
