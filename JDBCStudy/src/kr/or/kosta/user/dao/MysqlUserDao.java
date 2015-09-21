//package kr.or.kosta.user.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class MysqlUserDao extends JdbcUserDao {
//	static final String driverName = "com.mysql.jdbc.Driver";
//	static final String dbUrl = "jdbc:mysql://localhost:3306:SID";
//	static final String dbUserId = "hr";
//	static final String dbUserPw = "hr";
//
//	@Override
//	public Connection getConnection() throws Exception {
//		Class.forName(driverName);
//		return DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
//	}
//
//}
