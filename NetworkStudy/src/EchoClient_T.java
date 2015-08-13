import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 전송계층과의 데이터 입출력 담당
 * @author 김기정
 */
public class EchoClient_T {
	private String serverIP;
	private int port;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean stop;
	
	public EchoClient_T(){
		this("localhost", 7777);
	}
	public EchoClient_T(String serverIP, int port){
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
	
	/** 서버 연결 */
	public void connect() throws UnknownHostException, IOException{
		socket = new Socket(serverIP, port);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	/** 서버 연결 끊기 */
	public void disConnect(){
		try {
			if(in != null)	in.close();
			if(out != null)	out.close();
			if(socket != null)	socket.close();
		} catch (IOException e) {}
	}
	
	/** 메시지 전송 */
	public void sendMessage(String message){
		out.println(message);
	}
	
	/** 메시지 수신 */
	public String receiveMessage() throws IOException{
		return in.readLine();
	}
	
	public static void main(String[] args) throws UnknownHostException {
		EchoClient_T echoClient = new EchoClient_T();
		try {
			echoClient.connect();
			System.out.println("EchoServer["+echoClient.getPort()+"] Connected.....");
			
			Scanner keyboard = new Scanner(System.in);
			while(!echoClient.isStop()){
				String message = keyboard.nextLine();
				// 서버에 메시지 전송
				echoClient.sendMessage(message);
				if(message.equalsIgnoreCase("quit")){
					break;
				}
				
				// 서버로부터 메시지 수신
				String serverMessage = echoClient.receiveMessage();
				System.out.println("[서버 메시지] : " + serverMessage);
			}
			
		} catch (IOException e) {
			System.out.println("아래와 같은 예외가 발생하여 서버와 연결할 수 없습니다.");
			System.out.println(e.toString());
		}finally{
			echoClient.disConnect();
		}

	}
}












