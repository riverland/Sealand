package org.river.sealand.node.handler;

import org.river.base.threads.impl.QueueHandlerAdaptor;
import org.river.base.threads.type.DataEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据集转移处理器
 * @author river
 * @since  Dec 12, 2013
 * @param <E>
 */
public class DataSetTranseferHandler<E> extends QueueHandlerAdaptor<E> {
	private static final Logger LOG=LoggerFactory.getLogger(DataSetTranseferHandler.class);
		
	@Override
	public void handle(DataEntity<E> data) {
		// TODO Auto-generated method stub
		super.handle(data);
	}


	@Override
	public Class<?> getDataType() {
		return byte[].class;
	}

}
