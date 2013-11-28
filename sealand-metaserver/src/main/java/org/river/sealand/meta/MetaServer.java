package org.river.sealand.meta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * 服务入口
 * @author river
 * @date 20120913
 */
public class MetaServer {
	private static Logger log=LoggerFactory.getLogger(MetaServer.class);
	private static MetaDaemon daemon=new MetaDaemon();
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		daemon.init();
		daemon.start();
		
		ClassPathXmlApplicationContext ctx=daemon.getContext();
		ctx.refresh();
		ctx.registerShutdownHook();
		//启动初始化线程
		final DaemonThread thread = new DaemonThread();
		thread.start();		
		//加载钩子
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				thread.setStopped(true);
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
			}
		});
	}

	/**
	 * 启动线程
	 * @author river
	 * @date 20120913
	 */
	static class DaemonThread extends Thread{
		private boolean initialized;
		private boolean stopped;

		public DaemonThread() {
			initialized = false;
			stopped = false;
		}

		public void setStopped(boolean stopped) {
			this.stopped = stopped;
		}
		@Override
		public void run() {
			while (true) {
				if (!initialized) {
					initialized = true;
				}

				synchronized (this) {
					try {
						wait(10000);
					} catch (Exception ex) {
					}

					if (stopped) {
						break;
					}
				}
			}

			log.info("Server stopped!");
		}
		
	}
}
