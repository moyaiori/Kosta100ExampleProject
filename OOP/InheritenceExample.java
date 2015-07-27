public class InheritenceExample {
	public static void main(String[] args)	{
		//Animal animal = new Animal("인간",100);
		Dog dog = new Dog();
		
		// 재사용
		dog.name = "개";
		dog.age = 3;
		dog.bark();
		dog.eat();

		// object의 toString()
		System.out.println(dog.toString());
		System.out.println(dog);

		// 추가 테스트
		dog.loyalty = false;
		dog.guard();
	}
}
