import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

/**
 * 파일의 데이터를 버퍼(byte[]) 단위로 읽어 들이기...
 * 문자 디코딩
 * @author Lee Gwangyong
 *
 */
public class InputStreamExample3 {

	public static void main(String[] args) {
		String filePath = "I:/KOSTA100/workspace/IOStudy/src/InputStreamExample.java";
		InputStream in = null;
		
		try {
			in = new FileInputStream(filePath);
//			int data = in.read();
			/*
			int data = 0;
			
			while((data=in.read()) != -1){
				System.out.print((char)data);
			}
			*/
			
			/*
			
			int count = 0;
			byte[] buffer = new byte[1024];
			
			while((count=in.read(buffer)) != -1){
				// 현재 OS가 사용하는 문자셋(MS949)에 따라 문자 디코딩
				String txt = new String(buffer, 0, count);
//				String txt = new String(buffer);
				System.out.println(txt);
			}
			
			*/

			int count = 0;
			byte[] buffer = new byte[in.available()];
			count = in.read(buffer);
			// 현재 OS가 사용하는 문자셋(MS949)에 따라 문자 디코딩
//			String txt = new String(buffer, 0, count);
			String txt = new String(buffer);
			System.out.println(txt);
			
			
			
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
