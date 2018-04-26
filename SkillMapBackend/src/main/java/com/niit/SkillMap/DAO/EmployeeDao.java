package com.niit.SkillMap.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.SkillMap.Model.Employee;


public interface EmployeeDao {

	public List<Employee> findAllEmployee();
	public Employee findEmployeeById(int empId);
	public Employee findEmployeeByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
	public boolean employeesToApprove(Employee employee);
	public List<Employee> approvedEmployees(Employee employee);
	
}