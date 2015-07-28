/**
 * 모든 동물들의 공통적인 속성과 기능을 정의한 슈퍼클래스
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
		System.out.println("먹습니다");
	}

	public void bark(){
		System.out.println("울부짖는다.");
	}
}
