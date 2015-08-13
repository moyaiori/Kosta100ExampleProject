import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 원격 클라이언트와 데이터 송수신
 * 
 * @author Lee Gwangyong
 *
 */
public class EchoThread extends Thread {
	
	private Socket socket;	/** 소켓 객체 */
	private BufferedReader in;	/** 쓰기 스트림 객체 */
	private PrintWriter out;	/** 읽기 스트림 객체 */
	private boolean stop;

	public EchoThread(Socket socket) throws IOException {
		this.socket = socket;
		// 소켓과의 데이터 입출력을 위해 메모리스트림 생성(문자스트림)
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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

	public void messageEcho() throws IOException {
		try {
			while (!stop) {
				String clientMessage = in.readLine();
				if (clientMessage.equalsIgnoreCase("quit")) break;
				out.println(clientMessage);
			}
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
			if (socket != null) socket.close();
		}
	}

	@Override
	public void run() {
		try {
			messageEcho();
		} catch (IOException e) {
			System.out.println("클라이언트 강제 종료하여 연결이 종료되었습니다.");
		}
	}

}
