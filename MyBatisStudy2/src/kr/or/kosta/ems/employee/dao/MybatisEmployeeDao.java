package kr.or.kosta.ems.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.employee.domain.Employee;
import kr.or.kosta.ems.common.dao.DaoFactory;
import kr.or.kosta.ems.common.dao.DaoFactory.DaoFactoryType;

public class MybatisEmployeeDao implements EmployeeDao {
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Employee> getAll() throws RuntimeException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = new ArrayList<Employee>();
		
		try {
//			list = sqlSession.selectList("kr.or.kosta.ems.employee.dao.selectAll");
			EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
			list = dao.getAll();
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public Employee get(int employeeId) throws RuntimeException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Employee employee = new Employee();
		
		try {
//			employee = sqlSession.selectOne("kr.or.kosta.ems.employee.dao.selectEmployeesById", employeeId);
			EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
			employee = dao.get(employeeId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
		return employee;
	}

	@Override
	public List<Employee> search(String lastName) throws RuntimeException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = new ArrayList<Employee>();
		
		lastName = "%" + lastName.toUpperCase() + "%";
		
		try {
//			list = sqlSession.selectList("kr.or.kosta.ems.employee.dao.selectEmployeesByLastName", lastName);
			EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
			list = dao.search(lastName);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
		
		return list;
	}

	@Override
	public void insert(Employee employee) throws RuntimeException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
//			sqlSession.insert("kr.or.kosta.ems.employee.dao.insertEmployee", employee);
			EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
			dao.insert(employee);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
			System.out.println("추가 완료");
		}
	}

	@Override
	public void update(Employee employee) throws RuntimeException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
//			sqlSession.update("kr.or.kosta.employee.updateEmployee", employee);
//			sqlSession.update("kr.or.kosta.ems.employee.dao.updateEmployee2", employee);
			EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
			dao.update(employee);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
			System.out.println("수정 완료");
		}

	}

	@Override
	public void delete(int employeeId) throws RuntimeException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
//			sqlSession.delete("kr.or.kosta.ems.employee.dao.deleteEmployee", employeeId);
			EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
			dao.delete(employeeId);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			System.out.println("사원 삭제 완료");
		}
		
	}
	
	// 테스트 메인
	public static void main(String[] args) throws Exception {
		
		DaoFactory factory = DaoFactory.getInstance(DaoFactoryType.MYBATIS);
		EmployeeDao dao = (EmployeeDao)factory.getDao(MybatisEmployeeDao.class);
		
//		List<Employee> list = dao.getAll();
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
		
//		System.out.println(dao.get(209));
		
//		System.out.println(dao.search("이"));

//		Employee emp = new Employee();
//		emp.setFirstName("KiJung");
//		emp.setLastName("Kims");
//		emp.setEmail("bangry2@gmail.com");
//		emp.setPhoneNumber("010.9179.87087");
//		emp.setHireDate("2014-5-5");
//		emp.setJobId("IT_PROG");
//		emp.setSalary(50000);
//		emp.setManagerId(150);
//		emp.setDepartmentId(60);
//		
//		dao.insert(emp);

//		Employee emp = new Employee();
//		emp.setId(209);
//		emp.setFirstName("광용");
//		emp.setLastName("이");
//		emp.setSalary(75500);
//		emp.setEmail("kosta12@kosta.com");
//		
//		dao.update(emp);
		
//		dao.delete(209);
	}

}
