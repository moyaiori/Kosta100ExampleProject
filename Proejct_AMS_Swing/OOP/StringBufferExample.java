public class StringBufferExample {
	public static void main(String[] args)	{
		// ü�� ���
		StringBuffer sb = new StringBuffer("Java");
		sb.append(" �ְ��� ���").append(" �Դϱ�?").append(" ������??");
		System.out.println(sb.insert(4," Programming"));
		System.out.println(sb.replace(0, 4, "C#"));
		System.out.println(sb.reverse());
		
	}
}
