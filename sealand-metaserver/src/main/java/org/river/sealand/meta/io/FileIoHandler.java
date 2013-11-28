package org.river.sealand.meta.io;

import java.io.ByteArrayOutputStream;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 上行文件传输处理器,读取网络数据
 * 
 * @author river
 * @date 20120921
 */
public class FileIoHandler extends IoHandlerAdapter {
	private static final Logger log = LoggerFactory.getLogger(FileIoHandler.class);

	private final static String MSG_CACHE_KEY = "message";

	private String charset;

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		session.setAttribute(MSG_CACHE_KEY, baos);
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
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// 会话结束，把会话文件持久化
		ByteArrayOutputStream baos = (ByteArrayOutputStream) session.getAttribute(MSG_CACHE_KEY);
		String msg = new String(baos.toByteArray(), charset);
		log.info("server receive msg[" + msg + "]");

		super.sessionClosed(session);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		log.warn(cause.getMessage());
		super.exceptionCaught(session, cause);
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
}
