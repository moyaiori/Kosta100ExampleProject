import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

/**
 * 파일의 데이터를 버퍼(byte[]) 단위로 읽어 들이기...
 * @author Lee Gwangyong
 *
 */
public class InputStreamExample2 {

	public static void main(String[] args) {
		String filePath = "I:/KOSTA100/설치프로그램/epp370_64bit.exe";
		InputStream in = null;
		
		try {
			in = new FileInputStream(filePath);
			
			// 버퍼(계란판) 생성, 4~6kb가 최적화
			byte[] buffer = new byte[4*1024];
//			int count = in.read(buffer);
			/*
			for (byte b : buffer) {
				System.out.println(b);
			}*/
			
			int count = 0;
			/*
			while((count = in.read(buffer)) != -1){
				System.out.println(".");
			}*/
			
			while((count = in.read(buffer, 0, buffer.length)) != -1){
				System.out.println(".");
			}
			System.out.println("end of file");
			
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
