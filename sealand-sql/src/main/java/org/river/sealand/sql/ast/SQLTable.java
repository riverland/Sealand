package org.river.sealand.sql.ast;

public class SQLTable implements ISqlStruct {
	
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public SqlType getSqlType() {
		
		return SqlType.TABLE;
	}

}
