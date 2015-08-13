package ko.or.kosta.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import kr.or.kosta.chat.common.MessageType;

/**
 * 전송계층과의 데이터 입출력 담당
 * 
 * @author 김기정
 */
public class ChatClient {
	private String serverIP;
	private int port;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private boolean stop;

	private ChatUI ui;

	public ChatClient() {
		this("localhost", 7777);
	}

	public ChatClient(String serverIP, int port) {
		this.serverIP = serverIP;
		this.port = port;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public ChatUI getUi() {
		return ui;
	}

	public void setUi(ChatUI ui) {
		this.ui = ui;
	}

	/** 서버 연결 */
	public void connect() throws UnknownHostException, IOException {
		socket = new Socket(serverIP, port);
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream((socket.getInputStream()));
	}

	/** 서버 연결 끊기 */
	public void disConnect() {
		try {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
			if (socket != null)
				socket.close();
		} catch (IOException e) {}
	}

	/**
	 * 메시지 전송
	 * 
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);
	}

	/** 메시지 수신 */
	public void receiveMessage() throws IOException {
		new Thread() {
			@Override
			public void run() {
				while (!stop) {
					try {
						String responseMessage = in.readUTF();
						System.out.println("[Debug] 서버메시지 : " + responseMessage);
						String[] tokens =  responseMessage.split(MessageType.DELIMETER);
						String messageCode = tokens[0];
						String messageSender = tokens[1];
						switch (messageCode) {
						case MessageType.SC_CONNECT: // 최초 접속 메시지
							ui.setMessage("♥♥♥ "+messageSender+"님이 최초 연결하였습니다. ♥♥♥");
							break;
						case MessageType.SC_CHAT: // 채팅메시지
							String chatMessage = tokens[2];
							ui.setMessage("["+ messageSender +"] :" + chatMessage);
							break;
						case MessageType.SC_DISCONNECT: // 종료 메시지
							ui.setMessage("♡♡♡ "+messageSender+"님이 연결을 종료하셨습니다. ♡♡♡");
							break;

						default:
							break;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
