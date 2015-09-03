package kr.or.kosta.objectstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// ObjectStream을 이용한 데이터 송수신 스레드
public class EchoThread extends Thread {
	Socket socket = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public EchoThread() {
	}

	public EchoThread(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void run() {
		try {
			// 객체 단위로 읽기
			User user = (User) ois.readObject();
			System.out.println("[디버깅] 클라이언트로 부터 읽어들인 객체 : " + user.toString());
			
			// 객체 단위로 쓰기
			oos.writeObject(user);
			oos.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			if(ois != null){try {ois.close();} catch (IOException e) {}}
			if(oos != null){try {oos.close();} catch (IOException e) {}}
			if(socket != null){try {socket.close();} catch (IOException e) {}}
		}
	}

}