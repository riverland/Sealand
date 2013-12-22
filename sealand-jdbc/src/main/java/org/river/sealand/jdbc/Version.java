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

}
