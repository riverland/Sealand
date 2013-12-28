package org.river.sealand.proto;

import java.lang.reflect.Field;
import java.sql.SQLException;

/**
 * <p>
 * 参考postgresql 后端数据类型
 */
public class Oid {
	public static final int UNSPECIFIED = 0;
	public static final int INT2 = 21;
	public static final int INT2_ARRAY = 1005;
	public static final int INT4 = 23;
	public static final int INT4_ARRAY = 1007;
	public static final int INT8 = 20;
	public static final int INT8_ARRAY = 1016;
	public static final int TEXT = 25;
	public static final int TEXT_ARRAY = 1009;
	public static final int NUMERIC = 1700;
	public static final int NUMERIC_ARRAY = 1231;
	public static final int FLOAT4 = 700;
	public static final int FLOAT4_ARRAY = 1021;
	public static final int FLOAT8 = 701;
	public static final int FLOAT8_ARRAY = 1022;
	public static final int BOOL = 16;
	public static final int BOOL_ARRAY = 1000;
	public static final int DATE = 1082;
	public static final int DATE_ARRAY = 1182;
	public static final int TIME = 1083;
	public static final int TIME_ARRAY = 1183;
	public static final int TIMETZ = 1266;
	public static final int TIMETZ_ARRAY = 1270;
	public static final int TIMESTAMP = 1114;
	public static final int TIMESTAMP_ARRAY = 1115;
	public static final int TIMESTAMPTZ = 1184;
	public static final int TIMESTAMPTZ_ARRAY = 1185;
	public static final int BYTEA = 17;
	public static final int BYTEA_ARRAY = 1001;
	public static final int VARCHAR = 1043;
	public static final int VARCHAR_ARRAY = 1015;
	public static final int OID = 26;
	public static final int OID_ARRAY = 1028;
	public static final int BPCHAR = 1042;
	public static final int BPCHAR_ARRAY = 1014;
	public static final int MONEY = 790;
	public static final int MONEY_ARRAY = 791;
	public static final int NAME = 19;
	public static final int NAME_ARRAY = 1003;
	public static final int BIT = 1560;
	public static final int BIT_ARRAY = 1561;
	public static final int VOID = 2278;
	public static final int INTERVAL = 1186;
	public static final int INTERVAL_ARRAY = 1187;
	public static final int CHAR = 18; // This is not char(N), this is "char" a
										// single byte type.
	public static final int CHAR_ARRAY = 1002;
	public static final int VARBIT = 1562;
	public static final int VARBIT_ARRAY = 1563;
	public static final int UUID = 2950;
	public static final int UUID_ARRAY = 2951;
	public static final int XML = 142;
	public static final int XML_ARRAY = 143;
	public static final int POINT = 600;
	public static final int BOX = 603;

	/**
	 * Returns the name of the oid as string.
	 * 
	 * @param oid
	 *            The oid to convert to name.
	 * @return The name of the oid or "<unknown>" if oid no constant for oid
	 *         value has been defined.
	 */
	public static String toString(int oid) {
		try {
			Field[] fields = Oid.class.getFields();
			for (int i = 0; i < fields.length; ++i) {
				if (fields[i].getInt(null) == oid) {
					return fields[i].getName();
				}
			}
		} catch (IllegalAccessException e) {
			// never happens
		}
		return "<unknown:" + oid + ">";
	}

	public static int valueOf(String oid) throws SQLException {
		try {
			return (int) Long.parseLong(oid);
		} catch (NumberFormatException ex) {
		}
		try {
			oid = oid.toUpperCase();
			Field[] fields = Oid.class.getFields();
			for (int i = 0; i < fields.length; ++i) {
				if (fields[i].getName().toUpperCase().equals(oid)) {
					return fields[i].getInt(null);
				}
			}
		} catch (IllegalAccessException e) {
			// never happens
		}
		throw new SQLException("oid type {" + oid + "} not known and not a number");
	}
}
