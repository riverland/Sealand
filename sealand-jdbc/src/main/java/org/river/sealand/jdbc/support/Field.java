package org.river.sealand.jdbc.support;

import java.sql.ResultSetMetaData;

import org.river.sealand.proto.Type;

/**
 * <p>
 * 一个表格列的元数据定义
 * 
 * @author river
 * @since Jan 4, 2014
 */
public class Field {
	public static final int FORMAT_TEXT = 1;
	public static final int FORMAT_BIN = 5;
	/** label */
	private String label;

	/** 所属的表名 */
	private String tableName = "";

	/** 所属的schema */
	private String schemaName = "";

	/** 列名 */
	private String columnName;

	/** 数据类型 */
	private Type type;

	/** 数据库中列长度 */
	private int length;

	/** 在表中的列位置 */
	private int posIndexInTable;

	/** 数据格式 */
	private int format;

	/** 是否可为null值 */
	private int nullable = ResultSetMetaData.columnNullableUnknown;

	/** 是否自增长 */
	private boolean autoIncrement = false;

	public int getFormat() {
		return format;
	}

	public void setFormat(int format) {
		this.format = format;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public int getPosIndexInTable() {
		return posIndexInTable;
	}

	public void setPosIndexInTable(int posIndexInTable) {
		this.posIndexInTable = posIndexInTable;
	}

	public int getNullable() {
		return nullable;
	}

	public void setNullable(int nullable) {
		this.nullable = nullable;
	}

	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

}
