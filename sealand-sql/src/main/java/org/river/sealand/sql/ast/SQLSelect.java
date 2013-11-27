package org.river.sealand.sql.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * sql select语句
 * 
 * @author river
 * @since Nov 17, 2013
 */
public class SQLSelect implements ISqlStruct {
	/** 返回列 */
	private List<String> selectFields = new ArrayList<String>();

	/** from 子句中的表或子查询 */
	private List<SQLTabReference> fromTbls = new ArrayList<SQLTabReference>();

	/** group by */
	private SQLGroupBy groupBy;

	/** 条件表达式，对应having */
	private SQLBoolExpr having;

	/** 条件表达式，对应where on */
	private SQLBoolExpr criteria;

	/** 查询排序 */
	private SQLSort orderby;

	/** 查询分页 */
	private SQLLimit limit;
	
	private boolean unionAll;

	public boolean isUnionAll() {
		return unionAll;
	}

	public void setUnionAll(boolean unionAll) {
		this.unionAll = unionAll;
	}

	public List<String> getSelectFields() {
		return selectFields;
	}

	public void setSelectFields(List<String> selectFields) {
		this.selectFields = selectFields;
	}

	public List<SQLTabReference> getFromTbls() {
		return fromTbls;
	}

	public void setFromTbls(List<SQLTabReference> fromTbls) {
		this.fromTbls = fromTbls;
	}

	public SQLGroupBy getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(SQLGroupBy groupBy) {
		this.groupBy = groupBy;
	}

	public SQLBoolExpr getHaving() {
		return having;
	}

	public void setHaving(SQLBoolExpr having) {
		this.having = having;
	}

	public SQLBoolExpr getCriteria() {
		return criteria;
	}

	public void setCriteria(SQLBoolExpr criteria) {
		this.criteria = criteria;
	}

	public SQLSort getOrderby() {
		return orderby;
	}

	public void setOrderby(SQLSort orderby) {
		this.orderby = orderby;
	}

	public SQLLimit getLimit() {
		return limit;
	}

	public void setLimit(SQLLimit limit) {
		this.limit = limit;
	}
	
	@Override
	public SqlType getSqlType() {
		return SqlType.SELECT;
	}
}
