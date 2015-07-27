import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 순서없이 중복없이 데이터 관리를 위한 규약(interface)
 * @author Lee Gwangyong
 *
 */
public class SetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		
		System.out.println(set.isEmpty());
		
		set.add("이광용");
		set.add(new Integer(10));
		set.add(500); // auto boxing
		set.add(new Boolean(true));
		set.add(Calendar.getInstance());
		System.out.println(set.add("이광용"));
		

		System.out.println("저장된 객체의 수 : " + set.size());
		
		// 보따리에 작은 보따리 담기
		Set sub = new HashSet();
		sub.add("aa");
		sub.add("bb");
		sub.add("cc");
		
		set.addAll(sub);

		System.out.println("저장된 객체의 수 : " + set.size());
		
		/*
		ok = set.remove("이광용");
		if(ok){
			System.out.println("삭제완료");
		}else{
			System.out.println("삭제하고자 하는 객체가 존재하지않습니다.");
		}
		
		
		System.out.println(set.removeAll(sub));
		System.out.println("저장된 객체의 수 : " + set.size());
		
		System.out.println(set.contains(10)); // 값이 있는지 확인
		*/
		
		
		System.out.println("toArray 시작");
		Object[] list = set.toArray();
		for (Object object : set) {
//			System.out.println(object);
			if (object instanceof Integer) {
				Integer y = (Integer)object;
				int x = y.intValue();
				System.out.println(x);
			}
		}
		System.out.println("Iterator 시작");
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Object object = iter.next();
			System.out.println(object);
		}
		
		
		//---------------------- 정렬 개념을 적용한 Treeset
		// 트리 정렬 알고리즘이 적용되어있다.
		Set tree = new TreeSet();
		tree.add("BBB");
		tree.add("AAA");
		tree.add("CCC");
		
		for (Object object : tree) {
			System.out.println(object);
		}
		
		
		// 제네릭 클래스 답게 사용하기
		Set<String> set2 = new HashSet<String>();
		set2.add("aaa");
		set2.add("bbb");
		set2.add("ccc");
		
		for (String string : set2) {
			System.out.println(string);
		}
		
	}
	
	

}

















