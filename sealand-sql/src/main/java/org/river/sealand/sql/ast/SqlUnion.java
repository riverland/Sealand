package org.river.sealand.sql.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 对应于SQL中的UNION
 * 
 * @author river
 * @since Nov 22, 2013
 */
public class SqlUnion implements ISqlStruct {
	private List<SqlSelect> selectList = new ArrayList<SqlSelect>();

	public List<SqlSelect> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<SqlSelect> selectList) {
		this.selectList = selectList;
	}
	
	public void addSelect(SqlSelect select){
		this.selectList.add(select);
	}

	@Override
	public SqlType getSqlType() {
		return null;
	}

}
