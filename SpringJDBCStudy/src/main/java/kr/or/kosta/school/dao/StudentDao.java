package kr.or.kosta.school.dao;


import java.util.List;

import kr.or.kosta.school.domain.Student;

/** 
 * 학사 관련 영속성 처리 규약 선언
 * @author 김기정
 */
public interface StudentDao {
	/** 학생 등록 */
	public void add(Student student) throws RuntimeException;
	/** 전체 학생 검색 */
	public List<Student> getAll() throws RuntimeException;
	/** 학번으로 학생 검색 */
	public Student findBySsn(String ssn) throws RuntimeException;
	/** 점수 범위로 학생 목록 검색 */
	public List<Student> findByScore(int min, int max) throws RuntimeException;
}
