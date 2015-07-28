/**
 * 자바에서 지원하는 기본데이터 타입 8개 실습
 */
class DataTypeExample {
	public static void main(String[] args)	{
		// 논리 (boolean)
		boolean flag = true;
		flag = false;
		System.out.println(flag);

		// 문자(char)
		//char c = 'A'; // 65
		char c = 65; // 65
		System.out.println((int)c);

		char 한 = '\uD55C';
		char 글 = '\uAE00';
		System.out.println(한);
		System.out.println(글);


		// 제어 문자
		System.out.println("자바\n프로그래머\t입니다..");
		// 이스케이프 문자
		System.out.println("\"이광용\"입니다.");
		System.out.println("C:\\aaa\\bbb\\ccc.txt");

		//정수형(byte, short, int, long)
		//byte b = 127;

		long money = 500000L;

		// 실수형(float, double)
		float pi = (float)3.141592; // 강제형변환
		System.out.println(pi);


		System.out.println();
	}
}
