package com.niit.SkillMap;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SkillMap.Config.ApplicationContext;
import com.niit.SkillMap.Model.Employee;
import com.niit.SkillMap.Service.EmployeeService;
@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ApplicationContext.class)
public class EmployeeTest {



		@Autowired
		private EmployeeService employeeService;
		private Employee emp1,emp2;
		
		@Before
		public void setup() {
			if(employeeService.findEmployeesByName("Ram")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("Ram").getEmpId());
			}
			
			if(employeeService.findEmployeesByName("John")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
			}
			
			if(employeeService.findEmployeesByName("Sam")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("Sam").getEmpId());
			}
			emp1=new Employee();
			emp1.setEmpId(101);
			emp1.setEmpName("John");
			emp1.setEmpEmail("John@gmail.com");
		
			emp1.setEmpType("Trainer");
		//	emp1.setDateOfBirth(new Date(12/12/1990));
			emp1.setQualification("B.E");
			emp1.setPassword("niit@123");
			//emp1.setStatus("null");
			//emp1.setDateOfJoining(new Date(12/12/2016));
			emp2=new Employee();
			emp2.setEmpId(102);

			emp2.setEmpName("Sam");
			emp2.setEmpEmail("Sam@gmail.com");
		
			emp2.setEmpType("Trainer");
			//emp2.setDateOfBirth(new Date(12/12/1990));
			emp2.setQualification("B.E");
			emp2.setPassword("niit@123");
			//emp2.setStatus("null");
			//emp2.setDateOfJoining(new Date(12/12/2016));
			employeeService.addEmployee(emp1);
			employeeService.addEmployee(emp2);
		}
		
		@After
		public void teardown() {
			
			employeeService.deleteEmployee(employeeService.findEmployeesByName("John").getEmpId());
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Sam").getEmpId());
			if(employeeService.findEmployeesByName("Ram")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("Ram").getEmpId());
			}
			
		}
		
		
		@Test
		public void testAddEmployee() {
			
			Employee emp=new Employee();
			
			emp.setEmpId(103);

			emp.setEmpName("Ram");
			emp.setEmpEmail("Ram@gmail.com");
		
			emp.setEmpType("Trainer");
		//	emp.setDateOfBirth(new Date(12/12/1990));
			emp.setQualification("B.E");
			emp.setPassword("niit@123");
			//emp.setStatus("null");
			//emp.setDateOfJoining(new Date(12/12/2016));
			assertEquals(true, employeeService.addEmployee(emp));
					
		}
		
		@Test
		public void testAddEmployeeFailure() {
			
			assertEquals(false, employeeService.addEmployee(emp1));
		}
		@Test
		public void testUpdateEmployee() {
			
			emp1.setEmpEmail("Sam12@gmail.com");
			emp1.setEmpType("Trainer");
			assertEquals(true, employeeService.updateEmployee(emp1));
					
		}
		@Test//"Trying to update primary key value EmpId"
		public void testUpdateEmployeeIdFailure() {
			
	//	Employee emp=new Employee();
			emp1.setEmpId(111);
			assertEquals(false, employeeService.updateEmployee(emp1));
					
		}
		@Test//"Trying to update Employee which is not in db"
		public void testUpdateEmployeeFailure() {
			
			Employee emp=new Employee();
			emp.setEmpEmail("xxx@gmail.com");
			assertEquals(false, employeeService.updateEmployee(emp));
					
		}
		@Test
		public void testDeleteEmployee() {
			
			
			Employee emp=new Employee();
			emp.setEmpEmail("xxx@gmail.com");
			emp.setEmpId(103);

			emp.setEmpName("xxX");
			
			employeeService.addEmployee(emp);
			assertEquals(true, employeeService.deleteEmployee(emp.getEmpId()));
					
		}
		@Test
		public void testDeleteEmployeeFailure() {
			
			Employee emp=new Employee();
			
			assertEquals(false, employeeService.deleteEmployee(emp.getEmpId()));
					
		}
}