package net.fadi.deptemp.dao;

import java.util.List;


import net.fadi.deptemp.entity.Department;

public interface DepartmentDAO {

	 public void save(Department dept);
	 public List<Department> findAllDepartments(); 
	 public Department findDepartmentById(Long id);
	 public void update(Department dept);
	 public void deleteDept(Long deptId);
}
