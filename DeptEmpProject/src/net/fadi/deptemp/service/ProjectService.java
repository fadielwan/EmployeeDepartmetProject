package net.fadi.deptemp.service;

import java.util.List;
import net.fadi.deptemp.entity.Project;

public interface ProjectService {
	public void  saveOrUpdateProject (Project project, List<Long> list);
	public List<Project>  loadBasiProjectInfo ();
	public Project  findProjectById (Long id);
	public void  deleteProject (Long id);

}
