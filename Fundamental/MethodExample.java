class MethodExample {

	// ����� ���� �޼ҵ�
	static void printGugudan(){
		for (int i = 2; i <= 9 ; i++){ // ��ݺ�
			for (int j = 1; j <= 9 ; j++){ // ���ݺ�
				System.out.print(i + "*"+ j +"="+ (i*j) + "\t");
			}
			System.out.println();
		}
	}

	// �ŰԺ����� �ִ� ���
	static void printDan(int dan){
		for (int j = 1; j < 10 ; j++){ // ���ݺ�
			System.out.print(dan + "*"+ j +"="+ (dan*j) + "\t");
		}
	}

	// ��ȯ���� �ִ°��
	static int printSum(int x, int y){
		return x + y;
	}

	


	public static void main(String[] args)	{

		//�޼ҵ� ȣ��
		//printGugudan();
		//printDan(8);
		System.out.println(printSum(1,2)); 
	}
}
