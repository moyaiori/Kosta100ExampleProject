package kr.or.kosta.shopping.user.service;

import java.util.List;

import kr.or.kosta.shopping.common.dao.DaoFactory;
import kr.or.kosta.shopping.common.dao.DaoFactory.DaoFactoryType;
import kr.or.kosta.shopping.user.dao.JdbcUserDao;
import kr.or.kosta.shopping.user.dao.UserDao;
import kr.or.kosta.shopping.user.domain.User;

/**
 * 
 * @author 김기정
 * 서비스 계층은 사용 기술과 상관 없이 객체 지향 설계 원칙이 적용된 핵심 비즈니스 로직을 잘 담아내야 한다.
 * 싱글톤패턴 적용
 */
public class UserService {
	
	private static UserService instance;
	
	UserDao userDao;
	
	private UserService() throws Exception{
		DaoFactory daoFactory = DaoFactory.getInstance(DaoFactoryType.JDBC);
		userDao = (UserDao) daoFactory.getDao(JdbcUserDao.class);
	}
	
	public static UserService getInstance(){
		if(instance == null){
			synchronized (UserService.class) {
				try {
					instance = new UserService();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
		return instance;
	}
	
	/** 회원등록 */
	public void add(User user) throws RuntimeException{
		// 비즈니스 로직 처리....
		try {
			userDao.add(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	/** 회원목록 */
	public List<User> list() throws RuntimeException{
		List<User> list = null;
		try {
			list = userDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	
	/** 회원정보 수정 */
	/*
	public static void main(String[] args) {
		UserService service = UserService.getInstance();
		service.add(new User("killer2", "김킬러", "111"));
		System.out.println("등록 완료...");
	}
	*/
	

}
