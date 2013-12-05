package org.river.sealand.metainfo.task;

/**
 * <p>
 * 任务状态
 * 
 * @author river
 * @since Dec 5, 2013
 */
public enum TaskStatus {
	PLANNED("001"), TO_ASSIGN("005"), ASSIGNING("010"), ASSIGNED("015"), COMMPLETED("020"), FAILED("999");

	private String value;

	public String getValue() {
		return value;
	}

	private TaskStatus(String value) {
		this.value = value;
	}

	/**
	 * <p>
	 * 根据字符串值获取
	 * 
	 * @param value
	 * @return
	 */
	public static TaskStatus fromValue(String value) {
		if (TO_ASSIGN.getValue().equals(value)) {
			return TO_ASSIGN;
		}

		if (PLANNED.getValue().equals(value)) {
			return PLANNED;
		}

		if (ASSIGNING.getValue().equals(value)) {
			return ASSIGNING;
		}

		if (ASSIGNED.getValue().equals(value)) {
			return ASSIGNED;
		}

		if (COMMPLETED.getValue().equals(value)) {
			return COMMPLETED;
		}

		if (FAILED.getValue().equals(value)) {
			return FAILED;
		}

		return null;

	}

}
