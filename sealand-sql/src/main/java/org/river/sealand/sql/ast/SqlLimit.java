package org.river.sealand.sql.ast;


/**
 * <p>
 * 对应SQL中的limit子句
 * @author river
 * @since  Nov 18, 2013
 */
public class SqlLimit implements ISqlStruct{
	private int start;
	
	private int offset;

	public SqlLimit(int start, int offset) {
		this.start = start;
		this.offset = offset;
	}
	
	public String toString(){
		return Keyword.LIMIT+" "+start+","+offset;
	}

	public int getStart() {
		return start;
	}

	public int getOffset() {
		return offset;
	}
	
	@Override
	public SqlType getSqlType() {
		return SqlType.FRAGMENT;
	}
}
