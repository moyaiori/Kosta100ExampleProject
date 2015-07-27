package kr.or.kosta.ams.model;

public class MinusAccount extends Account{
	private long borrowMoney;
	
	public MinusAccount(){
		this(null, null, 0, 0L, 0L);	
	}

	public MinusAccount(String accountNum,  String accountOwner, int passwd, long restMoney, long borrowMoney){
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney){
		this.borrowMoney = borrowMoney;
	}

	public long getBorrowMoney(){
		return borrowMoney;
	}
	
	public long getRestMoney(){
		return super.getRestMoney() - borrowMoney;
	}

	public String toString(){
		String formatedborrowMoney = String.format("%,d ",borrowMoney*-1);
		 return super.toString()+formatedborrowMoney;	
	}
}
