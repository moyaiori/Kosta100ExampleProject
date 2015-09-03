package kr.or.kosta.user.client;

import kr.or.kosta.user.dao.UserDao;

public class UserDaoClient {
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		/*
		 // 추가
		try {
			dao.add(new User("moya", "용", "1234"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// 조회 
		try {
			System.out.println("dao.get(\"moya\") : " + dao.get("moya"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
