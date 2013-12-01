package org.river.sealand.node.io;

import java.io.ByteArrayOutputStream;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
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

	private final static String MSG_CACHE_KEY="message";
	private final static String MSG_LEN_KEY="msg_len";
	private final static String MSG_CUR_LEN_KEY="msg_cur_len";
	private String charset;

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		session.setAttribute(MSG_CACHE_KEY, baos);
		session.setAttribute(MSG_CUR_LEN_KEY, 0);
		super.sessionCreated(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		final int BUFFERED_SIZE = 1024;
		IoBuffer buf = (IoBuffer) message;
		byte[] buffer = new byte[BUFFERED_SIZE];
		ByteArrayOutputStream baos = (ByteArrayOutputStream) session.getAttribute(MSG_CACHE_KEY);
		
		//读取文件，并写入会话缓存
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
		//更新当前长度
		session.setAttribute(MSG_CUR_LEN_KEY, baos.size());
		
		//获取消息长度
		if(session.getAttribute(MSG_LEN_KEY)==null){
			String lenStr="";
			if(NumberUtils.isNumber(lenStr)){
				session.setAttribute(MSG_LEN_KEY, Integer.valueOf(lenStr));
			}else{
				log.error("msg length["+lenStr+"] is not number");
				session.close(true);
				return;
			}			
		}
		
		int curLength=(Integer) session.getAttribute(MSG_CUR_LEN_KEY);
		int msgLength=(Integer) session.getAttribute(MSG_LEN_KEY);
		//读取完数据
		if(curLength>=msgLength){
			this.handleMsg(session);
			session.close(false);
		}
		 
	}


	@Override
	public void exceptionCaught(IoSession session, Throwable cause)throws Exception {
		log.warn(cause.getMessage());
		super.exceptionCaught(session, cause);
	}
	
	/**
	 * <p>
	 * 处理消息
	 * @param msg
	 * @param session
	 */
	private void handleMsg(IoSession session){
		String msg="";
		try {
			ByteArrayOutputStream baos = (ByteArrayOutputStream) session.getAttribute(MSG_CACHE_KEY);
			msg=new String(baos.toByteArray(),charset);
			log.info("server receive msg["+msg+"]");
			
           //TODO handle logic
			
		} catch (Exception e) {
			log.error("handle msg["+msg+"] error",e);
		}
	}
	
	/**
	 * <p>
	 * 回执
	 * @param msg
	 * @param session
	 */
	private void reply(String msg,IoSession session){
		try {
			IoBuffer buffer=IoBuffer.wrap(msg.getBytes(charset));
			buffer.flip();
			session.write(buffer);
		} catch (Exception e) {
			log.error("回执报文["+msg+"]发生异常",e);
		}
	}
	

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
}
