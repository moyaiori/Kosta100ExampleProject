import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/**
 * 다이나믹 객체를 위한 클래스
 * map을 이용하여 구현
 * @author Lee Gwangyong
 *
 */
public class Person {
	private Hashtable<String, Object> attributes;
	
	public Person(){
		attributes = new Hashtable<String, Object>();
	}

	public Hashtable<String, Object> getAttributes() {
		return attributes;
	}
	
	public void setAttribute(String key, Object value){
		if (attributes.containsKey(key)) {
			//실제 실행시켜봐야 아는 예외사항인경우 runtimeException을 발생시킨다.
			throw new RuntimeException("이미 존재하는 키입니다.");
		}
		attributes.put(key, value);
	}
	
	public Object getAttribute(String key){
		return attributes.get(key);
	}

	@Override
	public String toString() {
		Enumeration<String> resultKey = attributes.keys();
		StringBuilder resultString = new StringBuilder();
		resultString.append("Person[");
		while (resultKey.hasMoreElements()) {
			String string = resultKey.nextElement();
			Object value = attributes.get(string);
			resultString.append(string + " : " + value + ",");
		}
		resultString.delete(resultString.length() - 1, resultString.length());
		resultString.append("]");
		
		return resultString.toString();
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		person.setAttribute("name", "이광용");
		person.setAttribute("age", 28);
		System.out.println(person);
	}
	
	
}













