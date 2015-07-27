public class AMS2 {
	public static void main(String[] args)	{
		Account account = new Account();

		MinusAccount ma = new MinusAccount("555-666" ,"±Ë¥Î√‚" ,1234 ,10000, 1000000);

		ma.deposit(10000);
		System.out.println(ma);
		System.out.println(ma.getRestMoney());

	}
}
