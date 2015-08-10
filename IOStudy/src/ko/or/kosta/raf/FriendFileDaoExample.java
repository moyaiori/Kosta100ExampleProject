package ko.or.kosta.raf;

import java.util.*;
import java.io.*;

/**
 * FileDao 테스트를 위한 애플리케이션 클래스
 * @author 김기정
 *
 */
public class  FriendFileDaoExample{
	public static void main(String[] args) {
		
		FriendDao fileManager = null;
		
		try{
			fileManager = new FriendDao();
			// 파일에 친구(레코드) 추가 테스트
			fileManager.saveRecord(new Friend("김기정", 43, 61.34, "011-9179-8707"));
			fileManager.saveRecord(new Friend("김규빈", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("김정화", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("박세훈", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("서희상", 43, 61.34, "010-9179-8707"));
			fileManager.saveRecord(new Friend("윤성혁", 43, 61.34, "010-9179-8707"));
			System.out.println("정상적으로 등록되었습니다..");
		}catch(Exception ex){
			System.out.println("등록시 에러가 발생하였습니다: " + ex);			
		} 
		
		// 전체 리스트..
		System.out.println("***** 등록된 모든 친구 리스트(총 "+fileManager.getRecordCount()+"명) *****");
		try{
			ArrayList<Friend> list = (ArrayList<Friend>) fileManager.getRecords();
			for (Friend friend : list) {
				//System.out.println("☞ " + friend.getName() + " | " + friend.getAge() + " | " + friend.getWeight() + " | "+ friend.getTelephone());
				System.out.println(friend);
			}
				
		}catch(Exception ex){
			System.out.println("리스트 출력시 에러가 발생하였습니다: " + ex);			
		}

		// 스트림 닫기
		fileManager.close();

	}
}
