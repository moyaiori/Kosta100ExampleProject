package kr.or.kosta.ams;
public class AMS {
	public static void main(String[] args)	{
		
		AccountManager accountManager = new AccountManager();
		
		System.out.println("--- AMD Start up ---");
//		Account acc1 = new Account("111","이광용",1234,1000);
//		Account acc2 = new Account("222","박광용",1234,2000);
		accountManager.openAccount(new Account("111-222","이광용",1234,20000));
		accountManager.openAccount(new Account("111-333","박광용",1234,30000));
		accountManager.openAccount(new Account("111-444","박광용",1234,30000));
		accountManager.openAccount(new Account("111-555","가광용",1234,50000));

//		System.out.println(accountManager.getAccounts());
		System.out.println("---");
		System.out.println(accountManager.getAccount("111-222"));
//		System.out.println(accountManager.searchAccount("박광용"));
//		System.out.println(accountManager.removeAccount("가광용"));
		System.out.println("---");
//		System.out.println(accountManager.getAccounts());
		
//		System.out.println(accountManager.getAccounts());
//		System.out.println(accountManager.getCount());

		//accountManager.openAccount(new Account("111-222","이광용",1234,20000));
		//System.out.println(accountManager.getAccounts());

		/*
		// 계좌개설 테스트
		accountManager.openAccount(new Account("111-222","이광용",1234,20000));
		accountManager.openAccount(new Account("111-333","박광용",1234,30000));
		accountManager.openAccount(new MinusAccount("111-444","김광용",1234,40000, 10000));
		accountManager.openAccount(new Account("111-555","가광용",1234,50000));
		accountManager.openAccount(new MinusAccount("111-666","안광용",1234,60000, 20000));

		System.out.println("총개설된 계좌수 : " + accountManager.getCount());

		Account acc = accountManager.getAccount("111-333");
		System.out.println(acc);*/

		/*
		Account[] list = accountManager.getAccounts();

		//각 값을 받고자하는 변수 : 배열
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
