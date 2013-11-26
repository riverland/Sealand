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
public class SqlSelect implements ISqlStruct {
	/** 返回列 */
	private List<String> selectFields = new ArrayList<String>();

	/** from 子句中的表或子查询 */
	private List<SqlTabReference> fromTbls = new ArrayList<SqlTabReference>();

	/** group by */
	private SqlGroupBy groupBy;

	/** 条件表达式，对应having */
	private SqlBoolExpr having;

	/** 条件表达式，对应where on */
	private SqlBoolExpr criteria;

	/** 查询排序 */
	private SqlSort orderby;

	/** 查询分页 */
	private SqlLimit limit;
	
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

	public List<SqlTabReference> getFromTbls() {
		return fromTbls;
	}

	public void setFromTbls(List<SqlTabReference> fromTbls) {
		this.fromTbls = fromTbls;
	}

	public SqlGroupBy getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(SqlGroupBy groupBy) {
		this.groupBy = groupBy;
	}

	public SqlBoolExpr getHaving() {
		return having;
	}

	public void setHaving(SqlBoolExpr having) {
		this.having = having;
	}

	public SqlBoolExpr getCriteria() {
		return criteria;
	}

	public void setCriteria(SqlBoolExpr criteria) {
		this.criteria = criteria;
	}

	public SqlSort getOrderby() {
		return orderby;
	}

	public void setOrderby(SqlSort orderby) {
		this.orderby = orderby;
	}

	public SqlLimit getLimit() {
		return limit;
	}

	public void setLimit(SqlLimit limit) {
		this.limit = limit;
	}
	
	@Override
	public SqlType getSqlType() {
		return SqlType.SELECT;
	}
}
