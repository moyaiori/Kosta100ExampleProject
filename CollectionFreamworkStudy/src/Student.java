/**
 * 제너릭 탙입을 이용한 제너릭 클래스 정의
 * @author Lee Gwangyong
 *
 * @param <T>
 */
public class Student<T> {
	private T ssn;
	private String name;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student(T ssn, String name) {
		super();
		this.ssn = ssn;
		this.name = name;
	}


	public T getSsn() {
		return ssn;
	}

	public void setSsn(T ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [ssn=" + ssn + ", name=" + name + "]";
	}
	
	public static void main(String[] args) {
		Student<String> student1 = new Student<String>("987654321","이광용");
//		student1.setSsn("123456789");
		
		// 타입은 무조건 Object형이다
		Student<Integer> student2 = new Student<Integer>(1234, "홍길동");
	}
	
	
}
