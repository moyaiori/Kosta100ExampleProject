package kr.or.kosta.springmvc.user.dao;


import java.util.List;

import kr.or.kosta.springmvc.user.domain.User;

/** 
 * 유저 정보 관련 영속성 처리 규약 선언
 * @author 김기정
 */
public interface UserDao {
	/** 사용자 등록 */
	public void insert(User user) throws RuntimeException;
	
	/** 전체 사용자 검색 */
	public List<User> selectAll() throws RuntimeException;
	
	/** 아이디로 검색 */
	public User selectById(String id) throws RuntimeException;
}
