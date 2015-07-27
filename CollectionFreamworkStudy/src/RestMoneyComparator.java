import java.util.Comparator;

import kr.or.kosta.ams.Account;
/**
 * 정렬 기준을 제시하기 위한 클래스
 * @author Lee Gwangyong
 *
 */
public class RestMoneyComparator implements Comparator<Account> {

	// 자동으로 호출되는 메소드(Call back Method)
	@Override
	public int compare(Account o1, Account o2) {
		return (int)(o1.getRestMoney() - o2.getRestMoney());
	}

}
