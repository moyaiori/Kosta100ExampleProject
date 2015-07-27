/**
 * 가족 추상화 클래스
 */
public class Family {
	// 인스턴스 변수
	String role;				//가족 역할
	String name;				//이름
	int age;					//나이
	//클래스 변수(static 변수)
	static String telephone = "02-222-3333";	//전화번호
	static String address = "가산 디지털단지";		//주소

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
	 * 모든속성을 문자열로 반환
	 */
	public String toString(){
		return role + "\t" + name + "\t" + age;
	}

	// 공통 기능
	// 클래스(static) 메소드
	public static void openDoor(){
		System.out.println("문을 여시오!");
	}

	
	public static void main(String[] args)	{
		Family father;
		father = new Family("아빠","이광용",45);
		Family mother = new Family("엄마","김광용",40);

		String etc = Family.telephone + "\t" + Family.address;

		System.out.println(father.toString() + "\t" + etc);
		System.out.println(mother.toString() + "\t" + etc);

		Family.openDoor();

		// 표준 API의 Math클래스의 static 메소드 호출
		System.out.println(Math.abs(-10));

		System.out.println(Family.MAX);
		//Family.MAX = 500;
		System.out.println(Math.E);
		System.out.println(Math.PI);

		int radian = 5;
		System.out.println(Math.PI * Math.pow(radian, 2));
	}
}
