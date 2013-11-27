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
public class SQLUnion implements ISqlStruct {
	private List<SQLSelect> selectList = new ArrayList<SQLSelect>();

	public List<SQLSelect> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<SQLSelect> selectList) {
		this.selectList = selectList;
	}
	
	public void addSelect(SQLSelect select){
		this.selectList.add(select);
	}

	@Override
	public SqlType getSqlType() {
		return null;
	}

}
