/**
 * 연산자 예제
 */

class OperatorExample {
	public static void main(String[] args)	{
		// 산술연산자(+, -. *, /, %)
		System.out.println(10+20);
		System.out.println("광용" + "최고");
		System.out.println("광용" + 10);

		int score = 88;

		System.out.println("score : " + score );
		// "점수" + "88"; 자동형변환

		// 복합대입연산자 (+=, *=, -= ......)
		int x = 55, y = 77;

		x += y;
		System.out.println(x);



		System.out.println();
	}
}
