/**
 * �ϻ� ��Ȱ�� �޿� ���� ��ü�� �߻�ȭ�� Ŭ����
 */
public class Payslip {
	// ��ü�� �Ӽ��� �����ϴ� �ν��Ͻ� ������

	// �ν��Ͻ� ������ ���۷��� Ÿ���ϰ�� null�� �ʱ�ȭ �ȴ�.
	// int : 0, ���۷��� : null, float : 0.0, char : 0;
	String name;	// �̸�
	int salary;		// ���޿�
	int tax;		// ����
	int homePay;	// �Ǽ��ɾ�

	// ��ü�� ��ɵ�... (�ν��Ͻ� �޼ҵ�)

	// ���ݰ�� ���
	void calculateTax(double rate){
		tax = (int)(salary * rate);
	}

	// �Ǽ��ɾ� ���
	void calculateHomePay(){
		homePay = salary - tax;
	}


	// ��� �Ӽ� ��� ���
	void allOutput(){
		System.out.println("***************************");
		System.out.println("-------�� �� �� �� ��------");
		System.out.println("---------------------------");
		System.out.println("- ������ : " + name);
		System.out.println("- �޿��� : " + salary);
		System.out.println("- ����   : " + tax);
		System.out.println("- �Ǽ��ɾ� : " + homePay);
		System.out.println("---------------------------");
	}

}
