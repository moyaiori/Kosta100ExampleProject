/**
 * ��� �������� �������� �Ӽ��� ����� ������ ����Ŭ����
 */

public class Animal/* extends Object */ {
	
	protected String name;
	protected int age;

	public Animal(){
		this(null, 0);
	}
	
	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}

	public void eat(){
		System.out.println("�Խ��ϴ�");
	}

	public void bark(){
		System.out.println("���¢�´�.");
	}
}
