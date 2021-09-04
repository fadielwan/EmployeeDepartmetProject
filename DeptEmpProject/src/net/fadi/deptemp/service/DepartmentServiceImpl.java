package net.fadi.deptemp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.fadi.deptemp.dao.DepartmentDAO;
import net.fadi.deptemp.dao.EmployeeDAO;
import net.fadi.deptemp.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO deptDAO;
	@Autowired
	EmployeeDAO empDAO;
	
	
    
	@Override
	public void saveOrUpdate(Department dept) {
		if (dept.getId() == null)
			deptDAO.save(dept);
		else
			deptDAO.update(dept);

	}
		
	@Override
	public List<Department> loadDeptDetails() {
		return deptDAO.findAllDepartments();
	}


	@Override
	public Department findDeptById(Long deptId) {
		// TODO Auto-generated method stub
		return deptDAO.findDepartmentById(deptId);
	}

	@Override
	public void deleteDept(Long deptId) {
		// TODO Auto-generated method stub
		Department dept=findDeptById(deptId);
		dept.getEmployeeList().forEach(emp->{
		empDAO.saveEmp(emp, null);
		});
		deptDAO.deleteDept(deptId);
	}

	@Override
	public List<Department> loadDeptBasicInfo() {
		// TODO Auto-generated method stub
		return deptDAO.findAllDepartments();
	}


	

}


