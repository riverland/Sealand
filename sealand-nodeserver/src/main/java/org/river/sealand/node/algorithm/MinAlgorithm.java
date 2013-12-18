package org.river.sealand.node.algorithm;

import java.util.List;

import org.river.sealand.proto.data.DataType;

/**
 * <p>
 * 最小值计算 该类非线程安全
 * 
 * @author river
 * @since Dec 10, 2013
 */
public class MinAlgorithm implements IAggregateAlgorithm {

	private Object minValue;

	@Override
	public String getResult() {
		return minValue.toString();
	}

	@Override
	public void addSrcData(DataType dataType, List<Object> datas) {
		if (datas == null || datas.isEmpty()) {
			return;
		}

		// TODO 现在只处理数据类型和字符串类型
		for (Object tmp : datas) {
			switch (dataType) {
			case STRING: {
				String min = (String) minValue;
				if (min.compareTo((String) tmp) > 0) {
					minValue = tmp;
				}
				break;
			}
			case INT: {
				Long min = (Long) minValue;
				Long cp = Long.valueOf(tmp.toString());
				if (min > cp) {
					minValue = cp;
				}
			}
			case FLOAT: {
				Double min = (Double) minValue;
				Double cp = Double.valueOf(tmp.toString());
				if (min > cp) {
					minValue = cp;
				}
			}
			}
		}

	}

	@Override
	public void addSrcData(DataType dataType, Object... datas) {
		if (datas == null || datas.length == 0) {
			return;
		}

		// TODO 现在只处理数据类型和字符串类型
		for (Object tmp : datas) {
			switch (dataType) {
			case STRING: {
				String min = (String) minValue;
				if (min.compareTo((String) tmp) > 0) {
					minValue = tmp;
				}
				break;
			}
			case INT: {
				Long min = (Long) minValue;
				Long cp = Long.valueOf(tmp.toString());
				if (min > cp) {
					minValue = cp;
				}
			}
			case FLOAT: {
				Double min = (Double) minValue;
				Double cp = Double.valueOf(tmp.toString());
				if (min > cp) {
					minValue = cp;
				}
			}
			}
		}
	}

}
