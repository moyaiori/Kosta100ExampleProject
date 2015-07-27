/**
 * 은행 직원용 계좌 관리 애플리케이션
 */
class AccountExamPle {
	public static void main(String[] args)	{
		// 신규 계좌 개설
		Account account = new Account();
		
		account.setAccountNum("1234-4321-7777");
		account.setAccountOwner("이광용");
		account.setPasswd(1234);
		/*
		account.accountNum = "1234-4321-7777";
		account.accountOwner = "이광용";
		account.passwd = 1234;
		*/


		boolean result = account.checkpasswd(1234);
		
		if (result){
			// 입금 테스트
			long money =  account.deposit(100);
			System.out.println("입금 후 잔액 : " + money);

			money = account.withdraw(50);
			System.out.println("출금 후 잔액 : " + money);

			money = account.getRestMoney();
			System.out.println("현재잔액 : " + money);
			System.out.println("현재 비밀번호 : " + account.getPasswd());

		}else{
			System.out.println("비밀번호가 틀렸습니다. 다시확인해주십시오.");
		}

		// 공유 계좌 객체 생성
		Account shareAccount = new Account();
		/*
		shareAccount.accountNum = "2222-3333-4444";
		shareAccount.accountOwner = "KOSTA100";
		shareAccount.passwd = 1234;
		*/

		// Pass by Reference
		Account shareAccount2 = shareAccount;

		shareAccount2.deposit(1000);
		shareAccount2.withdraw(500);

		System.out.println("공유 계좌 현재 잔액 : " + shareAccount.getRestMoney());

	}
}
