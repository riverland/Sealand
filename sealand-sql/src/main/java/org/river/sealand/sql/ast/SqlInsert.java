package org.river.sealand.sql.ast;


/**
 * <p>
 * 对应sql中的Insert
 * 
 * @author river
 * @since Nov 18, 2013
 */
public class SqlInsert implements ISqlStruct {
	/** 要插入数据的表名 */
	private String tableName;

	/** 列名 */
	private String[] columns;

	/** 插入的值 */
	private String[][] values;

	/** 子查询 */
	private SqlSelect subSelect;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public String[][] getValues() {
		return values;
	}

	public void setValues(String[][] values) {
		this.values = values;
	}

	public SqlSelect getSubSelect() {
		return subSelect;
	}

	public void setSubSelect(SqlSelect subSelect) {
		this.subSelect = subSelect;
	}

	@Override
	public SqlType getSqlType() {
		return SqlType.INSERT;
	}
}
