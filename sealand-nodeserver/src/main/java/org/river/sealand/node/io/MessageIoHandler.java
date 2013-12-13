package org.river.sealand.node.io;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.river.base.threads.IQueueHandlerManager;
import org.river.sealand.meta.handler.ISyncHandler;
import org.river.sealand.proto.MSGConstant;
import org.river.sealand.proto.MessageUtils;
import org.river.sealand.proto.MsgType;
import org.river.sealand.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 上行报文传输处理器,读取网络数据
 * 
 * @author river
 * @date 20120921
 */
public class MessageIoHandler extends IoHandlerAdapter {
	private static final Logger log = LoggerFactory.getLogger(MessageIoHandler.class);

	private final static String MSG_CACHE_KEY = "0";
	private final static String MSG_LEN_KEY = "1";
	private final static String MSG_CUR_LEN_KEY = "2";
	private String charset;
	private Map<MsgType, ISyncHandler> syncHandlers;
	private IQueueHandlerManager<byte[]> asyncQueue;


	@Override
	public void sessionCreated(IoSession session) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		session.setAttribute(MSG_CACHE_KEY, baos);
		session.setAttribute(MSG_CUR_LEN_KEY, 0);
		super.sessionCreated(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		final int BUFFERED_SIZE = 1024;
		IoBuffer buf = (IoBuffer) message;
		byte[] buffer = new byte[BUFFERED_SIZE];
		ByteArrayOutputStream baos = (ByteArrayOutputStream) session.getAttribute(MSG_CACHE_KEY);

		// 读取文件，并写入会话缓存
		while (buf.hasRemaining()) {
			int remain = buf.remaining();
			if (remain >= BUFFERED_SIZE) {
				buf.get(buffer, 0, BUFFERED_SIZE);
				baos.write(buffer, 0, BUFFERED_SIZE);
			} else if (remain > 0) {
				buf.get(buffer, 0, remain);
				baos.write(buffer, 0, remain);
			}
		}
		// 更新当前长度
		session.setAttribute(MSG_CUR_LEN_KEY, baos.size());

		// 获取消息长度
		if (session.getAttribute(MSG_LEN_KEY) == null) {
			byte[] lenBytes = Arrays.copyOf(baos.toByteArray(), MSGConstant.MSG_LEN_BYTE_NUM);
			session.setAttribute(MSG_LEN_KEY, NumberUtils.readInt4(lenBytes));
		}

		int curLength = (Integer) session.getAttribute(MSG_CUR_LEN_KEY);
		int msgLength = (Integer) session.getAttribute(MSG_LEN_KEY);
		// 读取完数据
		if (curLength >= msgLength) {
			this.handleMsg(session);
		}

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		log.warn(cause.getMessage());
		super.exceptionCaught(session, cause);
	}

	/**
	 * <p>
	 * 处理消息
	 * 
	 * @param msg
	 * @param session
	 */
	private void handleMsg(IoSession session) {
		try {
			ByteArrayOutputStream baos = (ByteArrayOutputStream) session.getAttribute(MSG_CACHE_KEY);
			
			int curLength = (Integer) session.getAttribute(MSG_CUR_LEN_KEY);
			int msgLength = (Integer) session.getAttribute(MSG_LEN_KEY);			
			byte[] cacheBytes = baos.toByteArray();
			byte[] msg = Arrays.copyOf(cacheBytes, msgLength);
			if (curLength > msgLength) {
				session.setAttribute(MSG_LEN_KEY, null);
				baos = new ByteArrayOutputStream();
				baos.write(Arrays.copyOfRange(cacheBytes, msgLength, curLength - 1));
			}

			MsgType msgType = MessageUtils.parseMsgType(msg);
			ISyncHandler syncHandler = syncHandlers.get(msgType);
			if (syncHandler != null) {
				this.reply(syncHandler.handle(msg), session);
			}else{
				this.asyncQueue.addData(msg);
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * <p>
	 * 回执
	 * 
	 * @param msg
	 * @param session
	 */
	private void reply(byte msg[], IoSession session) {
		try {
			IoBuffer buffer = IoBuffer.wrap(msg);
			buffer.flip();
			session.write(buffer);
		} catch (Exception e) {
			log.error("回执报文[" + msg + "]发生异常", e);
		}
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Map<MsgType, ISyncHandler> getSyncHandlers() {
		return syncHandlers;
	}

	public void setSyncHandlers(Map<MsgType, ISyncHandler> syncHandlers) {
		this.syncHandlers = syncHandlers;
	}

	public IQueueHandlerManager<byte[]> getAsyncQueue() {
		return asyncQueue;
	}

	public void setAsyncQueue(IQueueHandlerManager<byte[]> asyncQueue) {
		this.asyncQueue = asyncQueue;
	}
}
