package kr.or.kosta.springframework.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
	@Value("bangry")
	private String id;
	@Value("김기정")
	private String name;
	@Value("1111")
	private String passwd;
	
	public User() {
		this(null, null, null);		
	}
	public User(String id, String name, String passwd) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}
	
}
