import java.util.Map;
import java.util.Set;

/**
 * JVM 환경변수 읽기
 * @author Lee Gwangyong
 *
 */
public class SystemExample {
	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
		Set<String> names = env.keySet();
		for (String name : names) {
			String value = System.getenv(name);
			System.out.println(name + " = " + value);
		}
	}
}
