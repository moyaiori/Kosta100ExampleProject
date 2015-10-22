package kr.or.kosta.shopping.user.dao;

import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.shopping.user.domain.User;

/**
 * 영속성 처리 기술에 상관없이 일관된 방법으로
 * 데이터 처리가 가능하게 하기 위한 규격
 * @author Lee Gwangyong
 *
 */
public interface UserDao {
	
	public DataSource getDataSource();

	public void setDataSource(DataSource dataSource);

	/** 사용자 등록 */
	public void add(User user) throws Exception;

	/** 사용자 정보 조회 */
	public User get(String id) throws Exception;

	/** 사용자 전체 목록 반환 */
	public List<User> getAll() throws Exception;

	/** 회원 여부 반환 */
	public User isMember(String id, String pass) throws Exception;
}