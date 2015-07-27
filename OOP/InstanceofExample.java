public class InstanceofExample {
	public static void main(String[] args)	{
		Circle circle = new Circle(10, 10, 5);
		System.out.println(circle instanceof Circle);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Object);

		if (circle instanceof Object){
			// 이런식으로 하면 항상 true이기때문에 구분이 안된다.
		}

		Object array = new int[10];
		System.out.println(((int[])array).length); // 새로운 추가된것이라서 안된다.
		System.out.println(array.toString());


		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1.equals(obj2)); // ==와 동일(주소비교) object의 equals는 값이 아닌 주소를 비교한다.

		String str1 = "Java";
		String str2 = "Java";
		System.out.println(str1.equals(str2)); //

		Account acc1 = new Account("1111","이광용",1111,100);
		Account acc2 = new Account("1111","이광용",1111,100);
		System.out.println(acc1.equals(acc2)); // 문제가 발생할 가능성이 존재한다. equals 오버라이딩
		

	}
}
