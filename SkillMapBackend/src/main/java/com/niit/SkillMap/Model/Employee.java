package com.niit.SkillMap.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.lang.NonNull;

@Entity
public class Employee {
	
	@Id
	private int empId;
	@NonNull
	private String empName;
	@NonNull
	private String empEmail;
	@NonNull
	private String password;
	@NonNull
	private String empType;
	@NonNull
	private String qualification;
	
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
	
//	public Date getDateOfJoining() {
//		return dateOfJoining;
//	}
//	public void setDateOfJoining(Date dateOfJoining) {
//		this.dateOfJoining = dateOfJoining;
//	}
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/*public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	
	
	

}