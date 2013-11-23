package org.river.sealand.sql.ast;


/**
 * <p>
 * 对应sql中的{@code group by}
 * @author river
 * @since  Nov 18, 2013
 */
public class SqlGroupBy implements ISqlStruct{
	private String[] fields;

	public SqlGroupBy(String[] fields) {
		this.fields = fields;
	}
	
	@Override
	public String toString(){
		StringBuffer sb=new StringBuffer(Keyword.GROUP_BY);
		sb.append(" ");
		final String comma=",";
		boolean firstFlag=true;
		for(String tmp:fields){
			if(!firstFlag){
				sb.append(comma);
			}else{
				firstFlag=false;
			}
			
			sb.append(tmp);
		}
		return sb.toString();
	}
	
	@Override
	public SqlType getSqlType() {
		return SqlType.GROUP_BY;
	}
	
}
