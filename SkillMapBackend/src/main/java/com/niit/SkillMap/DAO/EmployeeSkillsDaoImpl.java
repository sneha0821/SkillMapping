package com.niit.SkillMap.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SkillMap.Model.Employee;
import com.niit.SkillMap.Model.EmployeeSkills;
@Repository("employeeSkillsDao")
@Transactional
public class EmployeeSkillsDaoImpl implements EmployeeSkillsDao {

	@Autowired
	private SessionFactory sessionFactory;
	public List<Employee> findAllEmployeeSkills() {
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}


	public boolean addEmployeeSkills(EmployeeSkills employeeSkills) {
		sessionFactory.getCurrentSession().save(employeeSkills);
		return true;
	}

	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {
		sessionFactory.getCurrentSession().update(employeeSkills);
		return true;
	}


	@Override
	public boolean skillsToApprove(EmployeeSkills employeeSkills) {
		sessionFactory.getCurrentSession().update(employeeSkills);
		return true;
	}

	@Override
	public List<Employee> approvedSkills(EmployeeSkills empSkillStatus) {
		return sessionFactory.getCurrentSession().createQuery("from EmployeeSkills where empSkillStatus='"+empSkillStatus+"'").list();
	}



	/*public boolean deleteEmployeeSkills(int empId) {
		sessionFactory.getCurrentSession().delete(findEmployeeById(empId));	
		return true;
	}
*/
	

}
