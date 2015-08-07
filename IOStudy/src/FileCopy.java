import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long begin = System.currentTimeMillis();
		
		String srcFile = "I:/KOSTA100/설치프로그램/jdk-8u45-windows-x64.exe";
		String destFile = "I:/KOSTA100/설치프로그램/jdk-8u45-windows-x64 - 복사본.exe";
		File file1 = new File(srcFile);
		File file2 = new File(destFile);
		
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(file1);
			out = new FileOutputStream(file2);
			int count = 0;
			byte[] buffer = new byte[4*1024];
			while((count = in.read(buffer, 0, buffer.length)) != -1){
				out.write(buffer, 0, buffer.length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				System.out.println(file1.length()/1024 + " KB 복사 완료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("소요된 시간 : " + (end - begin) + " 1000/1초");
		System.out.println("복사끝");
		
	}

}
