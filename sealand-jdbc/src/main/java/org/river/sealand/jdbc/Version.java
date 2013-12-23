package org.river.sealand.jdbc;

/**
 * <p>
 * 协议版本号
 * 
 * @author river
 * @since Dec 18, 2013
 */
public enum Version {
	V1_0(1), V2_1(5);

	private int value;

	private Version(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Version fromValue(int value) {
		if (V1_0.value == value) {
			return V1_0;
		} else if (V2_1.value == value) {
			return V2_1;
		}

		return null;
	}

}
