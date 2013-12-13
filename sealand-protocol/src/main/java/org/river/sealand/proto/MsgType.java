package org.river.sealand.proto;

/**
 * <p>
 * 消息类型
 * 
 * @author river
 * @since Dec 11, 2013
 */
public enum MsgType {
	RAW_DATA('R');
	private char value;

	public char getValue() {
		return this.value;
	}

	private MsgType(char value) {
		this.value = value;
	}

}
