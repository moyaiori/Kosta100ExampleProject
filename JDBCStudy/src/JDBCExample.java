import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 DBMS 연동하기
 * 
 * @author Lee Gwangyong
 *
 */
public class JDBCExample {

	public JDBCExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		// Driver driver = new OracleDriver();

		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUserId = "hr";
		String dbUserPw = "hr";
		
		String sql = "SELECT employee_id , last_name, salary, commission_pct, hire_date" + 
					 " FROM employees";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// #1. Oracle JDBC Driver 로드(인스턴스 생성)
		try {
			Class.forName(driverName).newInstance();
			System.out.println("JDBC 드라이버 로드 완료...");

			// #2. Oracle 연결(JDBC URL 설정)
			con = DriverManager.getConnection(dbUrl, dbUserId, dbUserPw);
			System.out.println("Oracle DBMS와 연결됨...");
			
			// #3. Statement는 SQL 문장을 서버에 실행(전송)하며, 반환된 결과를 수신
			stmt = con.createStatement();
			
			// #4. 서버에 SQL 전송 및 결과 집합 수신
			rs = stmt.executeQuery(sql); // DML
			//int updateCount = stmt.executeUpdate(sql); // DDL, DCL
			
			// #5. ResultSet의 데이터 읽기
			while(rs.next()){
				// 각행의 컬럼값 읽기
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				double commistionPct = rs.getDouble("commission_pct");
				Date hireDate = rs.getDate("hire_date");
				
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + commistionPct + "\t" + hireDate);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// #1
		// mySql Driver 로딩
		// Class.forName("com.mysql.jdbc.Driver").newInstance();
		// MS-SQL Driver 로딩
		// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// #2
		// mySql Connection
		// DriverManager.getConnection("jdbc:mysql://localhost:3306:SID",
		// "UserId", "UserPw");

	}

}
