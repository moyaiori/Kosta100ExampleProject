package kr.or.kosta.swing.mvc;

public class Student {
	private String name;
	private String ssn;
	private String major;
	private String picture;
	
	public Student() {
		this(null, null, null, null);
	}
	public Student(String name, String ssn, String major, String picture) {
		this.name = name;
		this.ssn = ssn;
		this.major = major;
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", ssn=" + ssn + ", major=" + major
				+ ", picture=" + picture + "]";
	}

}
