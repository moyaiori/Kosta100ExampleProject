import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 특정 파일에 1바이트씩 쓰기...
 * @author Lee Gwangyong
 *
 */
public class OutputStreamExample {

	public static void main(String[] args) throws IOException {
		String filePath = "I:/some.dat";
		
		OutputStream out = new FileOutputStream(filePath);
		
//		int data = 101;
//		out.write(data);
		
		byte[] datas = new byte[128];
		
		for (int i = 0; i < datas.length; i++) {
			datas[i] = (byte)i;
		}
		
		out.write(datas, 0, datas.length);
		
		
		
		out.close();
		System.out.println("1바이트 썻음...");

	}

}
