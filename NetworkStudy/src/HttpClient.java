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
 * 웹서버와 HTTP응용프로토콜에 맞춰 데이터를 송수신하는 웹클라이언트
 * @author Lee Gwangyong
 */
public class HttpClient {
	private String serverIP;
	private int port;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean stop;
	
	public HttpClient(){
		this("localhost", 7777);
	}
	public HttpClient(String serverIP, int port){
		this.serverIP = serverIP;
		this.port = port;
	}
	
	public HttpClient(InetAddress serverIP, int port){
		this.serverIP = serverIP.getHostAddress();
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
		StringBuilder sb = new StringBuilder();
		String html = null;
		while((html = in.readLine()) != null){
			sb.append(html + "\r\n");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws UnknownHostException {
//		HttpClient httpClient = new HttpClient(InetAddress.getByName("www.naver.com"), 80);
		HttpClient httpClient = new HttpClient(InetAddress.getByName("localhost"), 80);
//		HttpClient httpClient = new HttpClient(InetAddress.getByName("www.google.com"), 80);
		try {
			httpClient.connect();
			System.out.println("WebServer["+httpClient.getPort()+"] Connected.....");

			// HTTP 프로토콜에 맞게 데이터 송수신
			String requestMessage = "GET /servlet/gugudan HTTP/1.0\r\n" + // 요청라인
									"someName1:someValue\r\n" + 
									"someName2:someValue\r\n" + 
									"someName3:someValue\r\n" + 
									"someName4:someValue\r\n" + 
									"someName5:someValue\r\n\\r\n";
			httpClient.sendMessage(requestMessage);
			String html = httpClient.receiveMessage();
			System.out.println(html);
			
			
		} catch (IOException e) {
			System.out.println("아래와 같은 예외가 발생하여 서버와 연결할 수 없습니다.");
			System.out.println(e.toString());
		}finally{
			httpClient.disConnect();
			System.out.println("WebServer idsConnected...");
		}

	}
}












