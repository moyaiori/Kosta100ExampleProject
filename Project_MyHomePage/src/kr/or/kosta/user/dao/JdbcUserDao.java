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
		String sql = " INSERT INTO users(id, passwd, name, email, mobile1, mobile2, mobile3, profile)" + 
					 "  VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("회원가입");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getMobile1());
			pstmt.setString(6, user.getMobile2());
			pstmt.setString(7, user.getMobile3());
			pstmt.setString(8, user.getprofile());
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
		return null;
	}

	/** 사용자 전체 목록 반환 */
	public List<User> getAll() throws Exception {
		return null;
	}

	/** 회원 여부 반환 */
	public User isMember(String id, String pass) throws Exception {
		
		User user = null;
		String sql = " SELECT id, name, passwd, email"
					+ " FROM users"
					+ " WHERE id = ? AND passwd = ?";

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
				String email = rs.getString("email");

				user.setId(userId);
				user.setName(name);
				user.setPasswd(passwd);
				user.setEmail(email);
			}} catch (Exception e) {
				e.printStackTrace();
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


