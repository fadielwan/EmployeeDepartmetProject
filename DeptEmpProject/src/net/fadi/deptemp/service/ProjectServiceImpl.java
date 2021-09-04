package net.fadi.deptemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.fadi.deptemp.dao.ProjectDAO;
import net.fadi.deptemp.entity.Project;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;
	@Override
	public void saveOrUpdateProject(Project project,List<Long> employeeIds) {
		// TODO Auto-generated method stub
		   projectDAO.save(project,employeeIds);
	}
	@Override
	public List<Project> loadBasiProjectInfo() {
		// TODO Auto-generated method stub
		return projectDAO.findAllProjects();
	}
	@Override
	public Project findProjectById(Long id) {
		// TODO Auto-generated method stub
		return projectDAO.getProjectById(id);
	}
	@Override
	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		projectDAO.deleteProject(id);
	}

}
