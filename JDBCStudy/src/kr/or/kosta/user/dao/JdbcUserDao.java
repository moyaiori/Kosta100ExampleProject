package kr.or.kosta.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.user.domain.User;

/**
 * jdbc 기술을 이용하여 UserDao 규격을 구현한 Dao
 * @author Lee Gwangyong
 *
 */
public class JdbcUserDao implements UserDao{
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 사용자 등록 */
	public void add(User user) throws Exception {
		String sql = " INSERT INTO users(id, NAME, passwd)  VALUES(?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (Exception e1) {
				throw new Exception("[Debug] : add()메소드 예외발생", e);
			}
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();
			} catch (Exception e) {}
		}

	}

	/** 사용자 정보 조회 */
	public User get(String id) throws Exception {
		User user = null;
		String sql = " SELECT id, name, passwd FROM users WHERE id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			rs = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				String userId = rs.getString("id");
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");

				user.setId(userId);
				user.setName(name);
				user.setPasswd(passwd);
			}
		} catch (Exception e) {
			throw new Exception("[Debug] : get(id)메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return user;
	}

	/** 사용자 전체 목록 반환 */
	public List<User> getAll() throws Exception {
		User user = null;
		List<User> resultList = new ArrayList<User>();
		String sql = " SELECT id, name, passwd" + " FROM users";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				String userId = rs.getString("id");
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");
				user.setId(userId);
				user.setName(name);
				user.setPasswd(passwd);
				resultList.add(user);
			}
		} catch (Exception e) {
			throw new Exception("[Debug] : getAll() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return resultList;
	}

	/** 회원 여부 반환 */
	public User isMenet(String id, String pass) throws Exception {
		User user = null;
		String sql = " SELECT id, name, passwd" + " FROM users" + " WHERE id = ?, passwd = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				String userId = rs.getString("id");
				String name = rs.getString("name");
				String passwd = rs.getString("passwd");

				user.setId(userId);
				user.setName(name);
				user.setPasswd(passwd);
			}} catch (Exception e) {
			throw new Exception("[Debug] : isMember() 메소드 예외발생", e);
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}

		
		return user;
	}
}


