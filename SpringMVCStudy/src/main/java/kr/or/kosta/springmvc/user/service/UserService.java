package kr.or.kosta.springmvc.user.service;

import java.util.List;

import kr.or.kosta.springmvc.user.domain.User;

public interface UserService {

	
	public void regist(User user) throws RuntimeException;
	
	public List<User> list() throws RuntimeException;
	
	public User get(String id) throws RuntimeException; 
}
