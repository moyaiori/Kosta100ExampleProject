/**
 * ��ɰ� �Ӽ��� ��� �������ִ� Ŭ����
 */
class PayslipApp2 {
	public static void main(String[] args)	{

		Payslip kim = new Payslip();

		kim.name = "��浿";
		kim.salary = 50000000;
		kim.calculateTax(0.033);
		kim.calculateHomePay();
		kim.allOutput();

		
		Payslip park = new Payslip();

		park.name = "�ڱ浿";
		park.salary = 55000000;
		park.calculateTax(0.035);
		park.calculateHomePay();
		park.allOutput();
	}
}
