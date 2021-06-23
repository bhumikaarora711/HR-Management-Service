package com.nagarro.model;
/*
 * @Author Bhumika_Arora
 */
public class Employee {
	
	long id;
	private int empCode;
	private String empName;
	private String empLoc;
	private String empMail;
	private String empDOB;
	
	
	public Employee(final long id, final int empCode, final String empName, final String empLoc, final String empMail, final String empDOB) {
		super();
		this.id = id;
		this.empCode = empCode;
		this.empName = empName;
		this.empLoc = empLoc;
		this.empMail = empMail;
		this.empDOB = empDOB;
	}
	
	public Employee(final int empCode, final String empName, final String empLoc, final String empMail, final String empDOB) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empLoc = empLoc;
		this.empMail = empMail;
		this.empDOB = empDOB;
	}
	public Employee() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(final long id) {
		this.id = id;
	}
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(final int empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(final String empName) {
		this.empName = empName;
	}
	public String getEmpLoc() {
		return empLoc;
	}
	public void setEmpLoc(final String empLoc) {
		this.empLoc = empLoc;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(final String empMail) {
		this.empMail = empMail;
	}
	public String getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(final String empDOB) {
		this.empDOB = empDOB;
	}
	
	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", empLoc=" + empLoc + ", empMail=" + empMail
				+ ", empDOB=" + empDOB + "]";
	}
	
}
