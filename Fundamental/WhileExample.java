class WhileExample {
	public static void main(String[] args)	{

		// 1 ~ 100 까지 누적값 
		int i = 1;
		int total = 0;

		while (i <= 100){
			total += i;
			i++;
		}

		System.out.println("1부터 100까지의 합은 " + total + "입니다.");

		
		i =1;
		int oddSum = 0, evenSum = 0;

		while (i <= 100){
			if (i % 2 == 0){
				evenSum += i;
			}else if (i % 2 == 1){
				oddSum += i;
			}
			i++;
		}

		System.out.println("1부터 100까지 홀수 합은 " + oddSum + "입니다.");
		System.out.println("1부터 100까지 짝수 합은 " + evenSum + "입니다.");

		// do ~ while문
		int i = 1;
		int total = 0;

		do{
			total += i;
			i++

		}while (i <= 100){
			total += i;
			i++;
		}

		System.out.println("1부터 100까지의 합은 " + total + "입니다.");
	}
}
