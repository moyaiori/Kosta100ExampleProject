package kr.or.kosta.ams.model;

/*
	Account를 상속하는 마이너스계좌
*/

public class MinusAccount extends Account{
	
	private long borrowMoney;
	public MinusAccount(){
		this(null,null,0,0L,0L);
	}
	public MinusAccount(String accountNum, String accounOwner, int passwd, long restMoney,long borrowMoney){
		super(accountNum,accounOwner,passwd,restMoney);  //부모클래스걸 초기화: 부모클래스에서 private일때 super사용
		this.borrowMoney=borrowMoney;   //자기자신걸 초기화
	}

	//-------------형식상 set/get만들기
	public void setBorrowMoney(long borrowMoney){
		this.borrowMoney=borrowMoney;
	}
	public long getBorrowMoney(){
		return borrowMoney;
	}

	//--------------재정의(오버라이딩)
	public long getRestMoney(){   //잔액인데 마이너스통장이니까 대출금도 계산해줘야됨
		return super.getRestMoney()-borrowMoney;   //restMoney받아오려니 private라서 안되서 
												//메소드를 받아오려니 재귀함수되니까 super써서 메소드 호출
	}

	public String toString(){
		
		return "마이너스\t"+ getAccountNum() + "\t" + getAccountOwner() + "\t" +formatter.format("%,d", (borrowMoney*-1)) + "\n";   //그 앞의 인자들을 리턴받으려면 위에 한것처럼 super.메소드 해야되는데
												//부모클래스에 toString메소드가 이미 가지고 있으니까 super.toString이용
	}
}
