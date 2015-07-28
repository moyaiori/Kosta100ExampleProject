public class SystemExample {
	public static void main(String[] args)	throws Exception {
		//System.out.println();
		//System.in.read();
		// JVM 강제 종료
		//System.exit(0);

		// 가비지 콜렉터 실행
		//System.gc();

		System.currentTimeMillis();

		System.out.println("프로그램 종료됨");
		System.out.println(System.currentTimeMillis());

		int[] srcArray = {1,2,3,4,5};
		int[] destArray = new int[10];

		System.arraycopy(srcArray, 0, destArray, 0, 5);
		
		for (int value : destArray){
			System.out.println(value);
		}

		// OS 추상화 클래스
		Runtime os = Runtime.getRuntime();
		// 프로세스 실행
		os.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	}
}
