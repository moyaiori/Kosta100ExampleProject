import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

/**
 * Class 클래스를 얻기 위한 3가지 방법
 * @author Lee Gwangyong
 *
 */
public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException {
		String message = "리플렉션이 머예요???";
		
		// #1. Object의 getClass(); 를 이용하기
		Class cls = message.getClass();
		
		
		// #2. Class.ForName("");
//		Class cls = Class.forName("java.lang.Integer");
		
//		new Integer(10).
		
		// #3. 클래스이름.class
//		cls = Vector.class;
		
		
		int md =  cls.getModifiers();
		System.out.println(md);
//		System.out.println(Modifier.FINAL);
		
		switch (md) {
		case Modifier.PUBLIC + Modifier.FINAL:
			System.out.println("public final 입니다.");
			break;
		}
		
		// 클래스 이름
		System.out.println(cls.getName());
		
		//클래스 속성들
		Field[] attributes = cls.getFields();
		
		for (Field field : attributes) {
			System.out.println(field);
		}
		
		//클래스 생성자
		Constructor[] constructors = cls.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		
		//클래스 메서드
		Method[] method = cls.getMethods();
		for (Method method2 : method) {
//			System.out.println(method2);
			System.out.println(method2.getName());
		}
	}


}




















