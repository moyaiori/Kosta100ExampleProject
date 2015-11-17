package kr.or.kosta.school.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.or.kosta.school.domain.Student;
/**
 * 
 * 스프링이 지원하는 데이터 액세스 기술 중 하나인
 * Spring JDBC(JdbcTemplate) API를 이용한 데이터베이스 영속성 처리
 * JdbcTemplate은 일관된 DB CRUD 처리를 위한 다양한 메소드 지원
 * 
 * 설정파일(applicationContext.xml)에 JdbcTemplate 등록 및 DataSource 설정 필요
 * @author 김기정
 */
@Repository("studentDao")
public class SpringJdbcStudentDao implements StudentDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(Student student) throws RuntimeException {
		String sql = " INSERT INTO student(ssn, name, score)" +
		             " VALUES(?, ?, ?)";
		// update() : insert, update, delete 처리메소드
		// update(sql, new Object[]{student.getSsn(), student.getName(), student.getScore()});
		jdbcTemplate.update(sql, student.getSsn(), student.getName(), student.getScore());
		
		System.out.println("[Debug]: 학생 등록 완료!");
	}

	@Override
	public List<Student> getAll() throws RuntimeException {
		List<Student> list = null;
		String sql = " SELECT ssn, name, score" +
		             " FROM student";
		
		RowMapper<Student> rowMapper = new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setSsn(rs.getString("ssn"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				return student;
			}
		};
		list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}
	
	@Override
	public Student findBySsn(String ssn) throws RuntimeException{
		Student student = null;
		String sql = " SELECT ssn, name, score FROM student" +
	                 " WHERE ssn = ?";
		student = (Student)jdbcTemplate.queryForObject(sql, new Object[]{ssn}, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				Student student = new Student();
				student.setSsn(rs.getString("ssn"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				return student;				
			}					
		});
		return student;
	}
	
	@Override
	public List<Student> findByScore(int min, int max) throws RuntimeException{
		List<Student> list = null;
		String sql  = " SELECT ssn, name, score" +
	                  " FROM student"+
				      " WHERE score BETWEEN ? AND ?";
		list = jdbcTemplate.query(sql, new Object[]{new Integer(min), new Integer(max)}, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				Student student = new Student();
				student.setSsn(rs.getString("ssn"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				return student;				
			}
		}); 
		return list;
	}

}

/**
org.springframework.jdbc.core.JdbcTeamplate 주요 메소드 
query(String sql, RowMapper rowMapper) : List
query(String sql, Object[] args, RowMapper rowMapper) : List
queryForObject(String sql, RowMapper rowMapper) : Object
queryForObject(String sql, Object[] args, RowMapper rowMapper) : Object
queryForInt(String sql) : int
queryForInt(String sql, Object[] args) : int
update(String sql, Object ...) : int
update(String sql, Object[] args) : int
*/
