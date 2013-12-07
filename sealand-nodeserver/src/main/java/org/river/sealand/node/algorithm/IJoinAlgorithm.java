package org.river.sealand.node.algorithm;

import java.sql.SQLException;

import org.river.sealand.node.data.DataSet;

/**
 * <p>
 * 连接算法接口
 * @author river
 * @since  Dec 7, 2013
 */
public interface IJoinAlgorithm {
	/**
	 * <p>
	 * 连接算法接口
	 * @param left
	 * @param right
	 * @param on
	 * @return
	 * @throws SQLException 
	 */
	public DataSet join(DataSet left,DataSet right,String on) throws SQLException;
}
