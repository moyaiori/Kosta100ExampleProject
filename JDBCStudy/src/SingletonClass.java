/**
 * 싱글톤 디자인 패턴 적용
 * @author Lee Gwangyong
 *
 */
public class SingletonClass {
	
	private static SingletonClass instance;
	
	private SingletonClass(){}
	
	public static SingletonClass getInstance(){
		if (instance == null) {
			synchronized (SingletonClass.class) {
				instance = new SingletonClass();
			}
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		SingletonClass sc3 = SingletonClass.getInstance();
		SingletonClass sc4 = SingletonClass.getInstance();
		SingletonClass sc5 = SingletonClass.getInstance();
		
		System.out.println(sc1);
		System.out.println(sc2);
		System.out.println(sc3);
		System.out.println(sc4);
		System.out.println(sc5);
	}
}
