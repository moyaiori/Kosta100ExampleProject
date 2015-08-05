package kr.or.kosta.sync;

/**
 * 은행계좌 객체 추상화(모델링 클래스)
 */
public class Account {
	// 상수
	public final static String bankName = "KOSTA";
	
	// 속성
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	
	/** 생성자 오버로딩 */
	// 디폴트 생성자
	public Account(){
		//accountNum = null;
		//accountOwner = null;
		//passwd = 0;
		//restMoney = 0L;
		this(null, null, 0, 0L);
	}

	public Account(String accountNum,  String accountOwner){
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		//this.passwd = 1111;
		//this.restMoney = 0L;
		this(accountNum, accountOwner, 1111, 0L);
	}

	public Account(String accountNum,  String accountOwner, int passwd, long restMoney){
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

	public long withdraw(long money){
		restMoney -= money;
		return restMoney;
	}

	public boolean checkPasswd(int pw){
		return passwd == pw;
	}
	
	// Overriding
	public String toString(){
		 return accountNum + "\t" + accountOwner+"\t****\t"+restMoney;	
	}

	public boolean equals(Object obj){
		//"1111\t김기정\t1111\t100".equqls("1111\t김기정\t1111\t1000");
		// 위임형 비교
		boolean equal = false;
		if(obj instanceof Account){
			equal = toString().equals(obj.toString());
		}
		return equal;
	}
}
