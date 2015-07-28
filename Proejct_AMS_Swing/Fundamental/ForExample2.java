class ForExample2 {
	public static void main(String[] args)	{
		// 중첩 for문을 이용한 구구단 출력

		for (int i = 2; i <= 9 ; i++){ // 행반복
			for (int j = 1; j <= 9 ; j++){ // 열반복
				System.out.print(i + "*"+ j +"="+ (i*j) + "\t");
			}
			System.out.println();
		}
	}
}
