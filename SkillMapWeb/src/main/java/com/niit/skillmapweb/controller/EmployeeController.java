package com.niit.skillmapweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.SkillMap.Model.Employee;
import com.niit.SkillMap.Service.EmployeeService;
@RestController
@CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/web/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public ResponseEntity<List<Employee>> listAllEmployees() {
		
		return new ResponseEntity<List<Employee>>(employeeService.findAllEmployees(), HttpStatus.CREATED);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
		
		if(employeeService.findEmployeesById(empId)!=null) {
			return new ResponseEntity<Employee>(employeeService.findEmployeesById(empId), HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND); 
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("empId") int empId) {
		
		if(employeeService.findEmployeesById(empId)!=null) {
			employeeService.deleteEmployee(empId);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		
		if(employeeService.findEmployeesByName(employee.getEmpName())!=null) {
			
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else {
			employeeService.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
		
//		System.out.println("&&&&"+employee.getEmpId());
	if(employeeService.findEmployeesById(employee.getEmpId())!=null) {
		
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
