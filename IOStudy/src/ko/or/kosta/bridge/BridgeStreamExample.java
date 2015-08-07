package ko.or.kosta.bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * 키보드에서 바로 데이터 받아서 처리하기
 * @author Lee Gwangyong
 *
 */
public class BridgeStreamExample {

	public static void main(String[] args) throws IOException {
//		InputStreamReader reader = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(reader);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 : ");
		String name = br.readLine();
		System.out.print(name);
	}

}
