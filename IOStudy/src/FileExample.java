import java.io.File;
import java.net.MalformedURLException;

public class FileExample {
	
	public static void main(String[] args) throws MalformedURLException {
//		String filePath = "I:/KOSTA100/설치프로그램/epp370_64bit.exe";
		String filePath = "sample.dat";
		File file = new File(filePath);
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
		System.out.println(file.getPath());
		System.out.println(file.isAbsolute());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.toURI());
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.exists());
	
	}
}
