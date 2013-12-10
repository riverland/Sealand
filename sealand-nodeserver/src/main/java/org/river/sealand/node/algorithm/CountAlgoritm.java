package org.river.sealand.node.algorithm;

import java.util.List;

import org.river.sealand.node.data.DataType;

/**
 * <p>
 * 计数,执行聚合中的count运算
 * 
 * @author river
 * @since Dec 10, 2013
 */
public class CountAlgoritm implements IAggregateAlgorithm {

	private Long count = 0l;

	@Override
	public String getResult() {
		return count.toString();
	}

	@Override
	public void addSrcData(DataType dataType, List<Object> datas) {
		if (datas == null) {
			return;
		}
		count = count + datas.size();
	}

	@Override
	public void addSrcData(DataType dataType, Object... datas) {
		if (datas == null) {
			return;
		}
		count = count + datas.length;
	}

}
