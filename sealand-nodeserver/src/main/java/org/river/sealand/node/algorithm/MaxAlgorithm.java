package org.river.sealand.node.algorithm;

import java.util.List;

import org.river.sealand.node.data.DataType;

/**
 * <p>
 * 最大值计算 该类非线程安全
 * 
 * @author river
 * @since Dec 10, 2013
 */
public class MaxAlgorithm implements IAggregateAlgorithm {

	private Object maxValue;

	@Override
	public String getResult() {
		return null;
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
				String min = (String) maxValue;
				if (min.compareTo((String) tmp) < 0) {
					maxValue = tmp;
				}
				break;
			}
			case INT: {
				Long min = (Long) maxValue;
				Long cp = Long.valueOf(tmp.toString());
				if (min < cp) {
					maxValue = cp;
				}
			}
			case FLOAT: {
				Double min = (Double) maxValue;
				Double cp = Double.valueOf(tmp.toString());
				if (min < cp) {
					maxValue = cp;
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
				String min = (String) maxValue;
				if (min.compareTo((String) tmp) > 0) {
					maxValue = tmp;
				}
				break;
			}
			case INT: {
				Long min = (Long) maxValue;
				Long cp = Long.valueOf(tmp.toString());
				if (min > cp) {
					maxValue = cp;
				}
			}
			case FLOAT: {
				Double min = (Double) maxValue;
				Double cp = Double.valueOf(tmp.toString());
				if (min > cp) {
					maxValue = cp;
				}
			}
			}
		}
	}

}
