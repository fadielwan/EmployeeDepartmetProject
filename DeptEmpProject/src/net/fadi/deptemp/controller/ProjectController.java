package net.fadi.deptemp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.fadi.deptemp.entity.Project;
import net.fadi.deptemp.service.EmployeeService;
import net.fadi.deptemp.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/addProject")
	public String showAddProject(@ModelAttribute("projectForm")  Project project,Long[] emp ,BindingResult bindingResult,
			ModelMap model ){
		List<Long>projects=new ArrayList<Long>();
		if(project.getId()==null)
			  model.addAttribute("success", "Success added Project");
			else
			  model.addAttribute("success", "Success updated Project");
		try {
			if(emp!=null)
		       projects=Arrays.asList(emp);	
			projectService.saveOrUpdateProject(project,projects);
		}catch(Exception e){
			model.addAttribute("fail", "Sorry, it failed to add or update a Project");
		}	
		model.addAttribute("projectForm", project);
		model.addAttribute("projectList", projectService.loadBasiProjectInfo());
		return "project";
	}
	@RequestMapping("/manageProject")
	public String manageProject(@ModelAttribute ("projectForm") Project project,ModelMap model ) {
		model.addAttribute("empList", employeeService.loadEmpBasicInfo());
		return "manageProject";
	}
	@RequestMapping("/viewProject")
	public String viewProject(@ModelAttribute ("projectForm") Project project,ModelMap model ) {
		model.addAttribute("projectList", projectService.loadBasiProjectInfo());
		return "project";
	}
	
	@RequestMapping(value = "/updateProject")
	public String updateProject(@RequestParam("id")Long id,ModelMap model) {
		model.addAttribute("projectForm", projectService.findProjectById(id));
		model.addAttribute("empList", employeeService.loadEmpBasicInfo());
		return "manageProject";
	}
	
	@RequestMapping(value = "/deleteProject")
	public String deleteProject(@RequestParam("id")Long id,ModelMap model) {
		projectService.deleteProject(id);;
		model.addAttribute("projectList", projectService.loadBasiProjectInfo());
		return "project";
	}
	
	
}
