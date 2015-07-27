package kr.or.kosta.ams.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 컬렉션을 이용한 은행 직원용 계좌 관리 앱
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

	/**
	 * 신규 계좌 개설
	 */

	public boolean openAccount(Account acc){
		accounts.addElement(acc);
		return true;
	}

	/**
	 * 전체 계좌 반환
	 */

	public List<Account> getAccounts(){
		List<Account> list = new ArrayList<Account>(accounts.size());
		list.addAll(accounts);
		return list;
		//return accounts; 다소 무거움
	}

	/**
	 * 계좌번호로 계좌 조회 (반환값 하나)
	 */
	 
	 public Account selectAccount(String accountNum){
		
		 Enumeration<Account> e = accounts.elements();
		 while(e.hasMoreElements()){
			 Account acc = e.nextElement();
			 if(acc.getAccountNum().equals(accountNum))
				 return acc;
		 }
		 /*for (int i=0; i<accounts.size(); i++) {
			 if(accountNum.equals(accounts.get(i).getAccountNum()))
				 return accounts.get(i);
		 }
		*/return null;
	}

	/**
	 * 예금주명으로 계좌 검색 (반환값 모두)
	 */

	public List<Account> searchAccount(String accountOwner) {

		List<Account> t_acc = new ArrayList<Account>(5);

		Enumeration<Account> e = accounts.elements();
		 while(e.hasMoreElements()){
			 Account acc = e.nextElement();
			 if(acc.getAccountOwner().equals(accountOwner))
				 t_acc.add(acc);
		 }
		/*for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountOwner().equals(accountOwner)) {
				t_acc.add(accounts.get(i));
			}
		}*/
		return t_acc;
	}

	/**
	 * 계좌번호로 계좌 삭제
	 */

	public boolean removeAccount(String accountNum){
		Account acc = selectAccount(accountNum);
		if( acc != null ){
			return accounts.removeElement(acc);
		}
		/*for (int i=0; i<accounts.size(); i++) {
			if( accounts.get(i).getAccountNum().equals(accountNum) ) {
				accounts.remove(i);
				return true;
			}
		}*/
		return false;
	}

}