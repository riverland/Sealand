package org.river.sealand.proto;

/**
 * <p>
 * 消息体
 * 
 * @author river
 * @since Dec 25, 2013
 */
public class Message {

	private int length;

	private Type type;

	private byte[] data;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * <p>
	 * 消息类型枚举
	 * 
	 * @author river
	 * @since Dec 25, 2013
	 */
	public static enum Type {
		ASYNC_NOTIFY('A'),
		ROW_DESC('T'),
		NO_DATA('N');

		private char value;

		private Type(char value) {
			this.value = value;
		}

		public char getValue() {
			return this.value;
		}

		public static Type fromValue(char value) {
			if (value == ROW_DESC.value) {
				return ROW_DESC;
			}

			return null;
		}

	}
}
