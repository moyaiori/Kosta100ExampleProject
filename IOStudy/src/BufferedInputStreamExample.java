import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 임의 접근이 가능한 대표적인 FilterInputStream
 * @author Lee Gwangyong
 *
 */
public class BufferedInputStreamExample {
	
	public static void main(String[] args) throws IOException {
		String srcFile = "I:/KOSTA100/설치프로그램/jdk-8u45-windows-x64.exe";
		InputStream in = new FileInputStream(srcFile);
		BufferedInputStream bin = new BufferedInputStream(in);
		
		
		bin.mark(0);
		int data =  bin.read();
		System.out.println(data);
		data = bin.read();
		data = bin.read();
		data = bin.read();
		data = bin.read();
		data = bin.read();
		data = bin.read();
		data = bin.read();
		data = bin.read();
		data = bin.read();
		
		bin.skip(20);
		bin.reset();
		
		data = bin.read();
		System.out.println(data);
		
		bin.close();
	}

}
