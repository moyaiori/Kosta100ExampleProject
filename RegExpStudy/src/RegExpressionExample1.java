import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규표현식(패턴)을 이용한 문자열 검색
 * @author 김기정
 */
public class RegExpressionExample1 {

	public static void main(String[] args) {
		// 테스트를 위한 문자열 목록
		String[] searchValues = { "bat", "baby", "bonus", "cA", "ca", "co", "c", "c.", "c0", "car", "combat", "count", "date", "disc" };

		// c로 시작하는 영문 소문자 패턴 생성
		Pattern pattern = Pattern.compile("c[a-z]*"); 
		System.out.println("-------- 패턴과 일치하는 영문소문자 ---------");
		for (String searchValue : searchValues) {
			Matcher matcher = pattern.matcher(searchValue);
			if (matcher.matches()) {
				System.out.println(searchValue + "는 패턴과 일치.");
			}
		}
	}
}
