public class StringExample {
	public static void main(String[] args)	{
		// 주요 메소드
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
				System.out.println("2000년 이전 출생 남자입니다");
				break;
			case '2':
				System.out.println("2000년 이전 출생 여자입니다");
				break;
			case '3':
				System.out.println("2000년 이후 출생 남자입니다");
				break;
			case '4':
				System.out.println("2000년 이후 출생 여자입니다");
				break;
			default :
				System.out.println("외국인입니다.");
				break;
		}

		String meesage = "동해물과 백두산이                                ";
		System.out.println(meesage.trim().length());
		System.out.println(meesage.length());

		System.out.println("                  abc".trim());

		// x의 자릿수를 구하라
		int x = 12345;

		int count = String.valueOf(x).length();
		System.out.println(count);
	}
}
