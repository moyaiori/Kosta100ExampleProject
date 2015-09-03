import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 SQL DQL 처리
 * 
 * @author Lee Gwangyong
 *
 */
public class DMLExample1 {

	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";
		
		String sql = " INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pCt, manager_id, department_id)" + 
				" VALUES(employees_seq.nextVal, 'Gwangyong', 'lee', 'moyaiori@naver.com', '010.6877.7451', SYSDATE, 'IT_PROG', 10000, 0.25, 200, 60)";
		
		Connection con = null;
		Statement stmt = null;

		try {
//			Class.forName(driverName).newInstance();
			Class.forName(driverName); // 자동호출됨
			con = DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
			con.setAutoCommit(false);// defalut값 true
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
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
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
