package net.fadi.deptemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.fadi.deptemp.dao.EmployeeDAO;
import net.fadi.deptemp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO empDAO;

	@Override
	public List<Employee> loadEmpBasicInfo() {
		return empDAO.getEmployeeList();
	}

	@Override
	@Transactional
	public void saveOrUpdateEmp(Employee emp,Long deptId) {
		// TODO Auto-generated method stub
		empDAO.saveEmp(emp, deptId);
		}
	
	@Override
	public Employee findEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return empDAO.getEmployeeById(id);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		 empDAO.deleteEmployeeById(id);
	}
	

}
