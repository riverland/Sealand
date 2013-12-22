package org.river.sealand.proto;

/**
 * <p>
 * 协议的异步消息
 * @author river
 * @since  Dec 22, 2013
 */
public interface INotification {
    /**
     * <p>
     * 获取消息的名称
     * @return
     */
    public String getName();

    /**
     * <p>
     * 获取statementId
     * @return
     */
    public String getStatementId();

    /**
     * <p>
     * 其他附加参数
     * @return
     */
    public String getParameter();
}
