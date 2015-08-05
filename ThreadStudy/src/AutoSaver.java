
public class AutoSaver extends Thread {
	
	private boolean stop;
	
	@Override
	public void run() {
		while (!stop){
			System.out.println("파일에 저장");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("메인 스레드 시작");
		AutoSaver saver = new AutoSaver();
		saver.setDaemon(true);
		saver.start();
		System.out.println("메인 스레드 종료");
	}
}
