package kr.or.kosta.school.domain;

/**
 * @author 김기정
 */
public class Student {
	private String ssn;
	private String name;
	private int score;
	public Student() {
	}
	public Student(String ssn, String name, int score) {
		this.ssn = ssn;
		this.name = name;
		this.score = score;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [ssn=" + ssn + ", name=" + name + ", score=" + score
				+ "]";
	}
	
}
