package org.river.sealand.meta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * 服务模拟daemon
 * @author river
 * @date 20120920
 */
public class MetaDaemon implements Daemon {
	private static Logger log=LoggerFactory.getLogger(MetaDaemon.class);
	
	private static final String CLASSPATH_APP_CTX="applicationContext.xml";
	
	private ClassPathXmlApplicationContext context = null;

	public void init() throws Exception {
		log.info("daemon initialized");
	}

	public void start() throws Exception {
		try{
			context=new ClassPathXmlApplicationContext(CLASSPATH_APP_CTX);			
			log.info("daemon started");
		}catch(Exception e){
			log.error("daemon start failed",e);
		}
	}

	public void stop() throws Exception {
		// TODO 结束daemon的业务逻辑
		log.info("daemon stoped");
	}

	public void destroy() {
		// TODO 销毁的业务逻辑
		log.info("daemon destroyed");
	}
	
	
	public ClassPathXmlApplicationContext getContext() {
		return context;
	}
}
