public class MathExample {
	public static void main(String[] args) {
		System.out.println("������: " + Math.PI);
		System.out.println("�ڿ��α��� �ؼ�: "+ Math.E);

		System.out.println("-20�� ���밪: "+ Math.abs(-20));
		System.out.println("-20.3�� ���밪: "+ Math.abs(-20.3));

		System.out.println("�ִ밪: "+ Math.max(50, 30));
		System.out.println("�ּҰ�: "+ Math.min(1.5, 3.3));

		System.out.println("2�� 3�� ��: "+ Math.pow(2, 3));

		System.out.println("69.6�� �ݿø�: "+ Math.round(69.6));
		System.out.println("69.3�� ����: "+ Math.ceil(69.3));
		System.out.println("69.8�� ����: "+ Math.floor(69.8));

		// ���ǰ� (0.0 <= random < 1.0)
		System.out.println(Math.random());
		// 0 ~ 2 ������ ������ ��
		System.out.println((int)(Math.random()*3));

		// �ζ� ��ȣ(1~45������ 6��)
		for (int i = 0; i < 6; i++) {
			 System.out.print((int)(Math.random()*45) + 1 + "\t");
		}
	}

}
