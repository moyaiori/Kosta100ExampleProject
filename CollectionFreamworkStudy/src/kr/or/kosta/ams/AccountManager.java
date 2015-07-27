package kr.or.kosta.ams;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Vector을 이용한 은행계좌 목록 관리 추상화
 */
public class AccountManager {

	private Vector<Account> accounts;

	public AccountManager(){
		this(10,2);
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
//		return accounts;
		//비용을 줄이기위한 로직
		List<Account> list = new ArrayList<Account>(accounts.size());
		list.addAll(accounts);
		return list;
	}
	
	/**
	 * 계좌번호로 계좌 조회
	 */
	public Account getAccount(String accountNum){

		Enumeration e = accounts.elements();
//		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account acc = (Account)e.nextElement();
			if(acc.getAccountNum().equals(accountNum)){
//				System.out.println("매칭된 값 반환 : " + acc);
				return acc;
			}
		}
		return null;
	}
	

	/**
	 * 예금주명으로 계좌 검색
	 */
	public Account searchAccount(String accountOwner){
		
//		int searchCount = getSearchCount(accountOwner);
		int searchCount = accounts.size();
		
		Enumeration e = accounts.elements();
		if(searchCount != 0){//검색된 계좌가 있을 경우..
			while (e.hasMoreElements()) {
//				Object obj = e.nextElement();
				Account acc = (Account)e.nextElement();
				if(acc.getAccountOwner().equals(accountOwner)){
					return acc;
				}
			}
		}
		return null;
	}
	
	/**
	 * 계좌번호로 계좌 삭제
	 */
	public boolean removeAccount(String accountNum){
		
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Object obj = e.nextElement();
			Account acc = (Account)obj;
			if(acc.getAccountOwner().equals(accountNum)){
				accounts.remove(acc);
				System.out.println(acc);
				return true;
			}
		}
		return false;
	}

}
