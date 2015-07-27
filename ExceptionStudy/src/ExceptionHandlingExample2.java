/**
 * 클래스 형변환 try~catch 구문
 * @author 김기정
 *
 */
public class ExceptionHandlingExample2 {
	// 애플리케이션 엔트리포인트
	public static void main(String[] args) {
		System.out.println("애플리케이션 시작됨...");
		
		try{
			// 이해를 돕기위한 예외 강제 발생
//			String str = null;
//			System.out.println(str.length());	
			//JVA에 의해 new NullPointerException("???"); 생성됨..
			
			int x = 150;
			System.out.println( x / 0);
			
		}catch(Exception e){		// Exception의 자식들만 들어올수 있도록 instanseof로 처리한다
			// 예외 직접 처리 코드..
//			String exceptionMessage = e.getMessage();
//			String exceptionMessage = e.toString();
			System.out.println(e.toString()+"예외가 발생하였습니다.");
			// 디버깅용 Exception의 공통 기능...
			e.printStackTrace();
		}
		
		System.out.println("애플리케이션 종료됨...");
	}

}
