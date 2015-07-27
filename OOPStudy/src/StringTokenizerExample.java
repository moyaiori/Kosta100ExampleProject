import java.util.StringTokenizer;
public class StringTokenizerExample {
	public static void main(String[] args)	{
		String cardNum = "1111 2222 3333 4444";
		StringTokenizer st = new StringTokenizer(cardNum," ");
		System.out.println(st.countTokens());

		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}
