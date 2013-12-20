package org.river.sealand.proto;

/**
 * <p>
 * 消息工具类
 * 
 * @author river
 * @since Dec 12, 2013
 */
public class MessageUtils {

	/**
	 * <p>
	 * 获取消息类型
	 * 
	 * @param msg
	 * @return
	 */
	public static MsgType parseMsgType(byte[] msg) {
		char type = (char) msg[MSGConstant.MSG_TYPE_BYTE_INDEX];
		return MsgType.fromValue(type);
	}
}
