import java.io.IOException;
import java.net.ServerSocket;

/**
 * Socket을 이용한 포트스캐너
 * @author 김기정
 *
 */
public class PortScnner {

	public static void main(String[] args) {
		// TODO 차후 statc 메소드로 구현하여 사용
		//InetAddress localhost = InetAddress.getLocalHost();
		for(int i=0; i<65537; i++){
			//Socket socket = new Socket("localhost", i);			
			try {
//				Socket socket = new Socket("127.0.0.1", i);
				ServerSocket ss = new ServerSocket(i);
				System.out.println(i + "포트는 미사용중....");
				ss.close();
			} catch (IOException e) {
				System.out.println(i + "포트는 사용중입니다..");
			}			
		}

	}

}







