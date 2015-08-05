
public class SomeThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("메인 스레드 시작됨 >>>>>>");
		for (int i = 0; i < 100; i++) {
			System.out.println("사용자 스레드에서 i 출력 : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("메인 스레드 종료됨 >>>>>>");
	}

}
