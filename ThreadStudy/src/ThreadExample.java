/**
 * 
 * @author Lee Gwangyong
 *
 */
public class ThreadExample {
	
	/**
	 * JVM에 의해 자동으로 생성되는 메인스레드에 의해 최초 호출되는
	 * 엔트리 포인트
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("메인 스레드 시작됨 >>>>>>");
		
		for (int i = 0; i < 100; i++) {
			System.out.println("메인 스레드에서 i 출력" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 50) {
				// 메인스레드와 독립적으로 수행되는 스레드 생성 및 실행
				SomeThread st = new SomeThread("some");
				st.start();
				
				// runnable 인터페이스로 구현한 경우
				SomeThread2 st2 = new SomeThread2();
				Thread thread = new Thread(st2);
				thread.start();
			}
		}
		
		
		
		
		
		
		
		
		
		System.out.println("메인 스레그 종료됨 >>>>>>");
	}

}
