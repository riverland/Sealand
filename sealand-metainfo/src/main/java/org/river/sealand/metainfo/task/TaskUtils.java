package org.river.sealand.metainfo.task;

/**
 * <p>
 * 任务工具类
 * 
 * @author river
 * @since Dec 3, 2013
 */
public class TaskUtils {

	private static Integer cycle = 0;

	/**
	 * <p>
	 * 生成任务ID TODO 该方法依赖静态变量，向后如果需要可存放在状态服务器
	 * 
	 * @return
	 */
	public static final String genTaskId() {
		synchronized (cycle) {
			if (cycle >= 1000) {
				cycle = 0;
			} else {
				cycle++;
			}

		}

		return "task-yyyyMMddHHmmssSSS-"+String.format("%03d", cycle);
	}
}
