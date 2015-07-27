public class Dog extends Animal{
	// 속성 및 기능 추가
	protected boolean loyalty;

	public Dog(){
		// super(); 컴파일시 자동추가
		this(null, 0, false);
	}
	public Dog(String name, int age, boolean loyalty){
		//usper();
		super(name, age);
		this.loyalty = loyalty;
	}

	public void guard(){
		System.out.println("집을 지킨다.");
	}

	// 재정의(Overriding)
	public void eat(){
		System.out.println("맛있는 먹이를 먹습니다");
	}

	public void bark(){
		System.out.println("나쁜사람을 보면 울부짖는다.");
	}

	// Object의 toString() 재정의
	public String toString(){
		//super.toString();
		return "Dog[name = " + name + ",age = " + age + ", loyalty = " + loyalty + "]";
	}
}
