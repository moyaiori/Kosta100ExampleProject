public class SystemExample {
	public static void main(String[] args)	throws Exception {
		//System.out.println();
		//System.in.read();
		// JVM ���� ����
		//System.exit(0);

		// ������ �ݷ��� ����
		//System.gc();

		System.currentTimeMillis();

		System.out.println("���α׷� �����");
		System.out.println(System.currentTimeMillis());

		int[] srcArray = {1,2,3,4,5};
		int[] destArray = new int[10];

		System.arraycopy(srcArray, 0, destArray, 0, 5);
		
		for (int value : destArray){
			System.out.println(value);
		}

		// OS �߻�ȭ Ŭ����
		Runtime os = Runtime.getRuntime();
		// ���μ��� ����
		os.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	}
}
