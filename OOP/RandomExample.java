import java.util.*;
public class RandomExample {
	public static void main(String[] args) {
		Random random = new Random();
		// �ڹ� ������Ÿ�Ժ� ���� �߻�
		System.out.println(random.nextBoolean());
		System.out.println(random.nextInt());    // -65536 ~ 65535
		System.out.println(random.nextInt(100)); // 0~99
		System.out.println(random.nextDouble());

		// �ζ� ��ȣ ����
		for (int i = 0; i < 6; i++) {
			System.out.println(random.nextInt(45)+1);
			}
		}
}
