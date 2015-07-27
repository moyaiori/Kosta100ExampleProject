class MethodExample {

	// 사용자 정의 메소드
	static void printGugudan(){
		for (int i = 2; i <= 9 ; i++){ // 행반복
			for (int j = 1; j <= 9 ; j++){ // 열반복
				System.out.print(i + "*"+ j +"="+ (i*j) + "\t");
			}
			System.out.println();
		}
	}

	// 매게변수가 있는 경우
	static void printDan(int dan){
		for (int j = 1; j < 10 ; j++){ // 열반복
			System.out.print(dan + "*"+ j +"="+ (dan*j) + "\t");
		}
	}

	// 반환형이 있는경우
	static int printSum(int x, int y){
		return x + y;
	}

	


	public static void main(String[] args)	{

		//메소드 호출
		//printGugudan();
		//printDan(8);
		System.out.println(printSum(1,2)); 
	}
}
