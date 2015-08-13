package ko.or.kosta.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import kr.or.kosta.chat.common.MessageType;

/**
 * 채팅 클라이언트와 요청 메시지를 수신하여 서비스를 제공
 * 
 * @author Lee Gwangyong
 *
 */
public class ChatService extends Thread {

	private Socket socket;
	/** 소켓 객체 */
	private DataInputStream in;
	/** 쓰기 스트림 객체 */
	private DataOutputStream out;
	/** 읽기 스트림 객체 */
	private boolean stop;

	private String nicName; // 사용자 대화명
	private ChatServer chatServer;

	public ChatService(ChatServer chatServer, Socket socket) throws IOException {
		this.socket = socket;
		this.chatServer = chatServer;
		// 소켓과의 데이터 입출력을 위해 메모리스트림 생성(문자스트림)
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream((socket.getInputStream()));
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

	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}

	/**
	 * 채팅클라이언트의 요청메시지 파싱 및 서비스
	 * 
	 * @throws IOException
	 */
	public void handleRequset() throws IOException {
		try {
			while (!stop) {
				String requestMessage = in.readUTF();
				System.out.println("[Debug] : 클라이언트 요청 메시지" + requestMessage);
				String[] tokens = requestMessage.split(MessageType.DELIMETER);
				String messageCode = tokens[0];
				nicName = tokens[1];

				switch (messageCode) {
				case MessageType.SC_CONNECT: // 최초 접속 메시지
					// 서버에 등록
					chatServer.addClient(this);
					// 접속한 모든 클라이언트에게 통보
					chatServer.sendAllMessage(requestMessage);
//					chatServer.setUserList();
					break;
				case MessageType.SC_CHAT: // 채팅메시지
					// 접속한 모든 클라이어느에게 보내기
					chatServer.sendAllMessage(requestMessage);
					break;
				case MessageType.SC_DISCONNECT: // 종료 메시지
					chatServer.removeClient(this);
					chatServer.sendAllMessage(requestMessage);
					return;
				}
			}
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
			if (socket != null)
				socket.close();
		}
	}

	/**
	 * 요청 클라이언트에게 메시지 전송
	 * 
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);
	}
	
	public void sendUserList(List<String> list){
	}

	@Override
	public void run() {
		try {
			handleRequset();
		} catch (IOException e) {
			System.out.println("[Debug] : 클라이언트 강제 연결 종료되었습니다.");
		}
	}

}
