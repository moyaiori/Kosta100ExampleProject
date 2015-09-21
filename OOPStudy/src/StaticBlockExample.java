/**
 * static 초기화 블럭 
 * @author Lee Gwangyong
 *
 */
public class StaticBlockExample {
	
	int x;
	static int y;
	
	
	static {
		y = 100;
		System.out.println("static 초기화 블럭 실행됨...");
	}
	
	public StaticBlockExample(){
		x = 10;
		System.out.println("생성자 호출됨...");
		
	}
	

	public static void main(String[] args) {
		StaticBlockExample ex = new StaticBlockExample();

	}

}
