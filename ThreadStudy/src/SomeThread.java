/**
 * 메인스레드와 별도로 수행되는 사용자 정의 스레드
 * @author Lee Gwangyong
 *
 */
public class SomeThread extends Thread {
	
	
	public SomeThread(){
		this("사용자정의 스레드");
	}
	
	public SomeThread(String name){
		super(name);
	}
	
	/**
	 * 사용자정의 스레드의 엔트리 포인트
	 * JVM에 의해 자동으로 호출되는 콜백 메서드
	 */
	@Override
	public void run() {
		System.out.println("메인 스레드 시작됨 >>>>>>");
		for (int i = 0; i < 100; i++) {
			System.out.println("사용자 스레드에서 i 출력 : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("메인 스레드 종료됨 >>>>>>");
	}
}
