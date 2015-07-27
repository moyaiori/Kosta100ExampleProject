package kr.or.kosta.ams.model;
import kr.or.kosta.ams.exception.AccountException; 
/**
 * 은행계좌 객체 추상화(모델링)
 */
public class Account {
	// 상수
	public final static String BANK_NAME = "KOSTA";
	// 속성
	private String formatString;
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	/** 생성자 오버로딩 */
	public Account(){
		this(null,null,0,0);
	}
	public Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}
	// setter/getter 메소드 정의
	public void setAccountNum(String accountNum){
		this.accountNum = accountNum;
	}
	public String getAccountNum(){
		return accountNum;
	}
	public void setAccountOwner(String accountOwner){
		this.accountOwner = accountOwner;
	}
	public String getAccountOwner(){
		return accountOwner;
	}
	public void setPasswd(int passwd){
		this.passwd = passwd;
	}
	public int getPasswd(){
		return passwd;
	}
	public void setRestMoney(long restMoney){
		this.restMoney = restMoney;
	}
	public long getRestMoney(){
		return restMoney;
	}
	public String toString(){
		formatString = String.format("일반계좌 %10s %-18s %-18s %,d",    " ", accountNum, accountOwner, restMoney);
		return formatString;
	}
}