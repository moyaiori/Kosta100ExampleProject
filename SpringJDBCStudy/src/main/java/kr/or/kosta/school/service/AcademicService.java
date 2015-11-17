package kr.or.kosta.school.service;


import java.util.List;

import kr.or.kosta.school.domain.Student;

/** 
 * 학사 관련 비즈니스 규약(추상메소드) 선언
 * @author 김기정
 */
public interface AcademicService {
	
	/** 학생 등록 */
	public void regist(Student student) throws RuntimeException;
	
	/** 학생 전체 목록 반환 */
	public List<Student> list() throws RuntimeException;
	
	/** 기타 비즈니스 메소드 선언 */
}
