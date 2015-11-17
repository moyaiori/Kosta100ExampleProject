package kr.or.kosta.springmvc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.springmvc.user.dao.UserDao;
import kr.or.kosta.springmvc.user.domain.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void regist(User user) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> list() throws RuntimeException {
		return userDao.selectAll();
	}

	@Override
	public User get(String id) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

}
