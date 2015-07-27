package kr.or.kosta.ams.model;

import kr.or.kosta.ams.exception.AccountException;

/**
 * 은행계좌 객체 추상화(모델링 클래스)
 */
public class Account {
	// 속성
	private String accountlist;
	public String getAccountlist() {
		return accountlist;
	}

	public void setAccountlist(String accountlist) {
		this.accountlist = accountlist;
	}

	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	/** 생성자 오버로딩 */
	// 디폴트 생성자(무조건 두개를 만든다고 생각해야함 디폴트 생성자 그리고 인스턴스 속성과 일치하는 갯수를 가지는 생성자)
	public Account(){
		/*
		accountNum = null;
		accountOwner = null;
		passwd = 0;
		restMoney = 0L;
		*/
		this(null, null, null, 0, 0L);
	}

	public Account(String accountlist, String accountNum, String accountOwner){
		
		//this.accountNum = num;
		//this.accountOwner = owner;
		//this.passwd = 1111;
		//this.restMoney = 0L;
		this(accountlist, accountNum, accountOwner, 1111, 0L);
	}

	public Account(String accountlist, String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountlist = accountlist;
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

	// 기능
	public long deposit(long money){
		//restMoney = restMoney + money;
		restMoney += money;
		return restMoney;
	}

	
	public long withdraw(long money) throws AccountException{
		if(restMoney < money){
			throw new AccountException("잔액이 부족합니다.", 100);
		}else if(money < 10000){
			throw new AccountException("10000원 이상이셔야 합니다.", 200);
		}
		restMoney -= money;
		return restMoney;
	}

	public boolean checkPasswd(int pw){
		return passwd == pw;
	}

	public void printAttribute(){
		System.out.println(accountNum+"\t"+accountOwner+"\t****\t"+restMoney);
	}

	// 모든 속성을 문자열로 반환
	public String toString(){
		return accountlist+"\t"+accountNum+"\t"+accountOwner+"\t\t"+restMoney;
	}

	public boolean equals(Object obj){
		/**
		Account account = (Account)obj;
		if(accountNum.equals(account.getAccountNum())){
			if(accountOwner.equals(account.getAccountOwner())){
				if(passwd==getPasswd()){
					if(restMoney==getRestMoney()){
						return true;
					}				
				}			
			}
		}		
		}
		*/
		//"1111\t김동욱\t1111\t100".equals("1111\t김동욱\t1111\t100");
		// 현재클래스에서 메소드 호출 == 오브젝트 하위클래스에서 매개변수로 메소드 호출
		// 위임형 비교
		boolean equal = false;
		if(obj instanceof Account){
			return toString().equals(obj.toString());
		}
		return equal;
	}
	
	public static void main(String[] args) {
		Account account = new Account("입출금계좌", "1111-2222", "김동욱", 1234, 10000);
		try {
			account.withdraw(5000);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
}
