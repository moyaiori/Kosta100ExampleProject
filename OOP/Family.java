/**
 * ���� �߻�ȭ Ŭ����
 */
public class Family {
	// �ν��Ͻ� ����
	String role;				//���� ����
	String name;				//�̸�
	int age;					//����
	//Ŭ���� ����(static ����)
	static String telephone = "02-222-3333";	//��ȭ��ȣ
	static String address = "���� �����д���";		//�ּ�

	public final static int MAX = 100;

	public Family(){
		this(null, null, 0);
	}

	public Family(String role, String name, int age){
		this.role = role;
		this.name = name;
		this.age = age;
	}

	/**
	 * ���Ӽ��� ���ڿ��� ��ȯ
	 */
	public String toString(){
		return role + "\t" + name + "\t" + age;
	}

	// ���� ���
	// Ŭ����(static) �޼ҵ�
	public static void openDoor(){
		System.out.println("���� ���ÿ�!");
	}

	
	public static void main(String[] args)	{
		Family father;
		father = new Family("�ƺ�","�̱���",45);
		Family mother = new Family("����","�豤��",40);

		String etc = Family.telephone + "\t" + Family.address;

		System.out.println(father.toString() + "\t" + etc);
		System.out.println(mother.toString() + "\t" + etc);

		Family.openDoor();

		// ǥ�� API�� MathŬ������ static �޼ҵ� ȣ��
		System.out.println(Math.abs(-10));

		System.out.println(Family.MAX);
		//Family.MAX = 500;
		System.out.println(Math.E);
		System.out.println(Math.PI);

		int radian = 5;
		System.out.println(Math.PI * Math.pow(radian, 2));
	}
}
