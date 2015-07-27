/**
 * try~catch 구문을 이용한 예외 직접 처리
 * @author 김기정
 *
 */
public class ExceptionHandlingExample {
	
	public static void test(){
		try{
//			int[] array = {1, 2, 3, 4, 5};
//			System.out.println(array[0]);
//			System.out.println(array[1]);
//			System.out.println(array[5]);
			return;
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}finally {
			System.out.println("finally 실행");
		}
		
	}
	
	// 애플리케이션 엔트리포인트
	public static void main(String[] args) {
		System.out.println("애플리케이션 시작됨...");
		
		try{
			// 이해를 돕기위한 예외 강제 발생
//			String str = null;
//			System.out.println(str.length());	
			//JVA에 의해 new NullPointerException("???"); 생성됨..
			
//			int x = 150;
//			System.out.println( x / 0);
			
		}catch(NullPointerException e){
			// 예외 직접 처리 코드..
//			String exceptionMessage = e.getMessage();
			String exceptionMessage = e.toString();
			System.out.println(exceptionMessage+"예외가 발생하였습니다.");
			// 디버깅용 Exception의 공통 기능...
			e.printStackTrace();
		}catch(ArithmeticException e){
			// 예외 직접 처리 코드..
			System.out.println(e.toString() +"예외가 발생하였습니다.");
			e.printStackTrace();
		}finally {
			// 예외 발생 여부와 관계없이 항상 처리되어야 하는 코드블럭..
			System.out.println("리소스 해제함");
		}
		
		test();
		
		System.out.println("애플리케이션 종료됨...");
	}

}
