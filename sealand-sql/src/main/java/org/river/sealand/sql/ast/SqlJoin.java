package org.river.sealand.sql.ast;

/**
 * <p>
 * JOIN(left,right,inner)
 * 
 * @author river
 * @since Nov 23, 2013
 */
public class SqlJoin implements ISqlStruct {

	/** 连接左表 */
	private SqlTabReference left;

	/** 连接右表 */
	private SqlTabReference right;

	/** 连接类型 */
	private JoinType joinType;
	
	/**连接条件*/
	private SqlBoolExpr on;

	public SqlBoolExpr getOn() {
		return on;
	}

	public void setOn(SqlBoolExpr on) {
		this.on = on;
	}

	public SqlTabReference getLeft() {
		return left;
	}

	public void setLeft(SqlTabReference left) {
		this.left = left;
	}

	public SqlTabReference getRight() {
		return right;
	}

	public void setRight(SqlTabReference right) {
		this.right = right;
	}

	public JoinType getJoinType() {
		return joinType;
	}

	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}

	@Override
	public SqlType getSqlType() {
		// TODO Auto-generated method stub
		return null;
	}

	public static enum JoinType {
		INNER, LEFT, RIGHT;
	}

}
