package org.river.sealand.metainfo;

import org.river.sealand.sql.ast.ISqlStruct;

/**
 * <p>
 * 元数据统计服务接口
 * @author river
 * @since  Nov 27, 2013
 */
public interface IStatisticService {
	
	/**
	 * <p>
	 * 计算sql执行开销
	 * @param sql 可在单独数据节点执行的sql
	 * @return
	 */
	public int calcCost(ISqlStruct sql);
	
	
}
