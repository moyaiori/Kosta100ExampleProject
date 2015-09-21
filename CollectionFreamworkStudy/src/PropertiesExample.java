import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws IOException {
		// 환경설정 파일인 properties 파일의 내용을 맵에 로드
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("classes/conf/smaple.properties");
		properties.load(in);
		
		System.out.println(properties.size() + "만큼 로드하였습니다.");
		System.out.println("FontName : " + properties.getProperty("fontName"));
		
		properties.setProperty("fontStyle", "BOLD");
		properties.store(new FileOutputStream("classes/conf/smaple.properties"), "주석주석");

	}

}
