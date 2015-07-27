/**
 * �迭�� �̿��� ������� ��� ���� �߻�ȭ
 */
public class AccountManager {

	private Account[] accounts;
	private int count;

	public AccountManager(){
		this(10);
	}
	
	public AccountManager(int count){
		this.accounts = new Account[count];
	}

	
	public int getCount(){
		return count;
	}

	// ����� ���� ����Ͻ� �޼ҵ��...

	/**
	 * �ű԰��� ����
	 */
	public boolean openAccount(Account account){
		accounts[count] = account;
		count++;
		return true;	
	}

	/**
	 * ��ü���� ��ȯ
	 */
	public Account[] getAccounts(){
		return accounts;
	}
	
	/**
	 * ���¹�ȣ�� ���� ��ȸ
	 */
	public Account getAccount(String accountNum){
		for(int i=0; i<count; i++){
			if(accounts[i].getAccountNum().equals(accountNum)){
				return accounts[i];
			}		
		}
		return null;
	}

	/**
	 * �����ָ����� ���� �˻�
	 */
	public Account[] searchAccount(String accountOwner){
		Account[] searchList = null;
		int searchCount = getSearchCount(accountOwner);
		if(searchCount != 0){//�˻��� ���°� ���� ���..
			searchList = new Account[searchCount];
			int position = 0;
			for(int i=0; i<count; i++){
				if (accounts[i].getAccountOwner().equals(accountOwner)){
					searchList[position] = accounts[i];
					position++;
				}
			}
		}
		return searchList;
	}

	/**
	 * �����ָ����� ���� ���� ��ȯ
	 */
	private int getSearchCount(String accountOwner){
		int searchCount = 0;
		for(int i=0; i<count; i++){
			if (accounts[i].getAccountOwner().equals(accountOwner)){
				searchCount++;
			}
		}
		return searchCount;
	}
	
	/**
	 * ���¹�ȣ�� ���� ����
	 */
	public boolean removeAccount(String accountNum){
		for(int i=0; i<count; i++){
			if (accounts[i].getAccountNum().equals(accountNum)){
				for (int j=i; j<count-1; j++){
					accounts[j] = accounts[j+1];
				}
				count--;
				return true;
			}
		}
		return false;
	}

}
