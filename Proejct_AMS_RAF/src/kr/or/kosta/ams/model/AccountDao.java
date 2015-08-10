package kr.or.kosta.ams.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


/**
 * 파일입출력을 통한 계좌정보 영속적 저장
 * 
 * @author Lee Gwangyong 2015. 08. 10.
 */
public class AccountDao {

	/** 저장 파일 경로 */
	private static final String FILE_PATH = "accounts.dbf";

	private RandomAccessFile randomAccessFile;

	/** 저장된 레코드 수(계좌수) */
	private int recordCount = 0;

	/**
	 * 레코드수 저장을 위한 칼럼 사이즈 갯수만 저장하기때문에 int형으로 선언
	 */
	private static final int RECORD_COUNT_LENGTH = 4;

	/**
	 * 계좌정보 저장을 위해 레코드 칼럼별 사이즈 설정 마이너스 계좌를 기준으로 설정 계좌번호|예금주|비밀번호|잔액|대출금액
	 */
	private static final int ACC_TYPE = 1;			// 게좌 타입 true 마이너스 fasle 일반
	private static final int ACC_NUM_LENGTH = 18;	// 계좌번호 ("1111-2222")
	private static final int ACC_OWNER_LENGTH = 10; // 예금주 ("가나다라마")
	private static final int ACC_PASS = 4; 			// 비밀번호 (1111)
	private static final int ACC_RESTMONEY = 8; 	// 잔액 (long)
	private static final int ACC_BORROWMONEY = 8; 	// 대출금 (long)
	// 1 + 18 + 10 + 4 + 8 + 8 = 49

	public static final int RECORD_LENGTH = ACC_TYPE + ACC_NUM_LENGTH + ACC_OWNER_LENGTH + ACC_PASS + ACC_RESTMONEY
			+ ACC_BORROWMONEY;
	
	public AccountDao() throws IOException{
		randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
		
		// 계좌가 있는경우
		if (randomAccessFile.length() != 0) {
			recordCount = randomAccessFile.readInt(); // 맨 처음에 있는 4바이트는 레코드 숫자를 위해서 저장
		}else{
			// TODO 예외 처리가 필요함
			System.out.println("처음 생성");
		}
	}
	
	public RandomAccessFile getRanAccessFile(){
		return randomAccessFile;
	}
	
	public int getRecrdCount(){
		return recordCount;
	}
	
	
	/** 새로운 계좌 저장 
	 * @throws IOException */
	public void saveAccRecord(Account account) throws IOException{
		// 파일의 마지막 레코드로 포인터 이동
		// (레코드 저장수 * 1개의 레코드 길이) + 데이터 가장 앞에있는 레코드 갯수의 길이
		randomAccessFile.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// 새로운 계좌 추가
		// 2+ 18 + 10 + 4 + 8 + 8
		boolean accType = true;	// true 마이너스 false 일반
		
		String accNum = account.getAccountNum();
		String accOwner = account.getAccountOwner();
		int pass = account.getPasswd();
		long restMoney = account.getRestMoney();

		long borrowMoney;

		if (account instanceof MinusAccount) {
			accType = true;
			MinusAccount minusAccount = (MinusAccount)account;
			borrowMoney = minusAccount.getBorrowMoney();
		}else {
			accType= false;
			borrowMoney = 0;
		}
		
		// 계좌타입
		randomAccessFile.writeBoolean(accType);
		
		// 계좌번호 ("1111-2222")
		int numCount = accNum.length();
		for (int i = 0; i < ACC_NUM_LENGTH/2; i++) {
			// EX) "김기정  ", 이름을 쓴 나머지 바이트를 채워서 넣는다.
			randomAccessFile.writeChar((i<numCount ? accNum.charAt(i) : ' '));
		}
				
		// 이름 글자수를 가져오기위해 char로 한다.
		// UTF로 쓸 경우 크기를 가져올 수 없다.
		// 예금주 이름 가져오기 최대 5글자
		int nameCount = accOwner.length();
		for (int i = 0; i < ACC_OWNER_LENGTH/2; i++) {
			// EX) "김기정  ", 이름을 쓴 나머지 바이트를 채워서 넣는다.
			randomAccessFile.writeChar((i<nameCount ? accOwner.charAt(i) : ' '));
		}
		
		// 비밀번호 저장
		randomAccessFile.writeInt(pass);
		
		// 잔액 저장
		randomAccessFile.writeLong(restMoney);
		
		// 대출금 저장, 일반일경우 0으로 저장
		randomAccessFile.writeLong(borrowMoney);

		//레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드 수 1증가
		randomAccessFile.seek(0);
		randomAccessFile.writeInt(++recordCount);
	}
	
	/** 등록된 전체 계좌리스트 반환 
	 * @throws IOException */
	public List<Account> getRecords() throws IOException{
		ArrayList<Account> list = new ArrayList<Account>();
		for (int i = 0; i < recordCount; i++) {
			Account account = getRecord(i);
			list.add(account);
		}
		return list;
	}
	
	/** 해당 인덱스의 레코드 가져오기 */
	private Account getRecord(int index) throws IOException{
		Account account = null;
		
		randomAccessFile.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH); 
		
		// 계좌 타입
		boolean accType = randomAccessFile.readBoolean();
		
		// 계좌번호
		String accNum = "";
		for(int i=0; i<(ACC_NUM_LENGTH/2); i++){
			accNum += randomAccessFile.readChar();
		}
		accNum = accNum.trim();
		
		// 예금주명
		String accOwner = "";
		for(int i=0; i<(ACC_OWNER_LENGTH/2); i++){
			accOwner += randomAccessFile.readChar();
		}
		accOwner = accOwner.trim();
		
		// 비밀번호
		int pass = 0;
		pass = randomAccessFile.readInt();
		
		// 잔액
		long restMoney = 0;
		restMoney = randomAccessFile.readLong();
		
		// 대출금
		long borrowMoney = 0;
		borrowMoney = randomAccessFile.readLong();
		
		if (accType) {
			// 마이너스
			account = new MinusAccount(accNum, accOwner, pass, restMoney, borrowMoney);
		}else{
			// 일반
			account = new Account(accNum, accOwner, pass, restMoney);
		}
		return account;
	}
	
	/** 계좌번호로 찾기 */
	public Account getAccount(String accNum) throws IOException{
		
		List<Account> list = getRecords();
		
		for (Account account : list) {
			if (account.getAccountNum().equals(accNum)) {
				return account;
			}
		}
		return null;
	}
	
	/** 예금주 명으로 찾기 */
	public List<Account> searchAccount(String accOwner) throws IOException{
		
		List<Account> result = new ArrayList<Account>();
		List<Account> list = getRecords();
		
		for (Account account : list) {
			if (account.getAccountOwner().equals(accOwner)) {
				result.add(account);
			}
		}
		return result;
	}
	
	/** 계좌 삭제 
	 * @throws IOException */
	public boolean removeAccount(String accNum) throws IOException{

		List<Account> list = getRecords();
		
		byte[] temp = new byte[RECORD_LENGTH];
		
		for (int i = 0; i < list.size(); i++) {
			Account account = list.get(i);
			if (account.getAccountNum().equals(accNum)) {
				for (int j = i; j < recordCount + 1; j++) {
					randomAccessFile.seek(((j + 1) * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
					randomAccessFile.read(temp);
					randomAccessFile.seek(((j) * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
					randomAccessFile.write(temp);
				}
				randomAccessFile.seek(0);
				randomAccessFile.writeInt(--recordCount);
			}
		}
		return false;
	}
	
	
	// 스트림 닫기
	public void close(){
		try{
			if(randomAccessFile != null) randomAccessFile.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}













