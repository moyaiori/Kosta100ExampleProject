import java.util.Calendar;
public class CalendarExample {
	public static void main(String[] args)	{
		//���丮 �޼ҵ带 �̿��� �ν��Ͻ� ����
		Calendar today = Calendar.getInstance();
		int value = today.get(Calendar.AM_PM);
		//System.out.println(value);

		switch (value){
		case Calendar.AM : System.out.println("�����Դϴ�"); break;
		case Calendar.PM : System.out.println("�����Դϴ�"); break;
		}

		// 2015-07-14 12:23:34 ȭ����

		String week;

		switch (Calendar.DAY_OF_WEEK){
			case	Calendar.SUNDAY: week = "�Ͽ���"; break;
			case	Calendar.MONDAY: week = "������"; break;
			case   Calendar.TUESDAY: week = "ȭ����"; break;
			case Calendar.WEDNESDAY: week = "������"; break;
			case  Calendar.THURSDAY: week = "�����"; break;
			case    Calendar.FRIDAY: week = "�ݿ���"; break;
			case  Calendar.SATURDAY: week = "�����"; break;
			default : week = "��¥�� �����ϴ�";
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
