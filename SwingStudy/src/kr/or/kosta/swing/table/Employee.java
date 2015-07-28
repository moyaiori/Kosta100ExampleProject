package kr.or.kosta.swing.table;

import javax.swing.Icon;

public class Employee {
	private String name;
	private String ssn;
	private String department;
	private int age;
	private double weight;
	private boolean man;
	private Icon icon;
	public Employee() {}
	public Employee(String name, String ssn, String department, int age,
			double weight, boolean man, Icon icon) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.department = department;
		this.age = age;
		this.weight = weight;
		this.man = man;
		this.icon = icon;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public boolean isMan() {
		return man;
	}
	public void setMan(boolean man) {
		this.man = man;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", ssn=" + ssn + ", department="
				+ department + ", age=" + age + ", weight=" + weight + ", man="
				+ man + ", icon=" + icon + "]";
	}
}
