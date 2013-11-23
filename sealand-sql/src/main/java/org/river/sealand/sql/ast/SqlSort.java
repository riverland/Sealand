package org.river.sealand.sql.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 对应sql中的order by
 * 
 * @author river
 * @since Nov 18, 2013
 */
public class SqlSort implements ISqlStruct {
	private List<Entry> orderbys = new ArrayList<Entry>();

	/**
	 * <p>
	 * 按照field升序
	 * 
	 * @param field
	 * @return
	 */
	public SqlSort asc(String field) {
		Entry ent = new Entry(field, Type.ASC);
		orderbys.add(ent);
		return this;
	}

	/**
	 * <p>
	 * 按照field降序
	 * 
	 * @param field
	 * @return
	 */
	public SqlSort desc(String field) {
		Entry ent = new Entry(field, Type.DESC);
		orderbys.add(ent);
		return this;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(Keyword.ORDER_BY);
		sb.append(" ");
		boolean firstFlag = true;
		for (Entry tmp : orderbys) {
			if (!firstFlag) {
				sb.append(",");
			} else {
				firstFlag = false;
			}

			sb.append(tmp.toString());
		}
		return sb.toString();
	}

	public List<Entry> getOrderbys() {
		return orderbys;
	}

	/**
	 * <p>
	 * 
	 * @author river
	 * @since Nov 18, 2013
	 */
	public static class Entry {
		private String field;

		private Type type;

		public Entry(String field, Type type) {
			this.field = field;
			this.type = type;
		}

		public String getField() {
			return field;
		}

		public Type getType() {
			return type;
		}

		@Override
		public String toString() {
			return this.field + " " + this.type.getValue();
		}
	}

	/**
	 * <p>
	 * 排序类型：升序，降序
	 * 
	 * @author river
	 * @since Nov 18, 2013
	 */
	public static enum Type {
		ASC("ASC"), DESC("DESC");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
	
	@Override
	public SqlType getSqlType() {
		return SqlType.FRAGMENT;
	}
}
