import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 자바의 기본데이터타입별 쓰기 메소드 제공 쓰기
 * @author Lee Gwangyong
 *
 */
public class PrintStreamExample {

	public static void main(String[] args) throws IOException {
		String filePath = "sample.dat";
		FileOutputStream out = new FileOutputStream(filePath);
		DataOutputStream dOut = new DataOutputStream(out);
		
		boolean man = true;
		int age = 48;
		double weight = 70.2;
		char gender = 'm';
		String name = "이광용";
		
		dOut.writeBoolean(man); 	// 1
		dOut.writeInt(age);			// 4
		dOut.writeDouble(weight);	// 8
		dOut.writeChar(gender);		// 2
		dOut.writeUTF(name); 		// 1~3 가변형
		
		dOut.close();
		
		System.out.println("다썻음");
		
		
		
	}

}
