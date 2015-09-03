import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 동적 SQL 전송 및 결과 수신
 * @author Lee Gwangyong
 *
 */
public class DynamicSQLExample {
	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String userId = "hr";
		String userPw = "hr";
		
		// 동적 SQL
//		String sql = " SELECT employee_id" + 
//					" FROM employees";
		
		String sql = "UPDATE departments" + 
				" SET department_name = '래빈바보'" + 
				" WHERE department_id >= 280";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbUrl, userId, userPw);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			boolean isResult = pstmt.execute();
			
			if (isResult) {		// resultSet이 있는 경우(DQL)
				ResultSet rs = pstmt.getResultSet();
				
				while (rs.next()) {
					int id = rs.getInt("employee_id");
					System.out.println("id : " + id);
				}
			}else{	// DML, DLL 실행시...
				int count = pstmt.getUpdateCount();
				System.out.println(count + "행이 변경되었습니다.");
				con.commit();
			}
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
