public class StringExample {
	public static void main(String[] args)	{
		// �ֿ� �޼ҵ�
		String text = "Java Programming";
		System.out.println("java programming".equals(text));
		System.out.println("java programming".equalsIgnoreCase(text));

		System.out.println(text.substring(5));
		System.out.println(text.substring(0,4));
		System.out.println(text.replace('J','A'));

		String ssn = "880606-2034567";
		char c = ssn.charAt(ssn.indexOf('-') + 1);
		//System.out.println(c);

		switch (c){
			case '1':
				System.out.println("2000�� ���� ��� �����Դϴ�");
				break;
			case '2':
				System.out.println("2000�� ���� ��� �����Դϴ�");
				break;
			case '3':
				System.out.println("2000�� ���� ��� �����Դϴ�");
				break;
			case '4':
				System.out.println("2000�� ���� ��� �����Դϴ�");
				break;
			default :
				System.out.println("�ܱ����Դϴ�.");
				break;
		}

		String meesage = "���ع��� ��λ���                                ";
		System.out.println(meesage.trim().length());
		System.out.println(meesage.length());

		System.out.println("                  abc".trim());

		// x�� �ڸ����� ���϶�
		int x = 12345;

		int count = String.valueOf(x).length();
		System.out.println(count);
	}
}
