package com.niit.SkillMap.DAO;

import java.util.List;

import com.niit.SkillMap.Model.Employee;
import com.niit.SkillMap.Model.EmployeeSkills;

public interface EmployeeSkillsDao {
	public List<Employee> findAllEmployeeSkills();
	//public Employee findEmployeeSkillsBySkillName(String skillName);
	//public Employee findEmployeeByName(String name);
	public boolean addEmployeeSkills(EmployeeSkills employeeSkills);
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills);
	//public boolean deleteEmployeeSkills(int empId);
	public boolean skillsToApprove(EmployeeSkills employeeSkills);
	public List<Employee> approvedSkills(EmployeeSkills employeeSkills);
}
