import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.Messaging.SyncScopeHelper;

/**
 * SQL DDL 처리
 * @author Lee Gwangyong
 *
 */
public class DDLExample1 {
	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String userId = "hr";
		String userPw = "hr";
		
		String sql = " CREATE TABLE some(" +
		             " name VARCHAR2(10) NOT NULL)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbUrl, userId, userPw);
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.println("테이블이 생성되었습니다..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstmt != null)  pstmt.close();
				if(con != null)   con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}

}
