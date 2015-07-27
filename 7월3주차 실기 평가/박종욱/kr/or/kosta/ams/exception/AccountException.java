package kr.or.kosta.ams.exception;
/**
 * 사용자 정의 예외 클래스(업무예외)
 * @author 박종욱
 */
public class AccountException extends Exception {
	
	//private String message;
	private int errorCode;
	
	public AccountException(){
		this("예기치 못한 에러가 발생하였습니다. 관리자(admin@kosta.or.kr)에게 문의바람.", 100);
	}
	public AccountException(String message, int errorCode) {
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
		//return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
		return errorCode + " : " + getMessage();
	}
}
