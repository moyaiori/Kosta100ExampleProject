/**
 * �ڹٿ��� �����ϴ� �⺻������ Ÿ�� 8�� �ǽ�
 */
class DataTypeExample {
	public static void main(String[] args)	{
		// �� (boolean)
		boolean flag = true;
		flag = false;
		System.out.println(flag);

		// ����(char)
		//char c = 'A'; // 65
		char c = 65; // 65
		System.out.println((int)c);

		char �� = '\uD55C';
		char �� = '\uAE00';
		System.out.println(��);
		System.out.println(��);


		// ���� ����
		System.out.println("�ڹ�\n���α׷���\t�Դϴ�..");
		// �̽������� ����
		System.out.println("\"�̱���\"�Դϴ�.");
		System.out.println("C:\\aaa\\bbb\\ccc.txt");

		//������(byte, short, int, long)
		//byte b = 127;

		long money = 500000L;

		// �Ǽ���(float, double)
		float pi = (float)3.141592; // ��������ȯ
		System.out.println(pi);


		System.out.println();
	}
}
