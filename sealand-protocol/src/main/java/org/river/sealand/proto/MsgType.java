package org.river.sealand.proto;

/**
 * <p>
 * 消息类型
 * 
 * @author river
 * @since Dec 11, 2013
 */
public enum MsgType {
	RAW_DATA('R'), TRANSFER('T');
	private char value;

	public char getValue() {
		return this.value;
	}

	private MsgType(char value) {
		this.value = value;
	}

	/**
	 * <p>
	 * 从值中获取实例
	 * @param value
	 * @return
	 */
	public static MsgType fromValue(char value) {
		if (RAW_DATA.value == value) {
			return RAW_DATA;
		}

		if (TRANSFER.value == value) {
			return RAW_DATA;
		}

		return null;
	}

}
