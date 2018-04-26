package com.niit.SkillMap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SkillMap.DAO.EmployeeSkillsDao;
import com.niit.SkillMap.Model.Employee;
import com.niit.SkillMap.Model.EmployeeSkills;
@Service
public class EmployeeSkillsServiceImpl implements EmployeeSkillsService{

	@Autowired
	private EmployeeSkillsDao employeeSkillsDao;
	@Override
	public List<Employee> findAllEmployeeSkills() {
	return	employeeSkillsDao.findAllEmployeeSkills();
	}

	@Override
	public boolean addEmployeeSkills(EmployeeSkills employeeSkills) {
		employeeSkillsDao.addEmployeeSkills(employeeSkills);
		return true;
	}

	@Override
	public boolean updateEmployeeSkills(EmployeeSkills employeeSkills) {
	employeeSkillsDao.updateEmployeeSkills(employeeSkills);
	return true;
	}

	@Override
	public boolean skillsToApprove(EmployeeSkills empSkillStatus) {
		employeeSkillsDao.skillsToApprove(empSkillStatus);
		return true;
	}

	@Override
	public List<Employee> approvedSkills(EmployeeSkills empSkillStatus) {
	return	employeeSkillsDao.approvedSkills(empSkillStatus);
	}

}
