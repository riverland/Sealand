package org.river.sealand.metainfo.task;

import java.util.List;

/**
 * <p>
 * 数据传输任务
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class TransferTask extends Task {
	private static final long serialVersionUID = -3649229582782414037L;
	
	/** 要传输到的节点 */
	public List<String> destServers;

	@Override
	public Type getType() {
		return Type.TRANSFER;
	}

}
