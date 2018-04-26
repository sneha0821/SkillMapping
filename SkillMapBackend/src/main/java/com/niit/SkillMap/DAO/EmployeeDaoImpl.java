package com.niit.SkillMap.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SkillMap.Model.Employee;
import com.niit.SkillMap.Model.EmployeeSkills;
@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Employee> findAllEmployee() {
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public Employee findEmployeeById(int empId) {
		
		return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where empId="+empId).uniqueResult();
	}

	public boolean addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public boolean deleteEmployee(int empId) {
		sessionFactory.getCurrentSession().delete(findEmployeeById(empId));	
		return true;
	}

	public Employee findEmployeeByName(String name) {
		return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where empName='"+name+"'").uniqueResult();
	}

	@Override
	public boolean employeesToApprove(Employee employee) 
	{
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	@Override
	public List<Employee> approvedEmployees(Employee status) {
		return sessionFactory.getCurrentSession().createQuery("from Employee where status+'"+status+"'").list();
	}

}

