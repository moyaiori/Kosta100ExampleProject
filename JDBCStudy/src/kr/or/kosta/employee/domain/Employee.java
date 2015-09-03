package kr.or.kosta.employee.domain;


/**
 * employees 테이블과 매핑을 위한 O-R Mapping 클래스 
 * @author Lee Gwangyong
 *
 */
public class Employee {
	private int employeeId;			// 사원번호
	private String firstName;		// 이름
	private String lastName;		// 성
	private String email;			// 이메일
	private String phoneNumber;		// 전화번호
	private String hireDate;		// 입사일
	private int salary;				// 급여
	private double commissionPct;	// 커미션 비율
	private String jobId;			// 직무명
	private int managerId;			// 담당 관리원 번호
	private int departmentId;		// 부서 번호
	
	public Employee() {}

	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			String hireDate, int salary, double commissionPct, String jobId, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.jobId = jobId;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", jobId=" + jobId + ", managerId=" + managerId
				+ ", departmentId=" + departmentId + "]";
	}

}
