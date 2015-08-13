import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * URL 추상화
 * @author Lee Gwangyong
 *
 */
public class URLExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String strUrl = "http://www.naver.com:80/index.html";
		URL url = new URL(strUrl);
		
		//정보제공
//		System.out.println(url.getProtocol());
//		System.out.println(url.getHost());
//		System.out.println(url.getPort());
//		System.out.println(url.getPath());
//		System.out.println(url.getFile());
//		System.out.println(url.getRef());
		
		// 실제 리소스 데이터 읽기...
		InputStream in = url.openStream();
		
		// 스트림 복습
		// 바이트 스트림 사용
		/*
		byte[] buffer = new byte[1024];
		
		int count = 0;
		while((count = in.read(buffer)) != -1){
			// 디코딩 처리
			String html = new String(buffer, 0, count);
			System.out.println(html);
		}
		in.close();
		*/
		
		// 문자 스트림으로 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String html = null;
		while((html = br.readLine()) != null){
			System.out.println(html);
		}
		br.close();
		
		// Swing의 EditPane을 이용한 html 렌더링
		JFrame frame = new JFrame("html 랜더링");
		
		JEditorPane ep = new JEditorPane();
		ep.setPage(strUrl);
		ep.setEditable(false);
		
		frame.add(new JScrollPane(ep), BorderLayout.CENTER);
		
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
	}

}
