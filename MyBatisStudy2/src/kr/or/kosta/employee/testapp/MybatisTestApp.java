package kr.or.kosta.employee.testapp;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.employee.domain.Employee;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis 프레임워크를 이용한 RDBMS 연동
 * MyBatis는 내부적으로 Log4J를 사용하기 때문에 src/log4j.xml 설정파일 필요
 * @author 김기정
 *
 */
public class MybatisTestApp {
	
	/** 전체사원 조회 테스트 */
	public static void testCase1(SqlSession sqlSession){
		System.out.println("==================== 전체사원 조회 ========================");
		List<Employee> employeeList = sqlSession.selectList("kr.or.kosta.employee.selectAll");
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
	
	/** 사원번호로 사원 조회 테스트 */
	public static void testCase2(SqlSession sqlSession){
		System.out.println("==================== 사원번호로 사원조회 ========================");
		int id = 200;
		Employee employee = sqlSession.selectOne("kr.or.kosta.employee.selectEmployeesById", id);
		System.out.println(employee);
	}
	
	/** 급여범위로 사원 검색 테스트 */
	public static void testCase3(SqlSession sqlSession){
		System.out.println("==================== 급여범위로 사원검색 ========================");
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("min", 10000);
		params.put("max", 15000);
		List<Employee> employeeList = sqlSession.selectList("kr.or.kosta.employee.selectEmployeesBySalary", params);
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}
	}
	
	/** 성(last_name)으로 사원 검색 테스트(와일드카드 검색) */
	public static void testCase4(SqlSession sqlSession){
		System.out.println("==================== 성으로 사원검색 ========================");
		String searchName = "e";
		searchName = "%" + searchName.toUpperCase() + "%"; // E(e)가 포함된 모든 성
		List<Employee> employeeList = sqlSession.selectList("kr.or.kosta.employee.selectEmployeesByLastName", searchName);
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}
	}
	
	/** 부서명을 포함한 전체사원 조회 테스트(조인) */
	public static void testCase5(SqlSession sqlSession){
		System.out.println("==================== 부서명 포함 전체사원 조회 ========================");
		List<Map<String, Object>> list = sqlSession.selectList("kr.or.kosta.employee.selectEmployeesWithDepartment");
		for (Map<String, Object> row : list) {
			//System.out.println(row);
			// 숫자형은 BigDecimal로 받음
			BigDecimal empId = (BigDecimal) row.get("id");
			String firstName = (String) row.get("firstName");
			String lastName = (String) row.get("lastName");
			String departmentName = (String) row.get("departmentName");
			System.out.println(empId + "\t" + firstName + "\t" + lastName + "\t" + departmentName);
		}
	}
	
	/** employees 테이블로부터 전체사원 조회 테스트 */
	public static void testCase6(SqlSession sqlSession){
		System.out.println("==================== 전체사원 조회 ========================");
		List<Employee> employeeList = sqlSession.selectList("kr.or.kosta.employee.selectAll2");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	
	/** 사원 등록 테스트 */
	public static void testCase7(SqlSession sqlSession){
		Employee emp = new Employee();
		emp.setFirstName("KiJung");
		emp.setLastName("Kim");
		emp.setEmail("bangry@gmail.com");
		emp.setPhoneNumber("010.9179.87087");
		emp.setHireDate("2014-5-5");
		emp.setJobId("IT_PROG");
		emp.setSalary(50000);
		emp.setManagerId(150);
		emp.setDepartmentId(60);
		sqlSession.insert("kr.or.kosta.employee.insertEmployee", emp);
		sqlSession.commit();
		//sqlSession.rollback();
		System.out.println("신규사원 등록 완료");
	}
	
	/** 사원 정보 수정 테스트 */
	public static void testCase8(SqlSession sqlSession){
		Employee emp = new Employee();
		emp.setId(214);
		emp.setFirstName("기정");
		emp.setLastName("김");
		emp.setSalary(70000);
		sqlSession.update("kr.or.kosta.employee.updateEmployee", emp);
		sqlSession.commit();
		System.out.println("사원정보 수정 완료");
	}
	
	/** 사원 삭제 테스트 */
	public static void testCase9(SqlSession sqlSession){
		sqlSession.delete("kr.or.kosta.employee.deleteEmployee", 209);
		sqlSession.commit();
		System.out.println("사원 삭제 완료");
	}
	
	/** 동적 SQL 테스트 */
	public static void testCase10(SqlSession sqlSession){
		System.out.println("==================== 검색타입별 사원 검색 ========================");
		Map<String, Object> searchParams = new HashMap<String, Object>();
//		searchParams.put("searchType", "id");
//		searchParams.put("searchValue", 150);
		
		searchParams.put("searchType", "name");
		searchParams.put("searchValue", "E%");
		
		List<Employee> employeeList = sqlSession.selectList("kr.or.kosta.employee.dynamicSQL", searchParams);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) throws IOException {
		// MyBatis 설정 파일
		String resource = "resource/config/mybatis-config.xml";
		Reader reader = null;
		reader = Resources.getResourceAsReader(resource);
		
		// SqlSessionFactoryBuilder를 이용한 SqlSessionFactory 생성
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//SqlSession sqlSession = sqlSessionFactory.openSession(true); DML 처리 시 autoCommit
		SqlSession sqlSession = sqlSessionFactory.openSession();//autoCommit false
		System.out.println("[Debug] : " + sqlSession);
		
//		testCase1(sqlSession);
//		testCase2(sqlSession);
//		testCase3(sqlSession);
//		testCase4(sqlSession);
//		testCase5(sqlSession);
//		testCase6(sqlSession);
//		testCase7(sqlSession);
//		testCase8(sqlSession);
//		testCase9(sqlSession);
		testCase10(sqlSession);
		
		sqlSession.close();
	}

}
