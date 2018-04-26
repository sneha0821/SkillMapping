package com.niit.SkillMap.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SkillMap.DAO.EmployeeDao;

import com.niit.SkillMap.Model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	
	
	public List<Employee> findAllEmployees() {
		
		return employeeDao.findAllEmployee();
	}

	public Employee findEmployeesById(int empId) {
		
		return employeeDao.findEmployeeById(empId);
	}

	public boolean addEmployee(Employee employee) {
		
		if(employeeDao.findEmployeeById(employee.getEmpId())!=null) 
		{
			return false;
		}
		else {
			
			employeeDao.addEmployee(employee);
		
			return true;
		}
	}

	public boolean updateEmployee(Employee employee) {
		if(employeeDao.findEmployeeById(employee.getEmpId())!=null) 
		{	
			employeeDao.updateEmployee(employee);
			
			return true;
		}
		else {
			System.out.println("Service"+employee.getEmpId());
			return false;
		}
	}

	public boolean deleteEmployee(int empId) {
		if(employeeDao.findEmployeeById(empId)!=null) 
		{	
			employeeDao.deleteEmployee(empId);
			return true;
		}
		else {
			return false;
		}
	}

	public Employee findEmployeesByName(String name) {
		
		return employeeDao.findEmployeeByName(name);
	}

}