/**
 * ���۷��� Ÿ�� �迭 ����, ����, �ʱ�ȭ
 */
public class ReferenceArrayExample {


	public static void main(String[] args)	{
		//�л� �̸� ��� ����
		String[] names;
		names = new String[26];

		names[0] = "�̱���";
		names[1] = "�ڷ���";
		names[2] = "������";
		names[3] = "������";
		names[4] = "���ر�";
		names[25] = "������";

		for (int i = 0; i < names.length ; i++ ){
			System.out.println(i + ":" + names[i] + "\t");
		}
	}
}
