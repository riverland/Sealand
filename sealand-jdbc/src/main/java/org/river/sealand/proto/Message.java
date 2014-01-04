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
		/**异步消息*/
		ASYNC_NOTIFY('A'),
		/**列元数据信息*/
		ROW_DESC('T'),
		/**结果集数据传输中的一行数据信息*/
		DATA_TRANSFER('D'),
		/**没有数据*/
		NO_DATA('N'),
		/**关闭resultSet*/
		RS_CLOSE('C');

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
