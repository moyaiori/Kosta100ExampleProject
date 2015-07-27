//package kr.or.kosta.ams;
//
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.List;
//import java.util.Vector;
//
///**
// * Vector를 이용한 은행계좌 목록 관리 추상화
// */
//public class AccountManager {
//
//	private Vector<Account> accounts;
//
//	public AccountManager(){
//		this(10, 2);
//	}
//	
//	public AccountManager(int count, int increament){
//		this.accounts = new Vector<Account>(count, increament);
//	}
//
//	
//	public int getCount(){
//		return accounts.size();
//	}
//
//	// 사용자 정의 비즈니스 메소드들...
//
//	/**
//	 * 신규계좌 개설
//	 */
//	public boolean openAccount(Account account){
//		accounts.addElement(account);
//		return true;	
//	}
//
//	/**
//	 * 전체계좌 반환
//	 */
//	public List<Account> getAccounts(){
//		//return accounts;
//		List<Account> list = new ArrayList<Account>(accounts.size());
//		list.addAll(accounts);
//		return list;
//	}
//	
//	/**
//	 * 계좌번호로 계좌 조회
//	 */
//	public Account getAccount(String accountNum){
//		Enumeration<Account> e = accounts.elements();
//		while(e.hasMoreElements()){
//			Account account = e.nextElement();
//			if(account.getAccountNum().equals(accountNum)){
//				return account;
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 예금주명으로 계좌 검색
//	 */
//	public List<Account> searchAccount(String accountOwner){
//		List<Account> searchList = new ArrayList<Account>(5);
//		Enumeration<Account> e = accounts.elements();
//		while(e.hasMoreElements()){
//			Account account = e.nextElement();
//			if(account.getAccountOwner().equals(accountOwner)){
//				searchList.add(account);
//			}
//		}
//		return searchList;
//	}
//
//	/**
//	 * 계좌번호로 계좌 삭제
//	 */
//	public boolean removeAccount(String accountNum){
//		Account account = getAccount(accountNum);
//		if(account != null){
//			return accounts.removeElement(account);
//		}
//		return false;
//	}
//}
