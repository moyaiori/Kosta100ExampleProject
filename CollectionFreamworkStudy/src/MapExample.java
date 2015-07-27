import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("이광용", "01-1111-2222");
		System.out.println(map.containsKey("이광용"));
		map.put("박광용", "02-2222-3333");
		map.put("김광용", "03-3333-4444");
		map.put("최광용", "04-4444-5555");
		
		System.out.println(map.get("이광용"));
		
		System.out.println(map.size());
		
		// 키 목록 가져오기
		Set<String> keys = map.keySet();
		for (String key : keys) {
//			System.out.println(key);
			System.out.println(key + " : " + map.get(key));
		}
		
		//값 목록
		Collection<String> value = map.values();
		for (String string : value) {
			System.out.println(string);
		}
		
	}

}
