package kr.or.kosta.user.client;

import java.util.List;

import kr.or.kosta.user.dao.DaoFactory;
import kr.or.kosta.user.dao.JdbcDaoFactory;
import kr.or.kosta.user.dao.JdbcUserDao;
import kr.or.kosta.user.dao.UserDao;
import kr.or.kosta.user.domain.User;

public class UserDaoClient {
	public static void main(String[] args) {
//		Object dao = new JdbcDaoFactory().getDao("kr.or.kosta.user.dao.JdbcUserDao");
		UserDao dao = (UserDao) new JdbcDaoFactory().getDao("kr.or.kosta.user.dao.JdbcUserDao");
//		Object dao = new JdbcDaoFactory().getDao("JdbcUserDao");
		
		 // 추가
		/*
		try {
			dao.add(new User("moya1", "용1", "1111"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		// 조회 
		/*
		try {
			System.out.println("dao.get(\"moya\") : " + dao.get("moya"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		// 전체목록 반환
		
		try {
			List<User> list = dao.getAll();
			for (User user : list) {
				System.out.println("User List : " + user );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
