package kr.or.kosta.ams.model;
public class MinusAccount extends Account{
	private long borrowMoney;
	
	public MinusAccount(){
		this(null, null, null, 0, 0L, 0L);	
	}

	public MinusAccount(String accountlist, String accountNum,  String accountOwner, int passwd, long restMoney, long borrowMoney){
		super(accountlist, accountNum, accountOwner, passwd, restMoney);
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
		 return super.toString()+ "\t" + (borrowMoney * -1);	
	}
}
