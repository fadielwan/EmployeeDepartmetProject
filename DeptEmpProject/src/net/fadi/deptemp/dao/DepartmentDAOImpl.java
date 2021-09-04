package net.fadi.deptemp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.fadi.deptemp.entity.Department;


@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	EmployeeDAO empDAO;

	@Override
	public void save(Department dept) {
		entityManager.persist(dept);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllDepartments() {
		Query query = entityManager.createQuery("select DISTINCT OBJECT(d) from Department d ");
		return query.getResultList();
	}


@Override
public Department findDepartmentById(Long id) {
	// TODO Auto-generated method stub
	TypedQuery<Department> query = entityManager.createQuery("select d from Department d  where d.id=:id",Department.class);
	query.setParameter("id", id);
	return  query.getSingleResult();
	
	
}

@Override
public void update(Department dept) {
	// TODO Auto-generated method stub
	TypedQuery<Department> query = entityManager.createQuery("select d from Department d  where d.id=:id",Department.class);
	query.setParameter("id", dept.getId());
	Department updateDepartment=  query.getSingleResult();
	updateDepartment.setLocation(dept.getLocation());
	updateDepartment.setName(dept.getName());
	updateDepartment.setManager(dept.getManager());
	entityManager.persist(updateDepartment);
}

@Override
public void deleteDept(Long id) {
	// TODO Auto-generated method stub
	Query query = entityManager.createQuery("delete from Department d  where d.id=:id");
	query.setParameter("id", id);
	query.executeUpdate();
}

	
}
