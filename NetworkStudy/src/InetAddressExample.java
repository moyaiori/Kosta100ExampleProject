import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 통해 도메인 네임(Domain name) < - > IP 변환
 * @author Lee Gwangyong
 *
 */
public class InetAddressExample {

	public static void main(String[] args) {
//		String domainName = "www.google.co.kr";
		String domainName = "www.msn.com";
//		String domainName = "www.google.com";
//		String domainName = "www.naver.com";
		try {
			InetAddress ia = InetAddress.getByName(domainName);
			String ip = ia.getHostAddress();
//			System.out.println(ip);
			
			// 멀티서버인 경우
			InetAddress[] ias = InetAddress.getAllByName(domainName);
			for (InetAddress inetAddress : ias) {
				System.out.println(inetAddress.getHostAddress());
			}
			
			// 내컴퓨터
			System.out.println(InetAddress.getLocalHost());
			
		} catch (UnknownHostException e) {
			System.out.println("서버를 연결할 수 없습니다.");
		}

	}

}
