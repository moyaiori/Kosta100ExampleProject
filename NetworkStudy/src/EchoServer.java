import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 서버 애플리케이션 클래스
 * @author Lee Gwangyong
 *
 */
public class EchoServer {
	private int port;
	private boolean stop = false;
	private ServerSocket serverSocket;

	public EchoServer() throws IOException {
		this(7777);
	}

	public EchoServer(int port){
		this.port = port;
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
	
	//------------- 사용자 정의 메서드 ------------
	
	/** 서버 구동 
	 * @throws IOException */
	public void startUp() throws IOException{
		serverSocket = new ServerSocket(port);
	}
	
	/** 서버 종료 
	 * @throws IOException */
	public void shutDown() throws IOException{
		if (serverSocket != null) serverSocket.close();
	}
	
	/** 클라이언트 연결 수신 
	 * @throws IOException */
	public void connectListening() throws IOException{
		while (!stop) {
			Socket socket = serverSocket.accept(); // 블락 메서드
			InetAddress ia = socket.getInetAddress();
			System.out.println(ia.getHostAddress() + " : 클라이언트가 연결해옴...");
			
			EchoThread echoThread = new EchoThread(socket);
			echoThread.start();
		}
	}
	
	public static void main(String[] args) {
		EchoServer echoServer = new EchoServer(7777);
		
		try {
			echoServer.startUp();
			System.out.println("EchoServer [ " + echoServer.getPort() +" ] StartUp");
			echoServer.connectListening();
		} catch (IOException e) {
			System.out.println("아래와 같은 예외가 발생하여 서버를 구동할 수 없습니다.");
			System.out.println(e.toString());
		}
	}

}















