package net.fadi.deptemp.dao;

import java.util.List;

import net.fadi.deptemp.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployeeList();
	public void saveEmp (Employee emp ,Long deptId);
	public Employee getEmployeeById(Long id);
	public void deleteEmployeeById(Long id);
	
	
	

}
