package org.river.sealand.proto.data;

/**
 * <p>
 * 支持的数据类型
 * 
 * @author river
 * @since Dec 7, 2013
 */
public enum DataType {
	STRING('S'), INT('I'), FLOAT('F');

	private char value;

	public char getValue() {
		return this.value;
	}

	private DataType(char value) {
		this.value = value;
	}

	/**
	 * <p>
	 * 根据value值返回DataType
	 * 
	 * @param value
	 * @return
	 */
	public static DataType get(char value) {
		if (value == STRING.value) {
			return STRING;
		} else if (value == INT.value) {
			return INT;
		} else if (value == FLOAT.value) {
			return FLOAT;
		} else {
			return null;
		}
	}

}
