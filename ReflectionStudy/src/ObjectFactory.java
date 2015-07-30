import java.util.Random;
import java.util.Vector;

/**
 * 모든 자바 객체를 생성하여 반환하는 팩토리
 * @author Lee Gwangyong
 *
 */
public class ObjectFactory {
	
	public static Object create(String className){
		
		Object obj = null;
		
		// 컴파일 예외처리를 런타임 예외처리로 변경
		try {
			Class cls = Class.forName(className);
			obj = cls.newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		// 오버로딩으로 인해 재정의, 코드가 지져분해질수있어서 기존껄로 사용
//		Class cls = null;
//		try {
//			cls = Class.forName(className);
//			obj = create(cls);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return obj;
	}
	
public static Object create(Class cls){
		
		Object obj = null;
		
		// 컴파일 예외처리를 런타임 예외처리로 변경
		try {
			obj = cls.newInstance();
		} catch (Exception e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return obj;
	}
	
	public static void main(String[] args) {
		Object obj = ObjectFactory.create("java.util.Random");
		Random random = (Random)obj;
		System.out.println(random.nextInt());
		
		ObjectFactory.create(Vector.class);
	}
}
