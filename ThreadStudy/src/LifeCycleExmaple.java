
public class LifeCycleExmaple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserThread t1 = new UserThread("PARK");
		UserThread t2 = new UserThread("KIM");
		
		//우선순위 부여
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		// 메인 스레드 접근
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		System.out.println(mainThread.getPriority());

	}

}
