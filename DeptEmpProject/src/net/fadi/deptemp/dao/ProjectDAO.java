package net.fadi.deptemp.dao;

import java.util.List;

import net.fadi.deptemp.entity.Project;

public interface ProjectDAO {
	void save(Project project, List<Long> ids);
	List<Project> findAllProjects();
	Project getProjectById(Long id);
	void deleteProject(Long id);
}
