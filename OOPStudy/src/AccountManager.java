/**
 * 배열을 이용한 은행계좌 목록 관리 추상화
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

	// 사용자 정의 비즈니스 메소드들...

	/**
	 * 신규계좌 개설
	 */
	public boolean openAccount(Account account){
		accounts[count] = account;
		count++;
		return true;	
	}

	/**
	 * 전체계좌 반환
	 */
	public Account[] getAccounts(){
		return accounts;
	}
	
	/**
	 * 계좌번호로 계좌 조회
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
	 * 예금주명으로 계좌 검색
	 */
	public Account[] searchAccount(String accountOwner){
		Account[] searchList = null;
		int searchCount = getSearchCount(accountOwner);
		if(searchCount != 0){//검색된 계좌가 있을 경우..
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
	 * 예금주명으로 계좌 개수 반환
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
	 * 계좌번호로 계좌 삭제
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
