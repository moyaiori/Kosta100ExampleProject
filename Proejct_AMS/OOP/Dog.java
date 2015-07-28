public class Dog extends Animal{
	// �Ӽ� �� ��� �߰�
	protected boolean loyalty;

	public Dog(){
		// super(); �����Ͻ� �ڵ��߰�
		this(null, 0, false);
	}
	public Dog(String name, int age, boolean loyalty){
		//usper();
		super(name, age);
		this.loyalty = loyalty;
	}

	public void guard(){
		System.out.println("���� ��Ų��.");
	}

	// ������(Overriding)
	public void eat(){
		System.out.println("���ִ� ���̸� �Խ��ϴ�");
	}

	public void bark(){
		System.out.println("���ۻ���� ���� ���¢�´�.");
	}

	// Object�� toString() ������
	public String toString(){
		//super.toString();
		return "Dog[name = " + name + ",age = " + age + ", loyalty = " + loyalty + "]";
	}
}
