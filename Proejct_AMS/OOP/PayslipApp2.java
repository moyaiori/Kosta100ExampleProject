/**
 * 기능과 속성을 모두 가지고있는 클래스
 */
class PayslipApp2 {
	public static void main(String[] args)	{

		Payslip kim = new Payslip();

		kim.name = "김길동";
		kim.salary = 50000000;
		kim.calculateTax(0.033);
		kim.calculateHomePay();
		kim.allOutput();

		
		Payslip park = new Payslip();

		park.name = "박길동";
		park.salary = 55000000;
		park.calculateTax(0.035);
		park.calculateHomePay();
		park.allOutput();
	}
}
