package org.river.sealand.metainfo;

/**
 * <p>
 * 分片相关服务
 * 
 * @author river
 * @since Nov 28, 2013
 */
public interface IShardingService {
	
	/**
	 * <p>
	 * 获取指定表的分片类型
	 * 
	 * @param tableName
	 * @return
	 */
	public ShardingType getShardingType(String tableName);
	
	
}
