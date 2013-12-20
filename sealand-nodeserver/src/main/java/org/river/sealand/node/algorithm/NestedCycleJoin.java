package org.river.sealand.node.algorithm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.gpy.fel.common.StringUtils;
import org.river.sealand.node.data.ExprExcutor;
import org.river.sealand.proto.data.DataSet;
import org.river.sealand.proto.data.DataType;
import org.river.sealand.proto.data.MemDataSet;
import org.river.sealand.sql.util.ExprUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 嵌套循环连接算法
 * 
 * @author river
 * @since Dec 7, 2013
 */
public class NestedCycleJoin implements IJoinAlgorithm {
	private static final Logger LOG = LoggerFactory.getLogger(NestedCycleJoin.class);

	@Override
	public DataSet join(DataSet left, DataSet right, String on) throws SQLException{
		List<String> lables = new ArrayList<String>();
		lables.addAll(left.allColLables());
		lables.addAll(right.allColLables());
		DataSet joinSet = new MemDataSet(lables);
		
		Set<String> variables = ExprUtils.allVariables(on);	
		try{
			while (left.next()) {
				while (right.next()) {
					String expr = this.buildOn(left, right, variables, on);
					Boolean bool = (Boolean) ExprExcutor.eval(expr);
					if (bool) {
						String leftRec=left.getRecord();
						String rightRec=right.getRecord();					
						joinSet.addRecord(leftRec+"\t"+rightRec);
					}
				}
			}
		}catch(SQLException e){
			LOG.error(e.getLocalizedMessage());
			throw e;
		}
		
		return joinSet;
	}

	/*
	 * 替换所有变量
	 * 
	 * @param left
	 * 
	 * @param right
	 * 
	 * @param variables
	 * 
	 * @param on
	 * 
	 * @return
	 * 
	 * @throws SQLException
	 */
	private String buildOn(DataSet left, DataSet right, Set<String> variables, String on) throws SQLException {
		String expr = new String(on);
		for (String var : variables) {
			DataSet varIn = this.getDataSet(var, left, right);
			String colLabel = this.trimAlias(var);
			Object data = varIn.getObject(colLabel);
			String dataStr = null;
			DataType type = varIn.getDataType(colLabel);
			dataStr = (String) (type == DataType.STRING ? "\"" + data + "\"" : data);
			StringUtils.replace(expr, var, dataStr);
		}
		return expr;
	}

	/*
	 * 
	 * 判断变量var所在的数据集
	 * 
	 * @param var
	 * 
	 * @param args
	 * 
	 * @return
	 */
	private DataSet getDataSet(String var, DataSet... args) {
		int i = var.indexOf(".");
		if (i > 0) {
			var = var.substring(0, i);
			for (DataSet tmp : args) {
				if (var.equalsIgnoreCase(tmp.getAlias())) {
					return tmp;
				}
			}
		} else {
			for (DataSet tmp : args) {
				List<String> labels = tmp.allColLables();
				for (String lbl : labels) {
					if (lbl.equalsIgnoreCase(var)) {
						return tmp;
					}
				}
			}
		}

		return null;
	}

	private String trimAlias(String var) {
		int i = var.indexOf(".");
		return i > 0 ? var.substring(0, i) : var;
	}
}
