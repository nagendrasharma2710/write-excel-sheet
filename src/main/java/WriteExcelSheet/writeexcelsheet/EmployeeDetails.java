package WriteExcelSheet.writeexcelsheet;

import java.util.Date;

public class EmployeeDetails {
	
	int empId;
	String empName;
	String empEmail;
	Integer empPhone;
	Date empJoinDate;
	
	public EmployeeDetails(int empId, String empName, String empEmail, int empPhone, Date empJoinDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empJoinDate = empJoinDate;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public int getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(int empPhone) {
		this.empPhone = empPhone;
	}
	public Date getEmpJoinDate() {
		return empJoinDate;
	}
	public void setEmpJoinDate(Date empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	
}
