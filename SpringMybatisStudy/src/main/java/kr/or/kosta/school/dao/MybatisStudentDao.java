package kr.or.kosta.school.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.school.domain.Student;

@Repository("studentDao")
public class MybatisStudentDao implements StudentDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void add(Student student) throws RuntimeException {
		
	}

	@Override
	public List<Student> getAll() throws RuntimeException {
		List<Student> list = null;
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			StudentDao dao = session.getMapper(StudentDao.class);
			list = dao.getAll();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public Student findBySsn(String ssn) throws RuntimeException {
		return null;
	}

	@Override
	public List<Student> findByScore(int min, int max) throws RuntimeException {
		return null;
	}

}
