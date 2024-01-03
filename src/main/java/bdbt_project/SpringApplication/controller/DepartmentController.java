package bdbt_project.SpringApplication.controller;

import bdbt_project.SpringApplication.entity.Department;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.service.DepartmentService;
import bdbt_project.SpringApplication.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private OperatorService operatorService;
	
	@GetMapping("/{role}/departments")
	public String listDepartments(Model model, @PathVariable("role") String role) {
		List<Department> departments = departmentService.findAll();
		model.addAttribute("departments", departments);
		model.addAttribute("role", role);
		return "all/departments";
	}
	
	@GetMapping("/{role}/departments/{id}")
	public String showInfoDepartment(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Department department = departmentService.findById(id);
		model.addAttribute("department", department);
		model.addAttribute("role", role);
		return "info/department";
	}
	
	@GetMapping("/{role}/department/new")
	public String showNewFormDepartment(Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Department department = new Department();
		model.addAttribute("department", department);
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		return "new/new_department";
	}
	
	@PostMapping("/{role}/department/save")
	public String saveDepartment(Department department, @PathVariable("role") String role) {
		System.out.println("Received department with id: " + department.toString());
		departmentService.saveDepartment(department);
		return "redirect:/{role}/departments";
	}
	
	@GetMapping("/{role}/department/edit/{id}")
	public String showEditFormDepartment(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Department department = departmentService.findById(id);
		model.addAttribute("department", department);
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		return "edit/edit_department";
	}
	
	@PostMapping("/{role}/department/update")
	public String updateDepartment(@ModelAttribute("department") Department department, @PathVariable("role") String role) {
		departmentService.updateDepartment(department);
		
		return "redirect:/{role}/departments";
	}
	
	@GetMapping("/{role}/department/delete/{id}")
	public String deleteOperator(@PathVariable("id") Long id, @PathVariable("role") String role) {
		departmentService.deleteDepartmentById(id);
		
		return "redirect:/{role}/departments";
	}
	
	@GetMapping("/{role}/operators/{id}/departments")
	public String listDepartmentsId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Department> departments = departmentService.findAllByOperatorId(id);
		Operator operator = operatorService.findById(id);
		model.addAttribute("departments", departments);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/all/departments";
	}
	
	@GetMapping("/{role}/operators/{id}/department/new")
	public String showNewFormDepartmentId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Operator operator = operatorService.findById(id);
		List<Operator> operators = operatorService.findAll();
		Department department = new Department();
		model.addAttribute("department", department);
		model.addAttribute("operator", operator);
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		return "id/new/new_department";
	}
	
	@PostMapping("/{role}/operators/{id}/department/save")
	public String saveDepartmentId(@PathVariable("id") Long id, Department department, @PathVariable("role") String role) {
		departmentService.saveDepartment(department);
		
		return "redirect:/{role}/operators/{id}/departments";
	}
	
	@PostMapping("/{role}/operators/{operatorId}/department/update")
	public String updateDepartmentId(@ModelAttribute("department") Department department, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		departmentService.saveDepartment(department);
		
		return "redirect:/{role}/operators/{operatorId}/departments";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/department/delete/{id}")
	public String deleteOperatorId(@PathVariable("id") Long id, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		departmentService.deleteDepartmentById(id);
		
		return "redirect:/{role}/operators/{operatorId}/departments";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/department/edit/{id}")
	public String showEditFormDepartmentId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Operator operator = operatorService.findById(operatorId);
		Department department = departmentService.findById(id);
		model.addAttribute("department", department);
		model.addAttribute("operators", operators);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/edit/edit_department";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/department/{id}")
	public String showInfoDepartmentId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		Department department = departmentService.findById(id);
		Operator operator = operatorService.findById(operatorId);
		model.addAttribute("department", department);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/info/department";
	}
}