package org.river.sealand.zk;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import junit.framework.TestCase;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * zookeeper client test
 * 
 * @author river
 * @since Dec 1, 2013
 */
public class ZooKeeperTestCase extends TestCase implements Watcher {
	private static final Logger log=LoggerFactory.getLogger(ZooKeeperTestCase.class);
	private ZooKeeper zooKeeper;
	private CountDownLatch latch = new CountDownLatch(1);

	@Override
	protected void setUp() throws Exception {
		zooKeeper = new ZooKeeper("127.0.0.1:2181", 3000, this);
		latch.await();
	}

	public void testWatch() throws KeeperException, InterruptedException{
//		Stat stat=zooKeeper.exists("/a/b", new ChangedWatcher());
//		
//		if(stat!=null){
//			log.debug("ctime:["+stat.getCtime()+"]");
//		}
		List<String> children=zooKeeper.getChildren("/a", new ChangedWatcher());
		
//		if(children!=null&&!children.isEmpty()){
//			for(String tmp:children){
//				Stat stat=zooKeeper.exists("/a/"+tmp, null);
//				log.info("deleting:"+tmp);
//				zooKeeper.delete("/a/"+tmp, stat.getVersion());
//				log.info("deleted:"+tmp);
//			}
//		}
		Thread.sleep(60*1000);
	}

	@Override
	protected void tearDown() throws Exception {
		zooKeeper.close();
		super.tearDown();
	}

	@Override
	public void process(WatchedEvent event) {
		log.info("------------------------------------");
		if (event.getState() == KeeperState.SyncConnected) {
			latch.countDown();
		}
	}

	class ChangedWatcher implements Watcher {

		@Override
		public void process(WatchedEvent event) {
			log.debug(""+event.getType().getIntValue());
			if (event.getType() == EventType.NodeCreated) {
				log.debug("Node[/a/b]Created");
			}else if(event.getType() == EventType.NodeDeleted){
				log.debug("Node[/a/b]deleted");
			}
		}

	}

}
