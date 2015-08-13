package ko.or.kosta.chat.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import kr.or.kosta.chat.common.MessageType;

/**
 * 채팅 관련 서비스 클라이언트
 * 
 * @author Lee Gwangyong
 *
 */
public class ChatServer {
	private int port;
	private boolean stop = false;
	private ServerSocket serverSocket;

	/** ChatService(접속한 클라이언트)들을 관리하기 위한 Map */
	private Hashtable<String, ChatService> connectedClients;

	public ChatServer() throws IOException {
		this(7777);
	}

	public ChatServer(int port) {
		this.port = port;
		connectedClients = new Hashtable<String, ChatService>();
	}

	/** getter, setter */
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	// ------------- 사용자 정의 메서드 ------------

	/**
	 * 서버 구동
	 */
	public void startUp() throws IOException {
		serverSocket = new ServerSocket(port);
	}

	/**
	 * 서버 종료
	 */
	public void shutDown() throws IOException {
		if (serverSocket != null)
			serverSocket.close();
	}

	/**
	 * 클라이언트 연결 수신
	 */
	public void connectListening() throws IOException {
		while (!stop) {
			Socket socket = serverSocket.accept(); // 블락 메서드
			InetAddress ia = socket.getInetAddress();
			System.out.println("[" + ia.getHostAddress() + "] : 채팅 클라이언트가 연결해옴...");
			ChatService chatService = new ChatService(this, socket);
			chatService.start();
		}
	}

	/** 접속 클라이언트 등록 */
	public void addClient(ChatService client) {
		// TODO 접속한 대화명이 있는지 유효성 검증 필요
		connectedClients.put(client.getNicName(), client);
	}

	/** 종료 클라이언트 제거 */
	public void removeClient(ChatService client) {
		connectedClients.remove(client.getNicName());
	}

	/**
	 * 접속한 모든 클라이언트
	 */
	public void sendAllMessage(String message) throws IOException {
		Enumeration<ChatService> e = connectedClients.elements();
		while (e.hasMoreElements()) {
			ChatService client = e.nextElement();
			client.sendMessage(message);
		}
	}
	
	/** 현재 접속중인 사람들 리스트 셋팅 */
	public void setUserList(){
		Enumeration<String> userName = connectedClients.keys();
		Enumeration<ChatService> userThread = connectedClients.elements();
		
		List<String> list = new ArrayList<String>();
		StringBuilder userList = new StringBuilder();
		
		while (userName.hasMoreElements()) {
			String keys = (String) userName.nextElement();
			userList.append(keys);
			if (userName.nextElement() != null) {
				userList.append(MessageType.DELIMETER);
			}
		}
		System.out.println("userList : " + userList);
		
//		while (userThread.hasMoreElements()) {
//			ChatService client = (ChatService) userThread.nextElement();
//			client.
//			
//		}
	}
}
