/**
 * 메인스레드와 별도로 수행되는 사용자 정의 스레드
 * @author Lee Gwangyong
 *
 */
public class UserThread extends Thread {
	
	
	public UserThread(){
		this("사용자정의 스레드");
	}
	
	public UserThread(String name){
		super(name);
	}
	
	/**
	 * 사용자정의 스레드의 엔트리 포인트
	 * JVM에 의해 자동으로 호출되는 콜백 메서드
	 */
	@Override
	public void run() {
		System.out.println(getName() + "시작됨 >>>>>>");
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + " 스레드에서 i 출력 : " + i);
//			yield();
//			suspend();
//			resume();
//			stop();
		}
		System.out.println(getName() + " 종료됨 >>>>>>");
	}
}
