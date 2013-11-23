package org.river.sealand.sql.ast;

/**
 * <p>
 * 对应表，视图，子查寻，JOIN(left,right,inner)
 * @author river
 * @since  Nov 23, 2013
 */
public class SqlTabReference implements ISqlStruct {
	
	/**引用*/
	private ISqlStruct ref;
	
	/**别名*/
	private String alias;
	
	/**引用类型*/
	private RefType refType;
	
	
	public ISqlStruct getRef() {
		return ref;
	}

	public void setRef(ISqlStruct ref) {
		this.ref = ref;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public RefType getRefType() {
		return refType;
	}

	public void setRefType(RefType refType) {
		this.refType = refType;
	}

	@Override
	public SqlType getSqlType() {
		return null;
	}

	public static enum RefType{
		TABLE,SUB_SELECT,JOIN;
	}
}
