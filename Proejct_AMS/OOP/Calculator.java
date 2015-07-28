public class Calculator {

	// 메소드 오버로딩(중복정의)
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
