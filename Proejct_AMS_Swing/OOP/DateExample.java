import java.util.Date;
public class DateExample {
	public static void main(String[] args)	{
		Date today = new Date();
		System.out.println(today);
		System.out.println(today.toLocaleString());

		long ms = today.getTime();
		int year = (int)((ms / (1000 * 60 * 60 * 24)) / 365);

		System.out.println(today.getTime());
		System.out.println(year);
		
	}
}
