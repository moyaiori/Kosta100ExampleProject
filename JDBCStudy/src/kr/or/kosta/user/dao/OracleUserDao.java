//package kr.or.kosta.user.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class OracleUserDao extends JdbcUserDao{
//	static final String driverName = "oracle.jdbc.driver.OracleDriver";
//	static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
//	static final String dbUserId = "hr";
//	static final String dbUserPw = "hr";
//
//	@Override
//	public Connection getConnection() throws Exception {
//		Class.forName(driverName);
//		return DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
//	}
//}
