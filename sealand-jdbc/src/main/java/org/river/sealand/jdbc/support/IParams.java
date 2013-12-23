package org.river.sealand.jdbc.support;

/**
 * <p>
 * 参数
 * 
 * @author river
 * @since Dec 23, 2013
 */
public interface IParams {
	
    /**
     * <p>
     * 获取参数数量
     * @return
     */
    public int getParamCount();
    
    /**
     * <p>
     * 获取输入参数项
     * @return
     */
    public int getInParamCount();

    /**
     * <p>
     * 获取输出参数项
     * @return
     */
    public int getOutParameterCount();
    
    /**
     * <p>
     * 获取参数
     * @param index
     * @return
     */
    public ParamItem getParameter(int index);
    
    /**
     * <p>
     * 设置参数
     * @param index
     * @param param
     */
    public void setParameter(int index,ParamItem param);
    
    /**
     * <p>
     * 添加参数
     * @param param
     */
    public void add(ParamItem param);
    
    /**
     * <p>
     * 删除参数
     * @param param
     */
    public void remove(ParamItem param);

	/**
	 * <p>
	 * 参数项
	 * @author river
	 * @since  Dec 23, 2013
	 */
	public static class ParamItem {
		public SqlDataType dataType;
		
		public ParamType paramType;
		
		public String value;

	}

	/**
	 * <p>
	 * 参数类型
	 * 
	 * @author river
	 * @since Dec 23, 2013
	 */
	public static enum ParamType {
		IN, OUT, IN_OUT;
	}
}
