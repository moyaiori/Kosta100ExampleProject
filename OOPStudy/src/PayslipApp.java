/**
 * Payslip ���� �� ����� ���� ���ø����̼� Ŭ����
 */
class PayslipApp {
	public static void main(String[] args)	{

		// �⺻Ÿ�� ��������
		int a;
		a = 100;
		
		// ���� ������ Ÿ�� ���� ���� 
		Payslip payslip;	// 4����Ʈ �Ҵ�
		// Ŭ�����κ��� �ν��Ͻ� ����(�޸� �ε�)
		payslip = new Payslip();
	//      1   3       2
	// �������
	// 2������ �ϵ��ũ���� Ŭ������ �����ؿ´�.
	// ������ �޸𸮰� �� ũ��.
	// �׷��� �ٷ� �����ؿ����ʰ� �ּҸ� �־��ش�.(���۷���, 2������)
	// 1���� 2���� �ּҰ�(���۷���)�� 3�� �������� �Ҵ��Ѵ�.
	// ���۷��� ������Ÿ���� ���� �����Ҷ� "."���� �����Ѵ�. (~~��)

//---------------------------------------------------------------
	// �ν��Ͻ� ���� ���
	// ���������� �ٸ��� �ν��Ͻ� ������ JVM���� �ڵ� �Ҵ�(�ʱ�ȭ)�̵ȴ�.
	// ���������� ��� �ʱ�ȭ�����ʰ� ����Ұ�� ������ �ַ��� ���´�.
	
	/*
	System.out.println(payslip.name);
	System.out.println(payslip.salary);
	System.out.println(payslip.tax);
	System.out.println(payslip.homePay);
	*/

	payslip.name = "�̱���";
	payslip.salary = 10000000;
	payslip.tax = (int)(payslip.salary * 0.033);
	payslip.homePay = payslip.salary - payslip.tax;

	System.out.println("---------------------------");
	System.out.println("-------�� �� �� �� ��------");
	System.out.println("---------------------------");
	System.out.println("- ������ : " + payslip.name);
	System.out.println("- �޿��� : " + payslip.salary);
	System.out.println("- ����   : " + payslip.tax);
	System.out.println("- �Ǽ��ɾ� : " + payslip.homePay);
	System.out.println("---------------------------");
	/*
	System.out.println(payslip.name);
	System.out.println(payslip.salary);
	System.out.println(payslip.tax);
	System.out.println(payslip.homePay);
	*/


	Payslip lee = new Payslip();

	lee.name = "�̱浿";
	lee.salary = 50000000;
	lee.tax = (int)(payslip.salary * 0.023);
	lee.homePay = payslip.salary - payslip.tax;

	System.out.println("---------------------------");
	System.out.println("-------�� �� �� �� ��------");
	System.out.println("---------------------------");
	System.out.println("- ������ : " + lee.name);
	System.out.println("- �޿��� : " + lee.salary);
	System.out.println("- ����   : " + lee.tax);
	System.out.println("- �Ǽ��ɾ� : " + lee.homePay);
	System.out.println("---------------------------");
	
	}
}
