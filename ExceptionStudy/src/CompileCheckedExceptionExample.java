import java.io.IOException;

/**
 * 예외처리 대상은 오로지 Exception을 확장한  compileCheckedExcetion뿐이다.
 * RuntimeException은 예외 처리 대상이 아니다.
 * @author Lee Gwangyong
 *
 */
public class CompileCheckedExceptionExample {
	
//	public static int readKeyboad() throws IOException{
//		return System.in.read();
//	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("아무키나 눌러봐 : ");
		int c = 0;
		try {
			c = readKeyboad();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("당신이 입력한 키 : " + (char)c);

	}*/
	
	public static void main(String[] args) throws IOException{
		int c = System.in.read();
		System.out.println((char)c);
	}

}
