package net.fadi.deptemp.service;

import java.util.List;


import net.fadi.deptemp.entity.Employee;

public interface EmployeeService {

	public List<Employee> loadEmpBasicInfo();
	public void  saveOrUpdateEmp (Employee emp,Long deptId);
	public Employee findEmployeeById(Long id);
	public void deleteEmployeeById(Long id);

}
