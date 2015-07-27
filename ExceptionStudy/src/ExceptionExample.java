/**
 * 예외 정의 및 예외 발생 시 JVM에 의해 처리되는
 * 기본 메커니즘 이해
 * @author 김기정
 *
 */
public class ExceptionExample {
	
	// 애플리케이션 엔트리포인트
	public static void main(String[] args) {
		System.out.println("애플리케이션 시작됨...");
		
		// 이해를 돕기위한 예외 강제 발생
		//String str = null;
		//System.out.println(str.length());	
		//JVA에 의해 new NullPointerException(); 생성됨..
		
		//int x = 150;
		//System.out.println( x / 0);
		
		int[] array = {1, 2, 3, 4, 5};
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[5]);
		
		
		System.out.println("애플리케이션 종료됨...");
	}

}
