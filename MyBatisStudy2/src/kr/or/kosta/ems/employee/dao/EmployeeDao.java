package kr.or.kosta.ems.employee.dao;

import java.util.List;

import kr.or.kosta.employee.domain.Employee;

/**
 * 사원 관련 영속성 처리 표준 규약
 * @author 김기정
 *
 */
public interface EmployeeDao {
	
	/** 사원 전체 목록 조회 */
	public List<Employee> getAll() throws RuntimeException;
	
	/** 사원번호로 사원 조회*/
	public Employee get(int employeeId) throws RuntimeException;
	
	/** 사원이름으로 사원 조회*/
	public List<Employee> search(String lastName) throws RuntimeException;
	
	/** 사원 등록 */
	public void insert(Employee employee) throws RuntimeException;
	
	/** 사원 정보 수정 */
	public void update(Employee employee) throws RuntimeException;
	
	/** 사원 정보 삭제 */
	public void delete(int employeeId) throws RuntimeException;
	
}









