public class WrapperClassExample {
	public static void main(String[] args)	{
		String str = "159753";
		// ��ü�� ���� -> �����ڸ� Ȱ��
		Integer integer = new Integer(str);
		// ���� �����
		int i = integer.intValue();

		i = Integer.parseInt(str);


		System.out.println(i * 2);

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		int num = 12345;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));

		for (int ii = 0; ii <= Integer.MAX_VALUE ; ii++){
			System.out.println(Integer.toBinaryString(ii));
		}
	}
}
