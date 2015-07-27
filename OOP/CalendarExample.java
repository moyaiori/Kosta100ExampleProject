import java.util.Calendar;
public class CalendarExample {
	public static void main(String[] args)	{
		//팩토리 메소드를 이용한 인스턴스 생성
		Calendar today = Calendar.getInstance();
		int value = today.get(Calendar.AM_PM);
		//System.out.println(value);

		switch (value){
		case Calendar.AM : System.out.println("오전입니다"); break;
		case Calendar.PM : System.out.println("오후입니다"); break;
		}

		// 2015-07-14 12:23:34 화요일

		String week;

		switch (Calendar.DAY_OF_WEEK){
			case	Calendar.SUNDAY: week = "일요일"; break;
			case	Calendar.MONDAY: week = "월요일"; break;
			case   Calendar.TUESDAY: week = "화요일"; break;
			case Calendar.WEDNESDAY: week = "수요일"; break;
			case  Calendar.THURSDAY: week = "목요일"; break;
			case    Calendar.FRIDAY: week = "금요일"; break;
			case  Calendar.SATURDAY: week = "토요일"; break;
			default : week = "날짜가 없습니다";
		}

		System.out.println(
			today.get(Calendar.YEAR) + "-" + 
			(today.get(Calendar.MONTH)+ 1) + "-" +
			today.get(Calendar.DAY_OF_MONTH) + "- "+
			today.get(Calendar.HOUR_OF_DAY) + ":" +
			today.get(Calendar.MINUTE) + ":" +
			today.get(Calendar.SECOND) + " " +
			week
			);

		System.out.println(Calendar.SATURDAY);
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.DAY_OF_WEEK);

	}
}
