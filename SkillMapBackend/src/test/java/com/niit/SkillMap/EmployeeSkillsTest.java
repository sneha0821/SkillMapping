package com.niit.SkillMap;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SkillMap.Config.ApplicationContext;
import com.niit.SkillMap.Model.EmployeeSkills;

import com.niit.SkillMap.Service.EmployeeSkillsService;
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationContext.class)
public class EmployeeSkillsTest {

	@Autowired
	private EmployeeSkillsService employeeSkillsService;
	EmployeeSkills emp;
	@Before
	public void setup() {
		emp=new EmployeeSkills();
		
		emp.setNoOfStudents(100);
		emp.setEmployeeId(31899);
		emp.setTechnicalSkills("Java");
		emp.setYearsOfExperience(10);
		emp.setDesignation("Tech-Mentor");
		emp.setRating("Excellent");
		emp.setEmpSkillStatus("null");
		employeeSkillsService.addEmployeeSkills(emp);
	}
	
	
	@Test
	public void testAddEmployeeSkills() {
		
		EmployeeSkills emp=new EmployeeSkills();
		
		emp.setNoOfStudents(100);
		emp.setEmployeeId(31898);
		emp.setTechnicalSkills("Java");
		emp.setYearsOfExperience(10);
		emp.setDesignation("Tech-Mentor");
		emp.setRating("Excellent");
		emp.setEmpSkillStatus("null");
		

		assertEquals(true, employeeSkillsService.addEmployeeSkills(emp));
				
	}
	
/*	@Test
	public void testUpdateEmployee() {
	
		emp.setNoOfStudents(150);
		//emp1.setEmpType("Trainer");
		assertEquals(true, employeeSkillsService.updateEmployeeSkills(emp));
				
	}
	
	*/
	
}
