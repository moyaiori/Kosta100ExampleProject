/**
 * Ŭ���� ����ȯ, up casting�� down casting �׽�Ʈ
 */

public class ClassCastingExample {
	public static void main(String[] args)	{
		// up casting
		Animal animal = new Dog("�۸���",10,false);
		System.out.println(animal.name);
		System.out.println(animal.age);
		
		animal.eat();
		animal.bark();

		// upcasing �������
		//System.out.println(animal.loyalty);

		// ��������� �ذ��ϱ����� Down casting �ʿ�
		Dog dog = (Dog)animal;
		System.out.println(dog.loyalty);
		dog.guard();
	}
}
