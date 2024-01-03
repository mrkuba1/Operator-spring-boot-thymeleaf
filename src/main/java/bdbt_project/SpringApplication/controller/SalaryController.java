//package bdbt_project.SpringApplication.controller;
//
//import bdbt_project.SpringApplication.entity.Salary;
//import bdbt_project.SpringApplication.service.SalaryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//
//@Controller
//public class SalaryController {
//	@Autowired
//	private SalaryService salaryService;
//
//	@GetMapping("/{role}/salaries")
//	public String listSalaries(@PathVariable("role") String role, Model model) {
//		List<Salary> salaries = salaryService.findAll();
//		model.addAttribute("salaries", salaries);
//		return "all/salaries";
//	}
//
//	@GetMapping("/{role}/salaries/{id}")
//	public String showInfoSalary(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
//		Salary salary = salaryService.findById(id);
//		model.addAttribute("role", role);
//		model.addAttribute("salary", salary);
//		return "info/salary";
//	}
//
//	@GetMapping("/{role}/salary/new")
//	public String showNewFormSalary(Model model, @PathVariable("role") String role) {
//		model.addAttribute("role", role);
//		model.addAttribute("salary", new Salary());
//		return "new/new_salary";
//	}
//
//	@PostMapping("/{role}/salary/save")
//	public String saveSalary(Salary salary, @PathVariable("role") String role) {
//		salaryService.saveSalary(salary);
//		return "redirect:/{role}/salaries";
//	}
//
//	@PostMapping("/{role}/salary/update")
//	public String updateSalary(Salary salary, @PathVariable("role") String role) {
//		salaryService.updateSalary(salary);
//		return "redirect:/{role}/salaries";
//	}
//
//	@GetMapping("/{role}/salary/edit/{id}")
//	public String showEditFormSalary(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
//		Salary salary = salaryService.findById(id);
//		model.addAttribute("salary", salary);
//		model.addAttribute("role", role);
//		return "edit/edit_salary";
//	}
//
//	@GetMapping("/{role}/salary/delete/{id}")
//	public String deleteOperator(@PathVariable("id") Long id, @PathVariable("role") String role) {
//		salaryService.deleteSalaryById(id);
//		return "redirect:/{role}/salaries";
//	}
//}
