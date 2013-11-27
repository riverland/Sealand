package org.river.sealand.sql.ast;

/**
 * <p>
 * JOIN(left,right,inner)
 * 
 * @author river
 * @since Nov 23, 2013
 */
public class SQLJoin implements ISqlStruct {

	/** 连接左表 */
	private SQLTabReference left;

	/** 连接右表 */
	private SQLTabReference right;

	/** 连接类型 */
	private JoinType joinType;
	
	/**连接条件*/
	private SQLBoolExpr on;

	public SQLBoolExpr getOn() {
		return on;
	}

	public void setOn(SQLBoolExpr on) {
		this.on = on;
	}

	public SQLTabReference getLeft() {
		return left;
	}

	public void setLeft(SQLTabReference left) {
		this.left = left;
	}

	public SQLTabReference getRight() {
		return right;
	}

	public void setRight(SQLTabReference right) {
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
