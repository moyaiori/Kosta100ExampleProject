import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import kr.or.kosta.ams.Account;

public class MapExample2 {

	public static void main(String[] args) {
		Hashtable<String, Account> accounts = new Hashtable<String, Account>();
		
		Account account = new Account("11","이광용",1234,1000);
		Account account2 = new Account("12","김광용",1234,2000);
		
		accounts.put(account.getAccountNum(), account);
		accounts.put(account2.getAccountNum(), account2);
		
		System.out.println(accounts.get("11"));
		
		// 키목록
		Enumeration<String> result = accounts.keys();
		while (result.hasMoreElements()) {
			String string = result.nextElement();
			System.out.println(string);
			System.out.println(string + "" + accounts.get(string));
		}
		
		// 값목록
		Enumeration<Account> acc = accounts.elements();
		while (acc.hasMoreElements()) {
			Account acc2 = acc.nextElement();
			System.out.println(acc2);
		}
	}

}
