import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 서버와 데이터 송수신
 * @author Lee Gwangyong
 *
 */
public class EchoClient{
	
	private int port;			/** 포트 */
	private String serverIP;	/** 서버 주소  */
	private Socket socket;		/** 소켓 객체 */
	private BufferedReader in;	/** 쓰기 스트림 객체 */
	private PrintWriter out;	/** 읽기 스트림 객체 */
	private boolean stop;
	private Scanner keybord;
	
	public EchoClient() throws IOException{
		this("localhost", 7777);
	}
	
	public EchoClient(String serverIP, int port) throws IOException{
		this.serverIP = serverIP;
		this.port = port;
		socket = new Socket(serverIP, port);
		// 소켓과의 데이터 입출력을 위해 메모리스트림 생성(문자스트림)
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		keybord = new Scanner(System.in);
		System.out.println("클라이언트 실행!");
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	/** 서버 연결 소켓연결, in, out 생성 */
	public void connect(){
		
	}
	
	/** 서버 연결 끊기, 연결에서 열어줬던 객체들 닫기*/
	public void disConnect(){
		
	}
	
	/** 메시지 전송 */
	public void messageSend() throws IOException{
		try {
			while(!stop){
				String message = keybord.nextLine();
				out.println(message);
				if (message.equalsIgnoreCase("quit")) break;
				messageReceive();
			}
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
			if (socket != null) socket.close();
		}
	}
	
	/** 서버 메시지 수신 */
	public void messageReceive() throws IOException{
		String serverMessage = in.readLine();
		System.out.println("서버 메시지 : " + serverMessage);
	}
	
	public static void main(String[] args) {
		EchoClient echoClient;
		try {
			echoClient = new EchoClient("localhost",7777);
			echoClient.messageSend();
		} catch (IOException e1) {
			System.out.println("서버를 찾을수 없습니다.");
		}
	}
}
