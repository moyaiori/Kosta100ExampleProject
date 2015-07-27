class ConstructorExample {
	public static void main(String[] args)	{

		Account account1 = new Account();
		Account account2 = new Account("123-123-123","�̱���",1234,1000);
		Account account3 = new Account("12-12-23","�̱���");
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		System.out.println(account3.toString());
	}
}
