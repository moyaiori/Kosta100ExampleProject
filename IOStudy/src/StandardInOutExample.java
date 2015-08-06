import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

/**
 * 표준 입출력
 * @author Lee Gwangyong
 *
 */
public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
//		System.out.println(System.out);
		
//		System.out.println("아무키나 눌러주세요 : ");
//		int data = System.in.read();
//		System.out.println(data);
		/*
		byte[] buffer = new byte[102];
		int count = System.in.read(buffer);
		// 엔터가 2바이트
//		System.out.println(count);
		
		for (int i = 0; i < count; i++) {
			System.out.println(buffer[i]);
		}*/
		/*
		System.out.println("당신의 나이는? : ");

		byte[] buffer = new byte[100];
		int count = System.in.read(buffer);
		String str = new String(buffer, 0 , count -2);
		int result = Integer.parseInt(str);
		System.out.println(result);
		*/

		byte[] buffer = new byte[100];
		System.out.print("당신의 이름은 : ");
		int count = System.in.read(buffer);
		String name = new String(buffer, 0 , count -2);
		System.out.println(name);
		
		
//		int age = (int)System.in.read();

		
		/*
        Scanner in = new Scanner(System.in);
		int age = in.nextInt();
//		int age = Integer.parseInt(Console.readLine());
		
		
		System.out.println(age);
		System.out.println(age-40);
		*/
		
	}

}
