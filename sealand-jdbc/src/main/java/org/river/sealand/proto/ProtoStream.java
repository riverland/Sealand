package org.river.sealand.proto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.river.sealand.utils.CloseUtils;
import org.river.sealand.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 协议数据收发，实际Socket连接的管理
 * 
 * @author river
 * @since Dec 23, 2013
 */
public class ProtoStream implements IProtoStream {
	private static final Logger log = LoggerFactory.getLogger(ProtoStream.class);
	// 连接信息
	private String host;
	private int port;
	private int sotimeout;
	private boolean keepTcpAlive;

	// 连接状态
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private Queue<Message> msgQueue = new LinkedBlockingQueue<Message>();
	private ReceiveThread rcvThread;

	public ProtoStream(String host, int port) throws IOException {
		this.host = host;
		this.port = port;
		this.initialize();

	}

	public ProtoStream(String host, int port, int sotimeout, boolean keepTcpAlive) throws IOException {
		this.host = host;
		this.port = port;
		this.sotimeout = sotimeout;
		this.keepTcpAlive = keepTcpAlive;
		this.initialize();
	}

	/*
	 * 初始化
	 */
	private void initialize() throws IOException {
		this.doConnect();
		this.doReceive();
	}

	/*
	 * 启动接受线程
	 */
	private void doReceive() {
		rcvThread = new ReceiveThread();
		rcvThread.start();
	}

	/*
	 * 连接
	 */
	private void doConnect() throws IOException {

		try {
			socket = new Socket();
			SocketAddress endpoint = new InetSocketAddress(this.host, this.port);
			socket.connect(endpoint);
			if (sotimeout != 0) {
				socket.setSoTimeout(sotimeout);
				socket.setKeepAlive(keepTcpAlive);
			}

			input = new BufferedInputStream(socket.getInputStream());
			output = new BufferedOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			throw new IOException(e);
		}

	}

	@Override
	public void close() {
		this.rcvThread.close();
		CloseUtils.close(input);
		CloseUtils.close(output);
		CloseUtils.close(socket);
	}

	@Override
	public void send(byte[] data) throws IOException {
		output.write(data);
	}

	@Override
	public void send(byte[] data, int start, int length) throws IOException {
		output.write(data, start, length);
	}

	@Override
	public Message receive() {
		return msgQueue.poll();
	}

	/**
	 * <p>
	 * 数据收取线程
	 * 
	 * @author river
	 * @since Dec 25, 2013
	 */
	private class ReceiveThread extends Thread {
		private boolean isAlive = true;

		private void close() {
			isAlive = false;
		}

		@Override
		public void run() {
			try {
				while (isAlive) {
					byte[] lenByte = this.readMsgData(MSGConstant.KEY_LEN_WIDTH);
					int len = NumberUtils.readInt4(lenByte);
					byte[] data = this.readMsgData(len - MSGConstant.KEY_LEN_WIDTH);
					Message msg = new Message();
					msg.setLength(len);
					msg.setData(data);
					Message.Type type = Message.Type.fromValue((char) data[0]);
					msg.setType(type);
					msgQueue.offer(msg);
				}
			} catch (Exception e) {
				log.error(e.getLocalizedMessage());
				close();
			}

		}

		/*
		 * 读取一定长度的数据
		 * 
		 * @param len
		 * 
		 * @return
		 */
		private byte[] readMsgData(int len) throws IOException {
			byte[] data = new byte[len];

			int pos = 0;
			while (pos < len) {
				int i = input.read(data, pos, len - pos);
				pos = +i;
			}

			return data;
		}

	}

}
