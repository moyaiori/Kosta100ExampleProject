package ko.or.kosta.raf;


import java.io.*;
import java.util.*;
/**
 * RandomAccessFile을 이용한 파일 영속성 처리 클래스 캡슐화
 * @author 김기정
 *
 */
public class FriendDao{
	
	/** 저장파일 경로*/
	private static final String FILE_PATH = "accounts.dbf";
	
	private RandomAccessFile randomAccessFile;
	
	/** 저장된 레코드(친구)수 */
	private int recordCount = 0;
	
	/** 레코드수 저장을 위한 컬럼 사이즈 */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** 친구정보 저장을 위한 레코드 컬럼별 사이즈 설정*/
	//이름|나이|몸무게|전화번호|
	private static final int NAME_LENGTH = 10;        // 이름(10바이트)
	private static final int AGE_LENGTH = 4;          // 나이(4바이트)
	private static final int WEIGHT_LENGTH = 8;       // 몸무게(8바이트)
	private static final int TELEPHONE_LENGTH = 26;    // 전화번호(26바이트)
	
	/** 친구정보 저장을 위한 레코드 총사이즈 : 48바이트 */	
	public static final int RECORD_LENGTH = NAME_LENGTH + AGE_LENGTH + WEIGHT_LENGTH + TELEPHONE_LENGTH;

	
	public FriendDao() throws IOException{
		randomAccessFile = new RandomAccessFile(FILE_PATH, "rw");
		// 저장된 친구 목록이 있는 경우 
		if(randomAccessFile.length() != 0){
			recordCount = randomAccessFile.readInt(); //저장되어 있는 레코드의 수
		}else{
			// 임시 테스트
			System.out.println("처음으로 프로그램을 실행하여 파일에 등록된 친구 없음");
		}
	}	
		
	public RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}
	public int getRecordCount() {
		return recordCount;
	}
	
	/** 새로운 친구 정보 저장 */
	public void saveRecord(Friend friend) throws Exception{
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		randomAccessFile.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// 새로운 레코드(친구) 추가
		//10 + 4 + 8 + 26
		String name = friend.getName();
		int age = friend.getAge();
		double weight = friend.getWeight();
		String telephone = friend.getTelephone();
		
		// 이름 글자수를 가져오기위해 char로 한다.
		// UTF로 쓸경우 크기를 가져올수 없다.
		int charCount = name.length();		
		//10바이트(5글자)로 이름 저장
		for(int i = 0; i < (NAME_LENGTH/2); i++){		
			// EX) "김기정  ", 이름을 쓴 나머지 바이트를 채워서 넣는다.
			randomAccessFile.writeChar((i<charCount ? name.charAt(i) : ' '));
		}
		
		// 나이(4바이트)
		randomAccessFile.writeInt(age);
		// 몸무게(8바이트)
		randomAccessFile.writeDouble(weight);
				
		// 26바이트(13글자)로 전화번호 저장		
		charCount = telephone.length();
		for(int i = 0; i < (TELEPHONE_LENGTH/2); i++){
			// EX) "010-9179-8707"
			randomAccessFile.writeChar((i<charCount ? telephone.charAt(i) : ' '));
		}

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(친구) 수 1 증가
		randomAccessFile.seek(0);
		randomAccessFile.writeInt(++recordCount);
	}
	

	/** 등록된 전체리스트 반환 */
	public List<Friend>  getRecords() throws Exception{
		ArrayList<Friend> list = new ArrayList<Friend>();
		for(int i=0; i<recordCount; i++){
			Friend friend = getRecord(i);
			list.add(friend);
		}
		return list;
	}
	
	
	/** 특정 레코드의 정보를 Friend로 반환 */
	private Friend getRecord(int index) throws IOException{
		Friend friend = null;
		
		String name = "";
		randomAccessFile.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		for(int i=0; i<(NAME_LENGTH/2); i++){
			name += randomAccessFile.readChar();
		}
		name = name.trim();
		
		int age = 0;
		age = randomAccessFile.readInt();
		
		double weight = 0.0;
		weight = randomAccessFile.readDouble();
		
		String telephone = "";
		for(int i = 0;i<(TELEPHONE_LENGTH/2);i++){
			telephone += randomAccessFile.readChar();
		}
		telephone = telephone.trim();
		
		friend = new Friend(name, age, weight, telephone);
		return friend;
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


