/**
 * Payslip 생성 및 사용을 위한 애플리케이션 클래스
 */
class PayslipApp {
	public static void main(String[] args)	{

		// 기본타입 변수선언
		int a;
		a = 100;
		
		// 참조 데이터 타입 변수 선언 
		Payslip payslip;	// 4바이트 할당
		// 클래스로부터 인스턴스 생성(메모리 로드)
		payslip = new Payslip();
	//      1   3       2
	// 실행순서
	// 2번에서 하드디스크에서 클래스를 복사해온다.
	// 하지만 메모리가 더 크다.
	// 그래서 바로 복사해오지않고 주소를 넣어준다.(래퍼런스, 2번동작)
	// 1번에 2번의 주소값(래퍼런스)를 3번 동작으로 할당한다.
	// 래퍼런스 데이터타입의 값을 접근할때 "."으로 접근한다. (~~의)

//---------------------------------------------------------------
	// 인스턴스 변수 사용
	// 지역변수와 다르게 인스턴스 변수는 JVM에서 자동 할당(초기화)이된다.
	// 지역변수일 경우 초기화하지않고 사용할경우 컴파일 애러가 나온다.
	
	/*
	System.out.println(payslip.name);
	System.out.println(payslip.salary);
	System.out.println(payslip.tax);
	System.out.println(payslip.homePay);
	*/

	payslip.name = "이광용";
	payslip.salary = 10000000;
	payslip.tax = (int)(payslip.salary * 0.033);
	payslip.homePay = payslip.salary - payslip.tax;

	System.out.println("---------------------------");
	System.out.println("-------급 여 명 세 서------");
	System.out.println("---------------------------");
	System.out.println("- 수령인 : " + payslip.name);
	System.out.println("- 급여액 : " + payslip.salary);
	System.out.println("- 세금   : " + payslip.tax);
	System.out.println("- 실수령액 : " + payslip.homePay);
	System.out.println("---------------------------");
	/*
	System.out.println(payslip.name);
	System.out.println(payslip.salary);
	System.out.println(payslip.tax);
	System.out.println(payslip.homePay);
	*/


	Payslip lee = new Payslip();

	lee.name = "이길동";
	lee.salary = 50000000;
	lee.tax = (int)(payslip.salary * 0.023);
	lee.homePay = payslip.salary - payslip.tax;

	System.out.println("---------------------------");
	System.out.println("-------급 여 명 세 서------");
	System.out.println("---------------------------");
	System.out.println("- 수령인 : " + lee.name);
	System.out.println("- 급여액 : " + lee.salary);
	System.out.println("- 세금   : " + lee.tax);
	System.out.println("- 실수령액 : " + lee.homePay);
	System.out.println("---------------------------");
	
	}
}
