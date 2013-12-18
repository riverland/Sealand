package org.river.sealand.node.algorithm;

import java.util.List;

import org.river.sealand.proto.data.DataType;

/**
 * <p>
 * 计数,执行聚合中的sum运算
 * 
 * @author river
 * @since Dec 10, 2013
 */
public class SumAlgorithm implements IAggregateAlgorithm {

	private Object sumValue;

	@Override
	public String getResult() {
		return sumValue.toString();
	}

	@Override
	public void addSrcData(DataType dataType, List<Object> datas) {
		if (datas == null || datas.isEmpty()) {
			return;
		}

		// TODO 现在只处理数据类型和字符串类型
		for (Object tmp : datas) {
			switch (dataType) {
			case INT: {
				Long sum = (Long) sumValue;
				Long cp = Long.valueOf(tmp.toString());
				sumValue = sum + cp;
			}
			case FLOAT: {
				Double sum = (Double) sumValue;
				Double cp = Double.valueOf(tmp.toString());
				sumValue = sum + cp;
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
			case INT: {
				Long sum = (Long) sumValue;
				Long cp = Long.valueOf(tmp.toString());
				sumValue = sum + cp;
			}
			case FLOAT: {
				Double sum = (Double) sumValue;
				Double cp = Double.valueOf(tmp.toString());
				sumValue = sum + cp;
			}
			}
		}
	}

}
