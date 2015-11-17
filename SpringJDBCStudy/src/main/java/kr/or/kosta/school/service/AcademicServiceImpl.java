package kr.or.kosta.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.school.dao.StudentDao;
import kr.or.kosta.school.domain.Student;

/** 
 * 학사 관련 비즈니스 메소드 구현 Business Object
 * @author 김기정
 */
@Service("academicService")
public class AcademicServiceImpl implements AcademicService{
	
	@Autowired
	private StudentDao studentDao;
	
	public AcademicServiceImpl(){}
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	/** 학사 비즈니스 메소드 구현 */
	/** 학생 등록 */
	public void regist(Student student) throws RuntimeException{
		studentDao.add(student);
		System.out.println("[Debug] : 학생등록 완료");
	}
	
	// 학생 목록
	public List<Student> list() throws RuntimeException {
		System.out.println("[Debug] : 학생 전체 목록 반환");
		return studentDao.getAll();
	}
}
