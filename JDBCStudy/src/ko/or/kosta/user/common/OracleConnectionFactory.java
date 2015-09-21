package ko.or.kosta.user.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionFactory implements ConnectionFactory{

	String driverName = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	String dbUserId = "hr";
	String dbUserPw = "hr";
	
	@Override
	public Connection getConnection() throws Exception{
		Class.forName(driverName);
		return DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
	}

}
