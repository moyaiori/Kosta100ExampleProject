public class Calculator {

	// �޼ҵ� �����ε�(�ߺ�����)
	public static int sum(int x, int y){
		return x + y;
	}

	public static double sum(double x, double y){
		return x + y;
	}

	public static void main(String[] args)	{
		int a = 50, b = 30;
		System.out.println(Calculator.sum(a,b));
		System.out.println(Calculator.sum(23.5,67.8));
	}
}
