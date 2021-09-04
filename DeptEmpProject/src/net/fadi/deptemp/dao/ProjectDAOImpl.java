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
import net.fadi.deptemp.entity.Project;
@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void save(Project project,List<Long> ids) {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query=null ;
		 if(!ids.isEmpty()) {
		   query =entityManager.createQuery("from Employee e where e.id in(:ids)",Employee.class);
		   query.setParameter("ids", ids);
		   List<Employee> employees= query.getResultList();
		   project.setEmployees(employees);
		 }
		entityManager.merge(project);
	}
	@Override
	public List<Project> findAllProjects() {
		// TODO Auto-generated method stub
		TypedQuery<Project> query =entityManager.createQuery("select DISTINCT OBJECT(d) from Project d",Project.class);
		return query.getResultList();
	}
	@Override
	public Project getProjectById(Long id) {
		// TODO Auto-generated method stub
		TypedQuery<Project> query =entityManager.createQuery("from Project o where o.id =:id",Project.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	@Override
	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("delete from Project d  where d.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
