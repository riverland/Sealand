package org.river.sealand.node.task;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.river.base.threads.type.DataEntity;
import org.river.sealand.metainfo.task.Task;
import org.river.sealand.metainfo.task.Task.Type;
import org.river.sealand.metainfo.task.TransferTask;
import org.river.sealand.proto.data.DataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 传输任务处理器,主要对本对缓存中的数据对象传输到指定的节点去
 * 
 * @author river
 * @since Dec 13, 2013
 */
public class TranseferTaskHandler extends TaskHandler {
	private static final Logger LOG = LoggerFactory.getLogger(TranseferTaskHandler.class);

	private ExecutorService executor;
	private int coreHandlerPoolSize = 30;
	private int maxHandlerPoolSize = 50;
	private int handleThreadKeepAliveTime = 30;
	private int handlerPoolQueueSize = 2000;

	public void initialize() {
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(handlerPoolQueueSize);
		this.executor = new ThreadPoolExecutor(coreHandlerPoolSize, maxHandlerPoolSize, handleThreadKeepAliveTime, TimeUnit.SECONDS, workQueue);
	}

	@Override
	public void handle(DataEntity<Task> data) {
		if (!this.needHandle(data)) {
			return;
		}

		TransferTask trans = (TransferTask) data.getData();
		List<String> destNodes = trans.destServers;
		for (String tmp : destNodes) {
			this.executor.execute(new TransferThread(trans, tmp));
		}

		data.setData(null);
	}

	@Override
	public Class<?> getDataType() {
		return Task.class;
	}

	@Override
	protected boolean needHandle(DataEntity<Task> data) {
		Task task = data.getData();

		return task.getType() == Type.TRANSFER;
	}

	/**
	 * <p>
	 * 传输任务线程
	 * 
	 * @author river
	 * @since Dec 14, 2013
	 */
	private class TransferThread implements Runnable {
		private TransferTask task;
		private String dest;

		public TransferThread(TransferTask task, String dest) {
			this.task = task;
			this.dest = dest;
		}

		@Override
		public void run() {
			DataSet data=dataManager.getDataSet(task.dataId);
			
		}

	}

}
