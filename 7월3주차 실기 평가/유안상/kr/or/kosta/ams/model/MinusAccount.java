package kr.or.kosta.ams.model;
/**
 * Account 클래스를 상속받은 MinusAccount 클래스
 */
public class MinusAccount extends Account{
	// 속성 추가
	private long borrowMoney;
	
	public MinusAccount(){
		this(null, null, 0, 0L, 0L);
	}
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney){
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney){
		this.borrowMoney = borrowMoney;
	}

	public long getBorrowMoney(){
		return borrowMoney;
	}
	
	// 재정의
	public long getRestMoney(){
		return (super.getRestMoney()-borrowMoney); // restMoney가 private 속성이므로 접근불가능 - getRestMoney를 이용하여 접근한다.
												   // super는 부모클래스를 지칭한다(재귀방지)
	}
	public String toString(){
		return String.format("마이너스 %10s %-18s %-18s %,-21d %,-20d",    " ", getAccountNum(), getAccountOwner(), getRestMoney(), borrowMoney);
	}
}