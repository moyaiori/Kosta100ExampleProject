package kr.or.kosta.ams.model;

public class MinusAccount extends Account {

	private long borrowMoney;

	public MinusAccount(){
		this(null, null, 0000, 0L, 0L);
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

	public long getRestMoney(){
		return super.getRestMoney() - borrowMoney;
	}

	public String toString(){
		return String.format("마이너스계좌\t" + getAccountNum() + "\t" + getAccountOwner()+"\t\t%,10d\t%,10d\n",getRestMoney(),getBorrowMoney());
	}

	//	return String.format(accountNum + "\t" + accountOwner + "\t\t%,10d", restMoney);
}
