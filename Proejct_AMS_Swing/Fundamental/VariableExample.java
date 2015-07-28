/**
 * 변수관련 예제
 */
class VariableExample {
	public static void main(String[] args)	{
		// #1. 변수 선언
		int myScore;

		// #2. 변수 초기화(값 최초 할당)
		myScore = 75;

		// 변수끼리도 할당 가능
		int yourScore = myScore;

		myScore = 100;

		// 동일한 자료형
		int a = 60, b = 70;

		// #3. 변수 사용(참조)
		System.out.println(myScore);
		System.out.println(yourScore);

		// 지역변수는 초기화하지 않은 상태에서
		// 컴파일시 에러
		// int age;
		//System.out.println(age);
	}
}
