package org.river.sealand.node.data;

/**
 * <p>
 * 数据集监听
 * 
 * @author river
 * @since Dec 8, 2013
 */
public interface IDataWatcher {
	/**
	 * 数据集监听
	 * 
	 * @param event
	 * @return 发生此事件的数据ID
	 */
	public String fire(DataEvent event);

	public static class DataEvent {
		private String dataId;

		private EventType event;		

		public String getDataId() {
			return dataId;
		}

		public void setDataId(String dataId) {
			this.dataId = dataId;
		}

		public EventType getEvent() {
			return event;
		}

		public void setEvent(EventType event) {
			this.event = event;
		}

	}

	public static enum EventType {
		CREATE,READY
	}
}
