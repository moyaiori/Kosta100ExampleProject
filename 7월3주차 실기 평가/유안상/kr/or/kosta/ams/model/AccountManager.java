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

	public AccountManager() {
		this(10, 2);
	}

	public AccountManager(int count, int increament) {
		this.accounts = new Vector<Account>(count, increament);
	}

	// 사용자 정의 비즈니스 메소드들

	/**
	 * 신규 계좌 개설
	 */
	public boolean openAccount(Account account) {
		accounts.add(account);
		return true;
	}

	/**
	 * 전체 계좌 반환
	 */
	public List<Account> returnAccount() {
		List<Account> list = new ArrayList<Account>(accounts.size());
		list.addAll(accounts);
		return list;
	}

	/**
	 * 계좌번호로 계좌 조회 (반환값이 1개)
	 */
	// 주고받을때는 Vector보다는 ArrayList(List)로 하는 것이 좋다.
	public Account getAccount(String accountNum) {
		/** Vector(동기화된것)을 반복하기 위해 Enumeration 활용 */
		Enumeration<Account> E = accounts.elements(); // E에 accounts의 요소를 모두 삽입
		while (E.hasMoreElements()) {
			Account account = E.nextElement();
			if (account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		return null;
	}

	/**
	 * 예금주명으로 계좌 검색 (반환값이 여러 개)
	 * 반환값이 여러개이므로 계좌번호와는 다르게 List<Account>로 반환한다
	 */
	public List<Account> searchAccount(String accountOwner) {
		List<Account> searchResult = new ArrayList<Account>(accounts.size());
		Enumeration<Account> E = accounts.elements();
		while (E.hasMoreElements()) {
			Account account = E.nextElement();
			if (account.getAccountOwner().equals(accountOwner)) {
				searchResult.add(account);
			}
		}
		return searchResult;
	}

	/**
	 * 예금주명으로 계좌 개수 반환 (선생님)
	 */
	private int getSeartCount(String accountOwner) { // 재사용 가능성이 있으니 기능마다 끊어서
														// 메소드를 구현하는 연습을 실시
		int searchCount = 0; // 검색한 이름이 몇개 있는지 체크하는 변수(지역변수도 의미있는 이름을 부여하라!)
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountOwner().equals(accountOwner)) {
				searchCount++;
			}
		}
		return searchCount;
	}

	/**
	 * 계좌번호로 계좌 삭제
	 */
	public boolean removeAccount(String accountNum) {
		Account account = getAccount(accountNum); // getAccount메소드(accountNum)을 가진 계좌를 가져옴
		for (int i = 0; i < accounts.size(); i++) {
			if (account != null) { // 만약 accountNum이 존재하는 계좌에 있으면
				return accounts.removeElement(account); // 해당번호를 가진 계좌를 삭제함
			}
		}
		return false;
	}
}