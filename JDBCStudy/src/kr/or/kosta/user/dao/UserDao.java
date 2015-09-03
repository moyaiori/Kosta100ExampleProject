package kr.or.kosta.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.kosta.user.domain.User;

public class UserDao {
	/** 사용자 등록 */
	public void add(User user) throws Exception {
		String sql = " INSERT INTO users(id, NAME, passwd)  VALUES(?, ?, ?)";
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPasswd());

		pstmt.executeUpdate();
		con.commit();
	}

	/** 사용자 정보 조회 */
	public User get(String id) throws Exception {
		User user = null;
		String sql = " SELECT id, name, passwd FROM users WHERE id = ?";
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

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
		return user;
	}

	/** Connection 생성을 위한 팩토리 메소드 */
	private Connection getConnection() throws Exception {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";

		Connection con = null;
		Class.forName(driverName);
		return DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
	}
}
