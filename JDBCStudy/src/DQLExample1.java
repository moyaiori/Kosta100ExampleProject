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
public class DQLExample1 {

	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";
		
		String sql = " SELECT e.employee_id \"id\", e.first_name || ' ' ||  e.last_name \"name\", e.salary \"salary\", d.department_name \"dName\"" + 
				" FROM employees e JOIN departments d" + 
				" ON e.department_id = d.department_id" + 
				" ORDER BY salary DESC";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
//			Class.forName(driverName).newInstance();
			Class.forName(driverName); // 자동호출됨
			System.out.println("JDBC 드라이버 로드 완료...");
			con = DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
			System.out.println("Oracle DBMS와 연결됨...");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // DML
			while(rs.next()){
				int employeeId = rs.getInt("id");
				String lastName = rs.getString("name");
				int salary = rs.getInt("salary");
				String dName = rs.getString("dName");
				
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + dName
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
