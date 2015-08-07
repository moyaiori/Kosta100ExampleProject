import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

public class FileExample {
	
	public static void main(String[] args) throws IOException {
//		String filePath = "I:/KOSTA100/설치프로그램/epp370_64bit.exe";
		String filePath = "sample.dat";
//		String filePath = "i:/KOSTA100";
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
		
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(file.lastModified());
		System.out.println(String.format("%1$tF %1$tT", cal));
		System.out.println(file.lastModified());
		System.out.println(file.isHidden());
		System.out.println(file.length());
		
		File temp = new File("I:/temp.txt");
		boolean ok = temp.createNewFile();
		System.out.println("파일이 생성되었습니다. : " + ok);
		
		temp.delete();
		System.out.println("삭제 완료");
		
		File directory = new File("c:/");
		File[] list = directory.listFiles();
		/*
		for (File file2 : list) {
			if (file2.isDirectory()) {
				System.out.println("<DIR> " + file2.getName());
			} else {
				System.out.println(file2.getName() + " " + file2.length());
			}
		}
		*/
		//mkdir(); // 디렉토리 생성
		//renameTo(); // 이름 재설정
		
		File[] drives = File.listRoots();
		for (File file2 : drives) {
			System.out.println(file2);
		}
	
	}
}























