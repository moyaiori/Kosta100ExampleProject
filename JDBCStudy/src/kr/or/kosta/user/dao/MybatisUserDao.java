package kr.or.kosta.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.User;

/**
 * Mybatis 기술을 이용하여 UserDao 규격을 구현한 Dao
 * @author Lee Gwangyong
 *
 */
public class MybatisUserDao implements UserDao{
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 사용자 등록 */
	public void add(User user) throws Exception {
		// 추후에 myBatis 기술 사용
	}

	/** 사용자 정보 조회 */
	public User get(String id) throws Exception {
		User user = null;
		// 추후에 myBatis 기술 사용
		return user;
	}

	/** 사용자 전체 목록 반환 */
	public List<User> getAll() throws Exception {
		List<User> list = new ArrayList<User>();
		// 추후에 myBatis 기술 사용
		return null;
	}

	/** 회원 여부 반환 */
	public User isMenet(String id, String pass) throws Exception {
		User user = null;
		// 추후에 myBatis 기술 사용
		return user;
	}
}


