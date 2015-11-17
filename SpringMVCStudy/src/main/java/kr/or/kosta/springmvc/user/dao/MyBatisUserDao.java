package kr.or.kosta.springmvc.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.springmvc.user.domain.User;

@Repository("userDao")
public class MyBatisUserDao implements UserDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public void insert(User user) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> selectAll() throws RuntimeException {
		List<User> list = null;
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			UserDao dao = session.getMapper(UserDao.class);
			list = dao.selectAll();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public User selectById(String id) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
