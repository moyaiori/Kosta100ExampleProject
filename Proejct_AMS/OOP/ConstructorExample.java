class ConstructorExample {
	public static void main(String[] args)	{

		Account account1 = new Account();
		Account account2 = new Account("123-123-123","ÀÌ±¤¿ë",1234,1000);
		Account account3 = new Account("12-12-23","ÀÌ±¤¿ë");
		account1.printAttribute();
		account2.printAttribute();
		account3.printAttribute();
	}
}
