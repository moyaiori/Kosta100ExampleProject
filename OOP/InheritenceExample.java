public class InheritenceExample {
	public static void main(String[] args)	{
		//Animal animal = new Animal("�ΰ�",100);
		Dog dog = new Dog();
		
		// ����
		dog.name = "��";
		dog.age = 3;
		dog.bark();
		dog.eat();

		// object�� toString()
		System.out.println(dog.toString());
		System.out.println(dog);

		// �߰� �׽�Ʈ
		dog.loyalty = false;
		dog.guard();
	}
}
