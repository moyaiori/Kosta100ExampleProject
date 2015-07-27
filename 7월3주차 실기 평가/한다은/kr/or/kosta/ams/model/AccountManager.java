package kr.or.kosta.ams.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Vector를 이용한 은행계좌 목록 관리 추상화
 */
public class AccountManager {

	private Vector<Account> accounts;

	public AccountManager(){
		this(10, 2);
	}
	
	public AccountManager(int count, int increament){
		this.accounts = new Vector<Account>(count, increament);
	}

	public int getCount(){
		return accounts.size();
	}

	// 사용자 정의 비즈니스 메소드들...

	/**
	 * 신규계좌 개설
	 */
	public boolean openAccount(Account account){
		accounts.addElement(account);
		return true;	
	}

	/**
	 * 전체계좌 반환
	 */
	public List<Account> getAccounts(){
		//return accounts;
		List<Account> list = new ArrayList<Account>();
		list.addAll(accounts);
		return list;
	}
	
	/**
	 * 계좌번호로 계좌 조회
	 */
	public Account getAccount(String accountNum){
		/*
		 * 선생님코드
		 * Enumeration<Account>	e=accounts.elements();
		 * while(e.hasMoreElements()){
		 * 	Account account=e.nextElement();
		 * if(account.getAccountNum().equals(accountNum))
		 * 		return account;
		 * }
		 * */
		
		
		
		for (int i = 0; i <accounts.size(); i++) {
			if(accounts.get(i).getAccountNum().equals(accountNum)){
				return accounts.get(i);
			}
		}
		return null;
	}

	/**
	 * 예금주명으로 계좌 검색
	 */
	public List<Account> searchAccount(String accountOwner){
		List<Account> result = new ArrayList<Account>(); //크기 정해놓지 않아도 더 넣으면 알아서 늘어남

		for (int i = 0; i <accounts.size(); i++) {
			if(accounts.get(i).getAccountOwner().equals(accountOwner)){
				result.add(accounts.get(i));
			}
		}
		
		return result;
	}

	/**
	 * 예금주명으로 계좌 개수 반환
	
	private int getSearchCount(String accountOwner){
		int searchCount = 0;
		for (Account account : searchAccount) {
			if (account.getAccountOwner().equals(accountOwner)){
				searchCount++;
			}
		}
		return searchCount;
	}
	*/
	
	/**
	 * 계좌번호로 계좌 삭제
	 */
	public boolean removeAccount(String accountNum){
		for (int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getAccountNum().equals(accountNum)){
				accounts.remove(i);
				return true;
			}
		}
		
		/*
		 * Account account=getAccount(accountNum)
		 * if(account!=null)
		 * 	return accounts.removeElement(account)
		 * return false;
		 */
		return false;
	}
}


