/**
 * throws 키워드를 이용한 예외 직접 처리
 * @author 김기정
 *
 */
public class ThrowsExceptionHandlingExample {
	
	public static void test() throws ArithmeticException, NullPointerException{
//		System.out.println(19/0);
		String str = null;
		System.out.println(str.length());
	}
	
	// 애플리케이션 엔트리포인트
	public static void main(String[] args) {
		System.out.println("애플리케이션 시작됨...");
		
		try{
			test();
		}catch(ArithmeticException e){
			e.printStackTrace();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("애플리케이션 종료됨...");
	}

}
