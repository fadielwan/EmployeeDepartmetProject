 package net.fadi.deptemp.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.fadi.deptemp.entity.Department;
import net.fadi.deptemp.service.DepartmentService;
import net.fadi.deptemp.service.EmployeeService;



@Controller
public class DeptController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/viewDept")
	public String showDept(ModelMap model,HttpServletRequest request) {
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "dept";
	}

	@RequestMapping("/manageDept")
	public String showManageDept(ModelMap model,@ModelAttribute ("deptForm") Department d) {
		return "manageDept";
	}

	@RequestMapping(value = "/addDept")
	public String showAddDept(@ModelAttribute("deptForm")  Department dept ,
			ModelMap model ){
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		if(dept.getId()==null)
			  model.addAttribute("success", "Success added department");
			else
			  model.addAttribute("success", "Success updated department");
		try {
			deptService.saveOrUpdate(dept);
		}catch(Exception e){
			model.addAttribute("fail", "Sorry, it failed to add or update a department.");
		}	
		model.addAttribute("employeeList", empService.loadEmpBasicInfo());
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		model.addAttribute("deptForm", dept);
		return "dept";
	}
	

	@RequestMapping(value = "/updateDept")
	public String updateDept(@RequestParam("id")Long id,ModelMap model) {
		Department department=deptService.findDeptById(id);
		model.addAttribute("deptForm", department);
		return "manageDept";
	}
	
	@RequestMapping(value = "/deleteDept")
	public String deleteDept(@RequestParam("id")Long id,ModelMap model) {
		deptService.deleteDept(id);
		model.addAttribute("employeeList", empService.loadEmpBasicInfo());
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "dept";
	}
	
}

