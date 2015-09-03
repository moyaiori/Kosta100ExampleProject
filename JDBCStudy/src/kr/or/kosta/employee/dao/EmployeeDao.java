package kr.or.kosta.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import kr.or.kosta.employee.common.UserConnectionPool;
import kr.or.kosta.employee.domain.Employee;

/**
 * Emplyee 테이블 관련 영속성 처리를 전담하는 Dao
 * 
 * @author Lee Gwangyong
 *
 */

public class EmployeeDao {

	private static final String driverName = "oracle.jdbc.driver.OracleDriver";
	private static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String dbUserId = "hr";
	private static final String dbUserPw = "hr";
	private static final int MAX_COUNT = 2;
	private static final int IDLE_COUNT = 3;
	
	
	/** Connection  생성 */
	/*
	public Connection createConnection() throws ClassNotFoundException, SQLException{
		Connection con = null;
		Class.forName(driverName);
		con = DriverManager.getConnection(dbUrl, userId, userPw);
		return con;
	}
	*/
	
	/**
	 * Connection 생성
	 */
	public Connection createConnection() throws SQLException, ClassNotFoundException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserId);
		dataSource.setPassword(dbUserPw);
		dataSource.setInitialSize(MAX_COUNT);
		dataSource.setMaxIdle(IDLE_COUNT);
		return dataSource.getConnection();
	}

	/** 신규사원 등록 기능 */
	public void add(String firstName, String lastName, String email, String hireDate, String jobId) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setHireDate(hireDate);
		employee.setJobId(jobId);
		add(employee);
	}

	/** 신규사원 등록 기능 */
	public void add(Employee employee) throws Exception {
		String sql = " INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id)"
				+ " VALUES(employees_seq.nextVal, ?, ?, ?, to_date(?, 'yyyy-MM-DD'), ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = createConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getHireDate());
			pstmt.setString(5, employee.getJobId());

			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + "행이 추가되었습니다.");

		} catch (Exception e) {
			try {
				if (con != null) con.rollback();
			} catch (SQLException e1) {}
			throw new Exception("[Debug] : add() Method Exception", e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
	}

	/**
	 * 사원조회
	 */
	public Employee get(int employeeId) throws Exception {
		Employee employee = null;
		String sql = " SELECT employee_id, first_name, last_name, email, phone_number, TO_CHAR(hire_date, 'yyyy-MM-DD HH24:MI:SS') hire_date, job_id, salary, department_id"
				+ " FROM employees" + " WHERE employee_id = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = createConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, employeeId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				employee = new Employee();
				int id = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String hireDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				int salary = rs.getInt("salary");
				int departmentId = rs.getInt("department_id");
				
				employee.setEmployeeId(id);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setPhoneNumber(phoneNumber);
				employee.setHireDate(hireDate);
				employee.setJobId(jobId);
				employee.setSalary(salary);
				employee.setDepartmentId(departmentId);
				
			}

		} catch (Exception e) {
			throw new Exception("[Debug] : add() Method Exception", e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			if (rs != null) rs.close();
		}
		return employee;
	}
	
	/**
	 * 전체 사원 조회
	 */
	public List<Employee> getAll() throws Exception{
		Employee employee = null;
		ArrayList resultList = new ArrayList<Employee>();
		
		String sql = " SELECT employee_id, first_name, last_name, email, phone_number, TO_CHAR(hire_date, 'yyyy-MM-DD HH24:MI:SS') hire_date, job_id, salary, department_id" + 
				" FROM employees";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = createConnection();
			pstmt = con.prepareStatement(sql);

			
			rs = pstmt.executeQuery();
			while(rs.next()){
				employee = new Employee();
				int id = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String hireDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				int salary = rs.getInt("salary");
				int departmentId = rs.getInt("department_id");
				
				employee.setEmployeeId(id);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setPhoneNumber(phoneNumber);
				employee.setHireDate(hireDate);
				employee.setJobId(jobId);
				employee.setSalary(salary);
				employee.setDepartmentId(departmentId);
				resultList.add(employee);
			}

		} catch (Exception e) {
			throw new Exception("[Debug] : getAll() Method Exception", e);
		} finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return resultList;
	}
	
	/**
	 * 사원이름(first_name)으로 사원 검색
	 * LIKE 검색으로 온전하지 않은 검색어가 들어올경우 와일드카드 검색구현
	 */
	public List<Employee>  search(String firstName) throws Exception{
		Employee employee = null;
		ArrayList resultList = new ArrayList<Employee>();
		
		String sql = " SELECT employee_id, first_name, last_name, email, phone_number, TO_CHAR(hire_date, 'yyyy-MM-DD HH24:MI:SS') hire_date, job_id, salary, department_id" + 
				" FROM employees" + 
				" WHERE UPPER(first_name) LIKE ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = createConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName.toUpperCase() + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				employee = new Employee();
				
				int id = rs.getInt("employee_id");
				String firstNames = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String hireDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				int salary = rs.getInt("salary");
				int departmentId = rs.getInt("department_id");
				
				employee.setEmployeeId(id);
				employee.setFirstName(firstNames);
				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setPhoneNumber(phoneNumber);
				employee.setHireDate(hireDate);
				employee.setJobId(jobId);
				employee.setSalary(salary);
				employee.setDepartmentId(departmentId);
				resultList.add(employee);
			}

		} catch (Exception e) {
			throw new Exception("[Debug] : search() Method Exception", e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			if (rs != null) rs.close();
		}

		return resultList;
	}
	
	/**
	 * 전체 사원 조회(부서명 포함)
	 * join한 뷰를 통해서 검색하기
	 * map 하나가 행을 나타낸다
	 * String 칼럼명
	 * Object 실제값
	 */
	public List<Map<String, Object>> searchAll() throws Exception{
		Employee employee = null;
		ArrayList resultList = new ArrayList<Map<String, Object>>();
		
		String sql = " SELECT e.employee_id employee_id, e.first_name first_name, e.last_name last_name, e.email email, e.phone_number phone_number, e.job_id job_id, e.salary salary, TO_CHAR(e.hire_date, 'yyyy-MM-DD HH24:MI:SS') hire_date, e.department_id department_id, d.department_name department_name" + 
				" FROM employees e JOIN departments d" + 
				" ON e.department_id = d.department_id";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = createConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				employee = new Employee();
				HashMap<String, Object> row = new HashMap<String, Object>();
				
				int id = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phone_number");
				String hireDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				int salary = rs.getInt("salary");
				int departmentId = rs.getInt("department_id");
				String departmentName = rs.getString("department_name");
				
				row.put("EmployeeId", id);
				row.put("firstNames", firstName);
				row.put("lastName", lastName);
				row.put("email", email);
				row.put("phoneNumber", phoneNumber);
				row.put("hireDate", hireDate);
				row.put("jobId", jobId);
				row.put("salary", salary);
				row.put("departmentId", departmentId);
				row.put("departmentName", departmentName);
				
				resultList.add(row);
			}

		} catch (Exception e) {
			throw new Exception("[Debug] : searchAll() Method Exception", e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
			if (rs != null) rs.close();
		}
		
		return resultList;
	}

	public static void main(String[] args) {
		try {
			EmployeeDao dao = new EmployeeDao();
//			dao.add("Yong", "Lee", "kosta100@naver.com", "2015-09-02", "IT_PROG");
//			System.out.println("사원이 정상 등록 되었습니다.");
			
//			Employee employee = dao.get(700);
//			System.out.println("검색한 사원 정보 : " + employee);
			
			// 모든 사원 검색
//			List<Employee> result = dao.getAll();
//			for (Employee employee : result) {
//				System.out.println("Employee : " + employee);
//			}
			
			// 해당 이름의 사원 검색 
//			List<Employee> search = dao.search("S");
//			for (Employee employee : search) {
//				System.out.println("Employee serarch : " + employee);
//			}
			
			// 부서명 포함 검색
			List<Map<String, Object>> search = dao.searchAll();
			for (Map<String, Object> map : search) {
				System.out.println("search : " + map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
