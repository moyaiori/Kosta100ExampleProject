public class InstanceofExample {
	public static void main(String[] args)	{
		Circle circle = new Circle(10, 10, 5);
		System.out.println(circle instanceof Circle);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Object);

		if (circle instanceof Object){
			// �̷������� �ϸ� �׻� true�̱⶧���� ������ �ȵȴ�.
		}

		Object array = new int[10];
		System.out.println(((int[])array).length); // ���ο� �߰��Ȱ��̶� �ȵȴ�.
		System.out.println(array.toString());


		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.equals(obj2)); // ==�� ����(�ּҺ�) object�� equals�� ���� �ƴ� �ּҸ� ���Ѵ�.

		String str1 = "Java";
		String str2 = "Java";
		System.out.println(str1.equals(str2)); //

		Account acc1 = new Account("1111","�̱���",1111,100);
		Account acc2 = new Account("1111","�̱���",1111,100);
		System.out.println(acc1.equals(acc2)); // ������ �߻��� ���ɼ��� �����Ѵ�. equals �������̵�
		

	}
}
