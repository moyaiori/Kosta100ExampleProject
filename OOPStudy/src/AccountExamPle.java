/**
 * ���� ������ ���� ���� ���ø����̼�
 */
class AccountExamPle {
	public static void main(String[] args)	{
		// �ű� ���� ����
		Account account = new Account();
		
		account.setAccountNum("1234-4321-7777");
		account.setAccountOwner("�̱���");
		account.setPasswd(1234);
		/*
		account.accountNum = "1234-4321-7777";
		account.accountOwner = "�̱���";
		account.passwd = 1234;
		*/


		boolean result = account.checkpasswd(1234);
		
		if (result){
			// �Ա� �׽�Ʈ
			long money =  account.deposit(100);
			System.out.println("�Ա� �� �ܾ� : " + money);

			money = account.withdraw(50);
			System.out.println("��� �� �ܾ� : " + money);

			money = account.getRestMoney();
			System.out.println("�����ܾ� : " + money);
			System.out.println("���� ��й�ȣ : " + account.getPasswd());

		}else{
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ�Ȯ�����ֽʽÿ�.");
		}

		// ���� ���� ��ü ����
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

		System.out.println("���� ���� ���� �ܾ� : " + shareAccount.getRestMoney());

	}
}
