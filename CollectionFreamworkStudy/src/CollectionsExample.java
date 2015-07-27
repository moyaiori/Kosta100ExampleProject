import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kr.or.kosta.ams.Account;

/**
 * Collection(Set, List, Queue, Map) 객체와 관련된 다양한 유틸리티(static 메소드) 메소드 제공
 * @author Lee Gwangyong
 *
 */
public class CollectionsExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		// 동적 동기화 처리
		Collections.synchronizedList(list);
		
		list.add("CCC");
		list.add("BBB");
		list.add("AAA");
		list.add("이광용");
		
		Collections.sort(list);
		
		for (String string : list) {
			System.out.println(string);
		}
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("2222", "이광용", 1234, 2000));
		accounts.add(new Account("1111", "박광용", 1234, 1000));
		accounts.add(new Account("4444", "김광용", 1234, 4000));
		accounts.add(new Account("3333", "최광용", 1234, 3000));
		
//		Collections.sort(accounts, new RestMoneyComparator());
		Collections.sort(accounts, new OwnerComparator());
		
		for (Account account : accounts) {
			System.out.println(account);
		}
		
		
		
		
	}

}
