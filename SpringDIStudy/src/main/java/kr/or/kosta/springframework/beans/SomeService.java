package kr.or.kosta.springframework.beans;

import java.util.List;

public class SomeService {
	private int age;
	private String name;
	
	private User user;
	
	private List<String> nameList;
	private List<User> userList;
	
	public SomeService() {}

	public SomeService(int age, String name, User user, List<String> nameList,
			List<User> userList) {
		this.age = age;
		this.name = name;
		this.user = user;
		this.nameList = nameList;
		this.userList = userList;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	// 추가적인 비즈니스 메소드....
	public void bizMethod(){
		System.out.println("비즈니스 메소드 실행...");
	}
}
