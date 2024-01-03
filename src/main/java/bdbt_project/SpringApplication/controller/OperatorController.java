package bdbt_project.SpringApplication.controller;


import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OperatorController {
	@Autowired
	private OperatorService operatorService;
	
	@GetMapping("/{role}/operators")
	public String listOperators(Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		return "all/operators";
	}
	
	@GetMapping("/{role}/operators/{id}")
	public String showInfoOperator(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Operator operator = operatorService.findById(id);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "info/operator";
	}
	
	@GetMapping("/{role}/operator/new")
	public String showNewFormOperator(Model model, @PathVariable("role") String role) {
		model.addAttribute("operator", new Operator());
		model.addAttribute("role", role);
		return "new/new_operator";
	}
	
	@PostMapping("/{role}/operator/save")
	public String saveOperator(Operator operator, @PathVariable("role") String role) {
		operatorService.saveOperator(operator);
		return "redirect:/{role}/operators";
	}
	
	@PostMapping("/{role}/operator/update")
	public String updateOperator(Operator operator, @PathVariable("role") String role) {
		operatorService.updateOperator(operator);
		return "redirect:/{role}/operators";
	}
	
	@GetMapping("/{role}/operator/edit/{id}")
	public String showEditFormOperator(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Operator operator = operatorService.findById(id);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "edit/edit_operator";
	}
	
	@GetMapping("/{role}/operator/delete/{id}")
	public String deleteOperator(@PathVariable("id") Long id, @PathVariable("role") String role) {
		operatorService.deleteOperator(id);
		return "redirect:/{role}/operators";
	}
}
