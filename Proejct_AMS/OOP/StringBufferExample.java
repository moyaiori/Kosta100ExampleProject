public class StringBufferExample {
	public static void main(String[] args)	{
		// 체인 기법
		StringBuffer sb = new StringBuffer("Java");
		sb.append(" 최강의 언어").append(" 입니까?").append(" 정말로??");
		System.out.println(sb.insert(4," Programming"));
		System.out.println(sb.replace(0, 4, "C#"));
		System.out.println(sb.reverse());
		
	}
}
