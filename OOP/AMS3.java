public class AMS3 {
	public static void main(String[] args)	{
		//AccountManager accountManager = new AccountManager(50);
		System.out.println("--- AMD Start up ---");
		Account acc1 = new Account("111","�̱���",1234,100);
		Account acc2 = new Account("111","�̱���",1234,100);

		System.out.println(acc1.equals(acc2));



		//System.out.println(accountManager.getAccounts());

		//accountManager.openAccount(new Account("111-222","�̱���",1234,20000));
		//System.out.println(accountManager.getAccounts());

		/*
		// ���°��� �׽�Ʈ
		accountManager.openAccount(new Account("111-222","�̱���",1234,20000));
		accountManager.openAccount(new Account("111-333","�ڱ���",1234,30000));
		accountManager.openAccount(new MinusAccount("111-444","�豤��",1234,40000, 10000));
		accountManager.openAccount(new Account("111-555","������",1234,50000));
		accountManager.openAccount(new MinusAccount("111-666","�ȱ���",1234,60000, 20000));

		System.out.println("�Ѱ����� ���¼� : " + accountManager.getCount());

		Account acc = accountManager.getAccount("111-333");
		System.out.println(acc);*/

		/*
		Account[] list = accountManager.getAccounts();

		//�� ���� �ް����ϴ� ���� : �迭
		for (Account account : list){
			if(account != null){
				if (account instanceof MinusAccount){
					MinusAccount ma = (MinusAccount)account;
					System.out.println(ma + "\t " + ma.getBorrowMoney());
				}else{
					System.out.println(account);
				}
			}
		}*/



	}
}
