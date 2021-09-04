package net.fadi.deptemp.service;

import java.util.List;

import net.fadi.deptemp.entity.Department;

public interface DepartmentService {


	public List<Department> loadDeptDetails();
	public List<Department> loadDeptBasicInfo();
	public void saveOrUpdate(Department d);
	public Department findDeptById(Long deptId);
	public void deleteDept(Long deptId);
	
	
}
