/**
 * 클래스 형변환, up casting과 down casting 테스트
 */

public class ClassCastingExample {
	public static void main(String[] args)	{
		// up casting
		Animal animal = new Dog("멍멍이",10,false);
		System.out.println(animal.name);
		System.out.println(animal.age);
		
		animal.eat();
		animal.bark();

		// upcasing 제약사항
		//System.out.println(animal.loyalty);

		// 제약사항을 해결하기위해 Down casting 필요
		Dog dog = (Dog)animal;
		System.out.println(dog.loyalty);
		dog.guard();
	}
}
