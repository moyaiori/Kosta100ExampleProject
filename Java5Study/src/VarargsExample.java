/**
 * Java5의 가변인자 처리
 * @author 이광용
 * 2015-07-16 오후 04:15
 */
public class VarargsExample {
	
	public static int sum(int... values){
		int sum = 0;
		for (int i : values) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		System.out.println(sum(10,20,30));
		System.out.println(sum(1,2,3,4,5));
		
		String str = "java king";
		str = str + "킹!";
		System.out.println(str);
	
	
		int a = 10;
		System.out.println(--a);
		System.out.println(a--);
		
		
		
	}

}
