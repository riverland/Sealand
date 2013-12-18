package org.river.sealand.node.algorithm;

import java.util.List;
import java.util.Map;

import org.river.sealand.proto.data.DataSet;

/**
 * <p>
 * 分组算法
 * @author river
 * @since  Dec 8, 2013
 */
public interface IGroupAlgorithm {
	/**
	 * 分组
	 * @param dataSet
	 * @return
	 */
	public Map<String,DataSet> groupBy(DataSet dataSet,List<String> groupBy);
}
