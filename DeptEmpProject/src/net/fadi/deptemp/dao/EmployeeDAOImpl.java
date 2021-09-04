package net.fadi.deptemp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import net.fadi.deptemp.entity.Department;
import net.fadi.deptemp.entity.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() {
		Query query = entityManager.createQuery("select DISTINCT OBJECT(e) from Employee e ");
		return query.getResultList();
	}
	
	@Override
	public void saveEmp(Employee emp,Long deptId) {
		// TODO Auto-generated method stub
		TypedQuery<Department> query=null;
		Department departemnt=null;
		if(deptId!=null&&deptId.equals(-1l))
			deptId=null;
		if(deptId!=null) {
		   query =entityManager.createQuery("from Department d where d.id =:id",Department.class);
		   query.setParameter("id", deptId);
		   departemnt= query.getSingleResult();
		   emp.setDepartment(departemnt);
		}
		emp.setDepartment(departemnt);
		entityManager.merge(emp);
	}


	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = entityManager.createQuery("select emp from Employee emp  where emp.id=:id",Employee.class);
		query.setParameter("id", id);
		return  query.getSingleResult();
	}
	
	@Override
	@Transactional
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("delete from Employee e  where e.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}



	

}
