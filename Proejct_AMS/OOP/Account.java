/**
 * 은행계좌 객체 추상화(모델링)
 */
public class Account {
	// 상수
	public final static String BANK_NAME = "KOSTA";

	// 속성
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	/** 생성자 오버로딩 */
	// 디폴트 생성자
	public Account(){
		/*
		accountNum = null;
		accountOwner = null;
		passwd = 0;
		restMoney = 0L;
		*/
		this(null,null,0,0);
	}

	public Account(String accountNum, String accountOwner){
		/*
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = 1111;
		this.restMoney = 0L;
		*/
		this(accountNum, accountOwner, 1111, 0L);
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





	// 기능
	public long deposit(long money){
		restMoney += money;
		return restMoney;
	}

	public long withdraw(long money){
		restMoney -= money;
		return restMoney;
	}

	public boolean checkpasswd(int pw){
		// this. 은 인스턴스 변수(클래스 내부변수)를 의미한다.
		return passwd == pw;
	}

	// overriding
	public String toString(){
		return accountNum + "\t"+ accountOwner +"\t****\t" + restMoney;
	}

	public boolean equals(Object obj){

		//위임형 비교
		System.out.println(toString());
		System.out.println(obj.toString());

		boolean equal = false;

		if (obj instanceof Account){
			equal = toString().equals(obj.toString());
		}
		return equal;
		
		// 여기서 사용되는 equals는 String에서 오버라이딩된 equals이다.(내용비교)
		// obj.toString() 은 현재 들어온 객체 타입이 account 이기때문에 account에서 오버라이딩된
		// toString을 호출한다.

		/*
		Account account = (Account)obj;

		if (accountNum.equals(account.getAccountNum())){
			if (accountOwner.equals(account.getAccountOwner())){
				if (passwd == account.getPasswd()){
					if (restMoney == account.getRestMoney()){
						return true;
					}
				}
			}
		}
		return false;
		*/

	}

	
}