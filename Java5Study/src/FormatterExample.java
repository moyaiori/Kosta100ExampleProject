import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class FormatterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double num = 126665345.567788;
		
		// java5 이전 출력 포맷 설정
		NumberFormat nf;
		nf = new DecimalFormat("##,###.00");
		
		String fst = nf.format(num);
		System.out.println(fst);
		
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");
		System.out.println(dateFormat.format(today));
		
		// ------------------------ 기본형 --------------------------
		// java5 이후 출력포맷 설정 방법
		int number = 1234567;
		Formatter formatter = new Formatter();
		// Formatter format(String format,Object... args)
		// format : "%[출력인자순서$][출력옵션(-, +, (,,..)][출력자리수][.소수점이하자리수]출력데이터유형"
		// args : 포맷팅 하고자 하는 가변인자
		String formatedString = null;
		formatedString = formatter.format("%+-10d", number).toString();
		System.out.println(formatedString);
		
		formatter = new Formatter();
		// 우측정렬 후 정수로 출력
		System.out.println(formatter.format("%1$d$	%2$s", number, "얌마"));

		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 정수로 포맷
		System.out.println(formatter.format("%,+-20d", number));

		double height = 23454.34343434356;
		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 소수점 이하 2자리 실수로 포맷
		System.out.println(formatter.format("%,+-20.2f", height));
		
		// ------------------------ 문자열 --------------------------
		String name = "김기정";
		formatter = new Formatter();
		// 10자리확보하고 우측정렬 후 문자열 포맷
		System.out.println(formatter.format("%-10s", name));

		formatter = new Formatter();
		System.out.println(formatter.format("%o : 8진수", 150)); //8진수 포맷
		System.out.println(formatter.format("%x : 16진수", 458)); //16진수 포맷
		
		System.out.printf("\n\t%-+,20.4f", 111222.333444);
		
		// 도스콘솔 전용
		System.out.printf("%,+-10d\n", 198745);
		System.out.printf("%1$,-10d와 %2$,10d\n", 1000, 2000);

		// String 클래스의 클래스메소드 활용
		String fs = String.format("%,20.2f\n", 198745.678);
		System.out.println(fs);

		System.out.println(String.format("%tY", Calendar.getInstance())); //4자리년도
		System.out.println(String.format("%ty", Calendar.getInstance())); //2자리년도
		System.out.println(String.format("%tm", Calendar.getInstance())); //숫자월 
		System.out.println(String.format("%tB", Calendar.getInstance())); //문자열월
		System.out.println(String.format("%td", Calendar.getInstance())); //일
		System.out.println(String.format("%tA", Calendar.getInstance())); //요일

		System.out.println(String.format("%tH", Calendar.getInstance())); //24시간
		System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); //오전/오후 12시간System.out.println(String.format("%tM", Calendar.getInstance())); //분
		System.out.println(String.format("%tS", Calendar.getInstance())); //초

		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", Calendar.getInstance()));

		// 날짜/시간 합성문자 사용
		System.out.println(String.format("%1$tF %1$tT", Calendar.getInstance()));




	}

}
