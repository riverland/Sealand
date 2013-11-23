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
