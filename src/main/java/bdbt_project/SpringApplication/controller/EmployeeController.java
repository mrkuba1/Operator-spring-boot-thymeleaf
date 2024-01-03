package bdbt_project.SpringApplication.controller;

import bdbt_project.SpringApplication.entity.*;
import bdbt_project.SpringApplication.service.DepartmentService;
import bdbt_project.SpringApplication.service.EmployeeService;
import bdbt_project.SpringApplication.service.OperatorService;
import bdbt_project.SpringApplication.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private SenderService senderService;
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/{role}/employees")
	public String listEmployees(Model model, @PathVariable("role") String role) {
		model.addAttribute("role", role);
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "all/employees";
	}
	
	@GetMapping("/{role}/employees/{id}")
	public String showInfoEmployee(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		model.addAttribute("role", role);
		return "info/employee";
	}
	
	@GetMapping("/{role}/employee/new")
	public String showNewFormEmployee(Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		List<Sender> senders = senderService.findAll();
		List<Department> departments = departmentService.findAll();
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("operators", operators);
		model.addAttribute("senders", senders);
		model.addAttribute("departments", departments);
		model.addAttribute("role", role);
		return "new/new_employee";
	}
	
	@PostMapping("/{role}/employee/save")
	public String saveEmployee(Employee employee, @PathVariable("role") String role) {
		employee.setOperator(employee.getDepartment().getOperator());
		employeeService.saveEmployee(employee);
		return "redirect:/{role}/employees";
	}
	
	@GetMapping("/{role}/employee/edit/{id}")
	public String showEditFormEmployee(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Employee employee = employeeService.findById(id);
		List<Sender> senders = senderService.findAll();
		List<Department> departments = departmentService.findAll();
		model.addAttribute("employee", employee);
		model.addAttribute("operators", operators);
		model.addAttribute("senders", senders);
		model.addAttribute("departments", departments);
		model.addAttribute("role", role);
		
		return "edit/edit_employee";
	}
	
	@PostMapping("/{role}/employee/update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("role") String role) {
		employee.setOperator(employee.getDepartment().getOperator());
		employeeService.updateEmployee(employee);
		return "redirect:/{role}/employees";
	}
	
	@GetMapping("/{role}/employee/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id, @PathVariable("role") String role) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/{role}/employees";
	}
	
	@GetMapping("/{role}/operators/{id}/employees")
	public String listEmployeesId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Employee> employees = employeeService.findAllByOperatorId(id);
		Operator operator = operatorService.findById(id);
		model.addAttribute("employees", employees);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/all/employees";
	}
	
	@GetMapping("/{role}/operators/{id}/employee/new")
	public String showNewFormEmployeeId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Sender> senders = senderService.findAll();
		List<Department> departments = departmentService.findAll();
		Operator operator = operatorService.findById(id);
		List<Operator> operators = operatorService.findAll();
		Employee employee = new Employee();
		model.addAttribute("senders", senders);
		model.addAttribute("departments", departments);
		model.addAttribute("employee", employee);
		model.addAttribute("operator", operator);
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		return "id/new/new_employee";
	}
	
	@PostMapping("/{role}/operators/{id}/employee/save")
	public String saveEmployeeId(@PathVariable("id") Long id, Employee employee, @PathVariable("role") String role) {
		employee.setOperator(employee.getDepartment().getOperator());
		employeeService.saveEmployee(employee);
		return "redirect:/{role}/operators/{id}/employees";
	}
	
	@PostMapping("/{role}/operators/{operatorId}/employee/update")
	public String updateEmployeeId(@ModelAttribute("employee") Employee employee, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		employee.setOperator(employee.getDepartment().getOperator());
		employeeService.saveEmployee(employee);
		return "redirect:/{role}/operators/{operatorId}/employees";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/employee/delete/{id}")
	public String deleteEmployeeId(@PathVariable("id") Long id, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/{role}/operators/{operatorId}/employees";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/employee/edit/{id}")
	public String showEditEmployeeId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		List<Sender> senders = senderService.findAll();
		List<Department> departments = departmentService.findAll();
		List<Operator> operators = operatorService.findAll();
		Operator operator = operatorService.findById(operatorId);
		Employee employee = employeeService.findById(id);
		model.addAttribute("senders", senders);
		model.addAttribute("departments", departments);
		model.addAttribute("employee", employee);
		model.addAttribute("operators", operators);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/edit/edit_employee";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/employee/{id}")
	public String showInfoEmployeeId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		Operator operator = operatorService.findById(operatorId);
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/info/employee";
	}
}