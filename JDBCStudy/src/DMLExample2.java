import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PreParedStatement 를 활용한 효율적인 SQL DML 처리
 * 
 * @author Lee Gwangyong
 *
 */
public class DMLExample2 {

	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";
		
		String sql = " INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pCt, manager_id, department_id)" + 
				" VALUES(employees_seq.nextVal, ?, ?, ?, '010.6877.7451', SYSDATE, 'IT_PROG', ?, 0.25, 200, 60)";
		
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
			pstmt.setString(1, "GwongYong");
			pstmt.setString(2, "Lee");
			pstmt.setString(3, "moyaiori1@gmail.com");
			pstmt.setInt(4, 50000);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "행이 추가되었습니다.");
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
