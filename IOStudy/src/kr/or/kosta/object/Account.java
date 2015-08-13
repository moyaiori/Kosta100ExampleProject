package kr.or.kosta.object;

import java.io.Serializable;

/**
 * ������� ��ü �߻�ȭ(�𵨸�)
 */
public class Account implements Serializable{
	// ���
	public final static String BANK_NAME = "KOSTA";

	// �Ӽ�
	private String accountNum;
	private String accountOwner;
	transient private int passwd;
	private long restMoney;

	/** ������ �����ε� */
	// ����Ʈ ������
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

	// setter/getter �޼ҵ� ����
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





	// ���
	public long deposit(long money){
		restMoney += money;
		return restMoney;
	}

	public long withdraw(long money){
		restMoney -= money;
		return restMoney;
	}

	public boolean checkpasswd(int pw){
		// this. �� �ν��Ͻ� ����(Ŭ���� ���κ���)�� �ǹ��Ѵ�.
		return passwd == pw;
	}

	// overriding
	public String toString(){
		return accountNum + "\t"+ accountOwner +"\t****\t" + restMoney;
	}

	public boolean equals(Object obj){

		//������ ��
		System.out.println(toString());
		System.out.println(obj.toString());

		boolean equal = false;

		if (obj instanceof Account){
			equal = toString().equals(obj.toString());
		}
		return equal;
		
		// ���⼭ ���Ǵ� equals�� String���� �������̵��� equals�̴�.(�����)
		// obj.toString() �� ���� ���� ��ü Ÿ���� account �̱⶧���� account���� �������̵���
		// toString�� ȣ���Ѵ�.

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