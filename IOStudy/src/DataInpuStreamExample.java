import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

/**
 * 자바의 기본데이터타입을 문자열로 형변환(디코딩)
 * @author Lee Gwangyong
 *
 */
public class DataInpuStreamExample {

	public static void main(String[] args) throws IOException {
		String filePath = "printExample.txt";
//		FileOutputStream out = new FileOutputStream(filePath);
//		DataOutputStream dOut = new DataOutputStream(out);
		
		PrintStream out = new PrintStream(filePath);
//		PrintStream ps = new PrintStream(filePath, "utf-8");
		
		boolean man = true;
		int age = 48;
		double weight = 70.2;
		char gender = 'm';
		String name = "이광용";
		
		Calendar today = Calendar.getInstance();
		
		out.println(man);
		out.println(age);
		out.println(weight);
		out.println(gender);
		out.println(name);
		
		out.printf("%1$tF %1$tT",today);
		
		out.close();
		
		System.out.println("문자열로 다썻음");
		
	}

}
