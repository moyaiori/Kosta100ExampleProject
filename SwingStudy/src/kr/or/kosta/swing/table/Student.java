package kr.or.kosta.swing.table;

public class Student {
	private String name;
	private String ssn;
	private String major;
	public Student() {
		this(null, null, null);
	}
	public Student(String name, String ssn, String major) {
		this.name = name;
		this.ssn = ssn;
		this.major = major;
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
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", ssn=" + ssn + ", major=" + major
				+ "]";
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}

}
