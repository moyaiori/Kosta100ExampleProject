package ko.or.kosta.chat.server;

import java.io.IOException;
/**
 * 채팅 서버 애플리케이션 클래스
 * @author Lee Gwangyong
 *
 */
public class KotalkServer {
	public static void main(String[] args) {
		ChatServer server = new ChatServer(7777);

		try {
			server.startUp();
			System.out.println("KotalkServer [ " + server.getPort() + " ] StartUp");
			server.connectListening();
		} catch (IOException e) {
			System.out.println("[Debug] : 아래와 같은 예외가 발생하여 서버를 구동할 수 없습니다.");
			System.out.println(e.toString());
		}
	}
}
