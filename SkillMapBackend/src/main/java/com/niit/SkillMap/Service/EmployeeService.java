package com.niit.SkillMap.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.SkillMap.Model.Employee;


import java.util.List;



public interface EmployeeService {

	public List<Employee> findAllEmployees();
	public Employee findEmployeesById(int empId);
	public Employee findEmployeesByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int empId);
}
