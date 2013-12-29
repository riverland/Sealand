package org.river.sealand.proto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

/**
 * <p>
 * 数据类型定义对象
 * 
 * @author river
 * @since Dec 29, 2013
 */
public enum Type implements IType {
	INT2("int2", Integer.class, new Integer(Oid.INT2), new Integer(Types.SMALLINT), Oid.INT2_ARRAY), 
	INT4("int4", Integer.class, new Integer(Oid.INT4), new Integer(Types.INTEGER), Oid.INT4_ARRAY), 
	OID("oid", Long.class, new Integer(Oid.OID), new Integer(Types.BIGINT), Oid.OID_ARRAY), 
	INT8("int8", Long.class, new Integer(Oid.INT8), new Integer(Types.BIGINT), Oid.INT8_ARRAY), 
	MONEY("money", Double.class, new Integer(Oid.MONEY), new Integer(Types.DOUBLE), Oid.MONEY_ARRAY), 
	NUMERIC("numeric", BigDecimal.class, new Integer(Oid.NUMERIC), new Integer(Types.NUMERIC),Oid.NUMERIC_ARRAY), 
	FLOAT4("float4", Float.class, new Integer(Oid.FLOAT4), new Integer(Types.REAL), Oid.FLOAT4_ARRAY), 
	FLOAT8("float8", Double.class, new Integer(Oid.FLOAT8), new Integer(Types.DOUBLE), Oid.FLOAT8_ARRAY), 
	CHAR("char", String.class, new Integer(Oid.CHAR), new Integer(Types.CHAR), Oid.CHAR_ARRAY), 
	BPCHAR("bpchar", String.class, new Integer(Oid.BPCHAR),new Integer(Types.CHAR), Oid.BPCHAR_ARRAY),
	VARCHAR("varchar", String.class, new Integer(Oid.VARCHAR), new Integer(Types.VARCHAR), Oid.VARCHAR_ARRAY), 
	TEXT("text", String.class,new Integer(Oid.TEXT), new Integer(Types.VARCHAR), Oid.TEXT_ARRAY), 
	NAME("name", String.class, new Integer(Oid.NAME), new Integer(Types.VARCHAR), Oid.NAME_ARRAY), 
	BYTEA("bytea",byte[].class, new Integer(Oid.BYTEA), new Integer(Types.BINARY), Oid.BYTEA_ARRAY), 
	BOOL("bool", Boolean.class, new Integer(Oid.BOOL), new Integer(Types.BIT), Oid.BOOL_ARRAY), 
	BIT("bit",Boolean.class, new Integer(Oid.BIT), new Integer(Types.BIT), Oid.BIT_ARRAY), 
	DATE("date", Date.class, new Integer(Oid.DATE), new Integer(Types.DATE), Oid.DATE_ARRAY), 
	TIME("time",Time.class, new Integer(Oid.TIME), new Integer(Types.TIME), Oid.TIME_ARRAY), 
	TIMETZ("timetz", Time.class, new Integer(Oid.TIME), new Integer(Types.TIME), Oid.TIMETZ_ARRAY), 
	TIMESTAMP("timestamp", Timestamp.class, new Integer(Oid.TIMESTAMP), new Integer(Types.TIMESTAMP), Oid.TIMESTAMP_ARRAY), 
	TIMESTAMPTZ("timestamptz", Timestamp.class, new Integer(Oid.TIMESTAMPTZ),new Integer(Types.TIMESTAMP), Oid.TIMESTAMPTZ_ARRAY), ;

	public static final int UNKOWN_LENGTH = -1;

	private String typeName;
	private Class<?> clazz;
	private Integer oid;
	private Integer sqlType;
	private Integer arrayOid;

	private Type(String typeName, Class<?> clazz, Integer oid, Integer sqlType, Integer arrayOid) {
		this.typeName = typeName;
		this.clazz = clazz;
		this.oid = oid;
		this.sqlType = sqlType;
		this.arrayOid = arrayOid;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public Integer getSqlType() {
		return sqlType;
	}

	public Integer getArrayOid() {
		return arrayOid;
	}

	
	@Override
	public String getTypeName() {
		return this.getTypeName();
	}

	@Override
	public Integer getOid() {
		return this.oid;
	}

	@Override
	public Class<?> getJavaClass() throws SQLException {
		return this.clazz;
	}

	@Override
	public Integer getPrecision(int typmod) {
		switch (oid) {
		case Oid.INT2:
			return 5;

		case Oid.OID:
		case Oid.INT4:
			return 10;

		case Oid.INT8:
			return 19;

		case Oid.FLOAT4:
			return 8;

		case Oid.FLOAT8:
			return 17;

		case Oid.NUMERIC:
			if (typmod == -1)
				return 0;
			return ((typmod - 4) & 0xFFFF0000) >> 16;

		case Oid.CHAR:
		case Oid.BOOL:
			return 1;

		case Oid.BPCHAR:
		case Oid.VARCHAR:
			if (typmod == -1)
				return UNKOWN_LENGTH;
			return typmod - 4;

		case Oid.DATE:
		case Oid.TIME:
		case Oid.TIMETZ:
		case Oid.INTERVAL:
		case Oid.TIMESTAMP:
		case Oid.TIMESTAMPTZ:
			return getDisplaySize(typmod);

		case Oid.BIT:
			return typmod;

		case Oid.VARBIT:
			if (typmod == -1)
				return UNKOWN_LENGTH;
			return typmod;

		case Oid.TEXT:
		case Oid.BYTEA:
		default:
			return UNKOWN_LENGTH;
		}
	}

	@Override
	public Integer getScale(int typmod) {
		switch (oid) {
		case Oid.FLOAT4:
			return 8;
		case Oid.FLOAT8:
			return 17;
		case Oid.NUMERIC:
			if (typmod == -1)
				return 0;
			return (typmod - 4) & 0xFFFF;
		case Oid.TIME:
		case Oid.TIMETZ:
		case Oid.TIMESTAMP:
		case Oid.TIMESTAMPTZ:
			if (typmod == -1)
				return 6;
			return typmod;
		case Oid.INTERVAL:
			if (typmod == -1)
				return 6;
			return typmod & 0xFFFF;
		default:
			return 0;
		}
	}

	@Override
	public boolean isCaseSensitive() {
		switch (oid) {
		case Oid.OID:
		case Oid.INT2:
		case Oid.INT4:
		case Oid.INT8:
		case Oid.FLOAT4:
		case Oid.FLOAT8:
		case Oid.NUMERIC:
		case Oid.BOOL:
		case Oid.BIT:
		case Oid.VARBIT:
		case Oid.DATE:
		case Oid.TIME:
		case Oid.TIMETZ:
		case Oid.TIMESTAMP:
		case Oid.TIMESTAMPTZ:
		case Oid.INTERVAL:
			return false;
		default:
			return true;
		}
	}

	@Override
	public boolean isSigned() {
		switch (oid) {
		case Oid.INT2:
		case Oid.INT4:
		case Oid.INT8:
		case Oid.FLOAT4:
		case Oid.FLOAT8:
		case Oid.NUMERIC:
			return true;
		default:
			return false;
		}
	}

	@Override
	public Integer getDisplaySize(int typemod) {
		switch (oid) {
		case Oid.INT2:
			return 6; // -32768 to +32767
		case Oid.INT4:
			return 11; // -2147483648 to +2147483647
		case Oid.OID:
			return 10; // 0 to 4294967295
		case Oid.INT8:
			return 20; // -9223372036854775808 to +9223372036854775807
		case Oid.FLOAT4:
			return 15; // sign + 9 digits + decimal point + e + sign + 2 digits
		case Oid.FLOAT8:
			return 25; // sign + 18 digits + decimal point + e + sign + 3 digits
		case Oid.CHAR:
			return 1;
		case Oid.BOOL:
			return 1;
		case Oid.DATE:
			return 13; // "4713-01-01 BC" to "01/01/4713 BC" - "31/12/32767"
		case Oid.TIME:
		case Oid.TIMETZ:
		case Oid.TIMESTAMP:
		case Oid.TIMESTAMPTZ:
			int secondSize;
			switch (typemod) {
			case -1:
				secondSize = 6 + 1;
				break;
			case 0:
				secondSize = 0;
				break;
			case 1:
				// Bizarrely SELECT '0:0:0.1'::time(1); returns 2 digits.
				secondSize = 2 + 1;
				break;
			default:
				secondSize = typemod + 1;
				break;
			}

			switch (oid) {
			case Oid.TIME:
				return 8 + secondSize;
			case Oid.TIMETZ:
				return 8 + secondSize + 6;
			case Oid.TIMESTAMP:
				return 13 + 1 + 8 + secondSize;
			case Oid.TIMESTAMPTZ:
				return 13 + 1 + 8 + secondSize + 6;
			}
		case Oid.INTERVAL:
			return 49;
		case Oid.VARCHAR:
		case Oid.BPCHAR:
			if (typemod == -1)
				return UNKOWN_LENGTH;
			return typemod - 4;
		case Oid.NUMERIC:
			if (typemod == -1)
				return 131089; // SELECT LENGTH(pow(10::numeric,131071)); 131071
								// = 2^17-1
			int precision = (typemod - 4 >> 16) & 0xffff;
			int scale = (typemod - 4) & 0xffff;
			// sign + digits + decimal point (only if we have nonzero scale)
			return 1 + precision + (scale != 0 ? 1 : 0);
		case Oid.BIT:
			return typemod;
		case Oid.VARBIT:
			if (typemod == -1)
				return UNKOWN_LENGTH;
			return typemod;
		case Oid.TEXT:
		case Oid.BYTEA:
			return UNKOWN_LENGTH;
		default:
			return UNKOWN_LENGTH;
		}
	}

	@Override
	public Integer getMaximumPrecision() {
        switch(oid) {
            case Oid.NUMERIC:
                return 1000;
            case Oid.TIME:
            case Oid.TIMETZ:
                // Technically this depends on the --enable-integer-datetimes
                // configure setting.  It is 6 with integer and 10 with float.
                return 6;
            case Oid.TIMESTAMP:
            case Oid.TIMESTAMPTZ:
            case Oid.INTERVAL:
                return 6;
            case Oid.BPCHAR:
            case Oid.VARCHAR:
                return 10485760;
            case Oid.BIT:
            case Oid.VARBIT:
                return 83886080;
            default:
                return 0;
        }
    }

	@Override
	public boolean requiresQuoting() throws SQLException {
        switch(sqlType) {
            case Types.BIGINT:
            case Types.DOUBLE:
            case Types.FLOAT:
            case Types.INTEGER:
            case Types.REAL:
            case Types.SMALLINT:
            case Types.TINYINT:
            case Types.NUMERIC:
            case Types.DECIMAL:
                return false;
        }
        return true;
    }

}
