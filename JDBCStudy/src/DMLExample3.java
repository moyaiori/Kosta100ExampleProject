import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL DML Delete 처리
 * 
 * @author Lee Gwangyong
 *
 */
public class DMLExample3 {

	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";
		
		String sql = " DELETE FROM employees" + 
				" where employee_id = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driverName).newInstance();
			Class.forName(driverName); // 자동호출됨
			con = DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
			con.setAutoCommit(false);// defalut값 true
			
			// SQL 전처리를 위한 preparedStatement
			pstmt = con.prepareStatement(sql);
			
			// 바인딩변수(?)에 원하는 값으로 치환
			pstmt.setInt(1, 209);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "행이 삭제 되었습니다.");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
