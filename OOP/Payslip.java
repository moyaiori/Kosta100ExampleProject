/**
 * 일상 생활의 급여 명세서 객체를 추상화한 클래스
 */
public class Payslip {
	// 객체의 속성을 정의하는 인스턴스 변수셋

	// 인스턴스 변수가 래퍼런스 타입일경우 null로 초기화 된다.
	// int : 0, 래퍼런스 : null, float : 0.0, char : 0;
	String name;	// 이름
	int salary;		// 월급여
	int tax;		// 세금
	int homePay;	// 실수령액

	// 객체의 기능들... (인스턴스 메소드)

	// 세금계산 기능
	void calculateTax(double rate){
		tax = (int)(salary * rate);
	}

	// 실수령액 계산
	void calculateHomePay(){
		homePay = salary - tax;
	}


	// 모든 속성 출력 기능
	void allOutput(){
		System.out.println("***************************");
		System.out.println("-------급 여 명 세 서------");
		System.out.println("---------------------------");
		System.out.println("- 수령인 : " + name);
		System.out.println("- 급여액 : " + salary);
		System.out.println("- 세금   : " + tax);
		System.out.println("- 실수령액 : " + homePay);
		System.out.println("---------------------------");
	}

}
