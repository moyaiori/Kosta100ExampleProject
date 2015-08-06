import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

/**
 * 파일의 데이터를 1바이트씩 읽어 들이기...
 * @author Lee Gwangyong
 *
 */
public class InputStreamExample {

	public static void main(String[] args) {
		String filePath = "I:/KOSTA100/설치프로그램/epp370_64bit.exe";
		InputStream in = null;
		
		try {
			in = new FileInputStream(filePath);
			int fileLength = in.available();
			System.out.println(fileLength);
//			int data = in.read();
//			System.out.println(data);
//			System.out.println(Integer.toBinaryString(data));
			
			int data = 0;
			int totalByte = 0;
			
			while((data = in.read()) != -1){
//				System.out.println(data);
				totalByte++;
			}
			System.out.println(in.available());
			System.out.println(totalByte + "바이트 파일 데이터 입력 완료");
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "읽고자 하는 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "입출력 에러가 발생하였습니다.");
		} finally {
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
