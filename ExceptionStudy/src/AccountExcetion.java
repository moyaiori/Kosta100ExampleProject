/**
 * 사용자 정의 예외 클래스(업무예외)
 * @author Lee Gwangyong
 *
 */
public class AccountExcetion extends Exception {
//	private String message;
	private int errorCode;
	
	public AccountExcetion() {
		// 자주쓰는 애러 메시지
		this("예기치 못한 애러가 발생하였습니다. 자세한 문의는 1111-2222로 하십시오",100);
	}

	public AccountExcetion(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
//		return "AccountExcetion [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
		return errorCode + ":" + getMessage();
	}
	
	
	
}
