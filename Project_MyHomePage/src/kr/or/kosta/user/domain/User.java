package kr.or.kosta.user.domain;

public class User {

	private String id;
	private String name;
	private String passwd;
	private String email;
	private String mobile1;
	private String mobile2;
	private String mobile3;
	private String profile;

	public User(){}

	public User(String id, String name, String passwd, String email, String mobile1, String mobile2, String mobile3,
			String profile) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.mobile3 = mobile3;
		this.profile = profile;
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
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getMobile3() {
		return mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	public String getprofile() {
		return profile;
	}

	public void setprofile(String profile) {
		this.profile = profile;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + ", mobile1=" + mobile1
				+ ", mobile2=" + mobile2 + ", mobile3=" + mobile3 + ", profile=" + profile + "]";
	}
	

}
