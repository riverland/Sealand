package org.river.sealand.node.algorithm;

import java.sql.SQLException;
import java.util.Set;

import org.gpy.fel.common.StringUtils;
import org.river.sealand.node.data.ExprExcutor;
import org.river.sealand.node.task.IFilterAlgorithm;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.data.DataType;
import org.river.sealand.proto.data.MemDataSet;
import org.river.sealand.sql.util.ExprUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 数据集过滤算法实现
 * 
 * @author river
 * @since Dec 10, 2013
 */
public class FilterAlgorithm implements IFilterAlgorithm {
	private static Logger LOG = LoggerFactory.getLogger(FilterAlgorithm.class);

	@Override
	public DataSet filter(DataSet src, String where) {
		DataSet filter = new MemDataSet(src.allColLables());
		
		try {
			while (src.next()) {
				String criteria=this.buildWhere(src, where);
				Boolean flag=(Boolean) ExprExcutor.eval(criteria);
				if(flag){
					filter.addRecord(src.getRecord());
				}
			}
		} catch (SQLException e) {
			LOG.error(e.getLocalizedMessage());
		}
		return filter;
	}

	/*
	 * 替换所有变量
	 * @param src
	 * @param where
	 * @return
	 * @throws SQLException
	 */
	private String buildWhere(DataSet src, String where) throws SQLException {
		String expr = new String(where);
		Set<String> variables = ExprUtils.allVariables(where);
		for (String var : variables) {
			String colLabel = this.trimAlias(var);
			Object data = src.getObject(colLabel);
			String dataStr = null;
			DataType type = src.getDataType(colLabel);
			dataStr = (String) (type == DataType.STRING ? "\"" + data + "\"" : data);
			StringUtils.replace(expr, var, dataStr);
		}
		return expr;
	}

	private String trimAlias(String var) {
		int i = var.indexOf(".");
		return i > 0 ? var.substring(0, i) : var;
	}
}
