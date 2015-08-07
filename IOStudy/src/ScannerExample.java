import java.util.Scanner;

/**
 * JDK 1.5 추가 유틸리티 클래스
 * 키보드입력을 바로 디코딩해서 저장한다.
 * @author Lee Gwangyong
 *
 */
public class ScannerExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("당신의 이름은 : ");
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println("당신의 나이는 : ");
		int age = scanner.nextInt();
		System.out.println(age);
	}
}
