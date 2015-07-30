import java.util.Vector;

/**
 * Class 클래스를 이용하여 유연하게 객체 생성
 * @author Lee Gwangyong
 *
 */
public class ReflectionExample2 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		Vector vertor = new Vector();
		String className = "java.util.Vector";
		Object obj = Class.forName(className).newInstance();	// 디폴트 생성자로 객체 생성ㄴ
		Vector vector = (Vector)obj;
		
		System.out.println(vector instanceof Vector);
		
		vector.addElement("");
	}


}




















