class WhileExample {
	public static void main(String[] args)	{

		// 1 ~ 100 ���� ������ 
		int i = 1;
		int total = 0;

		while (i <= 100){
			total += i;
			i++;
		}

		System.out.println("1���� 100������ ���� " + total + "�Դϴ�.");

		
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

		System.out.println("1���� 100���� Ȧ�� ���� " + oddSum + "�Դϴ�.");
		System.out.println("1���� 100���� ¦�� ���� " + evenSum + "�Դϴ�.");

		// do ~ while��
		int i = 1;
		int total = 0;

		do{
			total += i;
			i++

		}while (i <= 100){
			total += i;
			i++;
		}

		System.out.println("1���� 100������ ���� " + total + "�Դϴ�.");
	}
}
