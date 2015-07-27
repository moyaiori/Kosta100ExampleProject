import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * List interface 수너가 있고, 중복을 허용하는 Collection
 * 
 * @author Lee Gwangyong
 *
 */
public class ListExample {

	public static void main(String[] args) {
		// 동기화 처리가 되어 있지 않음 ArrayList
		// 주로 목록데이터 운송 수단으로 사용
		List list = new ArrayList();

		System.out.println(list.isEmpty());

		list.add("이광용");
		list.add(new Integer(10));
		list.add(500); // auto boxing
		list.add(new Boolean(true));
		list.add(Calendar.getInstance());
		System.out.println(list.add("이광용"));

		System.out.println("저장된 객체의 수 : " + list.size());

		System.out.println("for 문 1");
		for (Object object : list) {
			System.out.println(object);
		}
		
		list.add(0, "박광용");


		System.out.println("for 문 2");
		for (Object object : list) {
			System.out.println(object);
		}
		
		System.out.println(list.get(list.size()-1));
		
		System.out.println(list.indexOf(10));
		System.out.println(list.lastIndexOf(500));
		
		list.set(0, "최광용");
		
		System.out.println(list.get(0));
		
		List subList = list.subList(0, 3);
		
		for (Object object : subList) {
			System.out.println(object);
		}
		
		List<String> list2 = new ArrayList<String>();
		
		
	}

}


















