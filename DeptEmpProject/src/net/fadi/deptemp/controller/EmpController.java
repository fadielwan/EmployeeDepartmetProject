package net.fadi.deptemp.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.fadi.deptemp.entity.Employee;
import net.fadi.deptemp.service.DepartmentService;
import net.fadi.deptemp.service.EmployeeService;



@Controller
public class EmpController {
	
	
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	DepartmentService deptService;
	
	
	@RequestMapping("/viewEmp")
	public String showEmp(ModelMap model,HttpServletRequest request) {
		model.addAttribute("employeeList", employeeService.loadEmpBasicInfo());
		request.getSession().setAttribute("employeeList", employeeService.loadEmpBasicInfo());
		return "emp";
	}
	
	@RequestMapping("/manageEmp")
	public String manageEmp(@ModelAttribute ("empForm") Employee emp,ModelMap model) {
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "manageEmp";
	}
	@RequestMapping(value = "/addEmp")
	public String showAddEmp( @ModelAttribute("empForm") Employee emp,Long dept,BindingResult bindingResult ,ModelMap model){
		if (bindingResult.hasErrors()||dept.equals(-1l)) {
			model.addAttribute("deptList", deptService.loadDeptBasicInfo());
			return "manageEmp";
		}
		employeeService.saveOrUpdateEmp(emp, dept);
		model.addAttribute("employeeList", employeeService.loadEmpBasicInfo());
		if (emp.getId() == null)
			model.addAttribute("success", "Success added Employee");
		else
			model.addAttribute("success", "Success updated Employee");
		return "emp";
	}
	
	@RequestMapping(value = "/updateEmp")
	public String updateEmp(@RequestParam("id")Long id,ModelMap model,HttpServletRequest request) {
		Employee employee = employeeService.findEmployeeById(id);
		model.addAttribute("empForm", employee);
		request.getSession().setAttribute("employeeList", employee);
		model.addAttribute("deptList", deptService.loadDeptBasicInfo());
		return "manageEmp";
	}
	
	@RequestMapping(value = "/deleteEmp")
	public String deleteEmp(@RequestParam("id")Long id,ModelMap model,HttpServletRequest request) {
		employeeService.deleteEmployeeById(id);
		model.addAttribute("employeeList", employeeService.loadEmpBasicInfo());
		return "emp";
	}

}
