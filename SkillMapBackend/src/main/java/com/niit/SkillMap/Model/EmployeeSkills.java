package com.niit.SkillMap.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class EmployeeSkills
{
	@Id
	private	int employeeId;
	@NonNull
	private String technicalSkills;
	@NonNull
	private int yearsOfExperience;
	@NonNull
	private String designation;
	@NonNull
	private int noOfStudents;
	@NonNull
	private String rating;
	@NonNull
	private String empSkillStatus;
	public String getEmpSkillStatus() {
		return empSkillStatus;
	}
	public void setEmpSkillStatus(String empSkillStatus) {
		this.empSkillStatus = empSkillStatus;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(String technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	

}
