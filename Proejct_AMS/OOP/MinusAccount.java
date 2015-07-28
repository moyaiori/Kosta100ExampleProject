public class MinusAccount extends Account{

	private long borrowMoney;
	
	public MinusAccount(){
		this(null, null, 0, 0, 0);
	}
	
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney){
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney =  borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney){
		this.borrowMoney = borrowMoney;
	}

	public long getBorrowMoney(){
		return borrowMoney;
	}

	//¿Á¡§¿«
	public long getRestMoney(){
		return super.getRestMoney() - borrowMoney;
	}

	public String toString(){
		return super.toString() + "\t" + (borrowMoney * -1);
	}
}
