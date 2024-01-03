package bdbt_project.SpringApplication.controller;


import bdbt_project.SpringApplication.entity.Employee;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.entity.Sender;
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
public class SenderController {
	@Autowired
	private SenderService senderService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{role}/senders")
	public String listSenders(Model model, @PathVariable("role") String role) {
		List<Sender> senders = senderService.findAll();
		model.addAttribute("role", role);
		model.addAttribute("senders", senders);
		model.addAttribute("role", role);
		return "all/senders";
	}
	
	@GetMapping("/{role}/senders/{id}")
	public String showInfoSender(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Sender sender = senderService.findById(id);
		model.addAttribute("sender", sender);
		model.addAttribute("role", role);
		return "info/sender";
	}
	
	@GetMapping("/{role}/sender/new")
	public String showNewFormSender(Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("sender", new Sender());
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		model.addAttribute("employees", employees);
		return "new/new_sender";
	}
	
	@PostMapping("/{role}/sender/save")
	public String saveSender(@ModelAttribute("sender") Sender sender, @PathVariable("role") String role) {
		senderService.saveSender(sender);
		return "redirect:/{role}/senders";
	}
	
	@GetMapping("/{role}/sender/edit/{id}")
	public String showNewFormSender(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Sender sender = senderService.findById(id);
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("sender", sender);
		model.addAttribute("operators", operators);
		model.addAttribute("role", role);
		model.addAttribute("employees", employees);
		return "edit/edit_sender";
	}
	
	@PostMapping("/{role}/sender/update")
	public String updateSender(Sender sender, @PathVariable("role") String role) {
		senderService.updateSender(sender);
		return "redirect:/{role}/senders";
	}
	
	@GetMapping("/{role}/sender/delete/{id}")
	public String deleteSender(@PathVariable("id") Long id, @PathVariable("role") String role) {
		senderService.deleteSenderById(id);
		return "redirect:/{role}/senders";
	}
	
	@GetMapping("/{role}/operators/{id}/senders")
	public String listSendersId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Sender> senders = senderService.findAllByOperatorId(id);
		Operator operator = operatorService.findById(id);
		model.addAttribute("senders", senders);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/all/senders";
	}
	
	@GetMapping("/{role}/operators/{id}/sender/new")
	public String showNewFormSenderId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		Operator operator = operatorService.findById(id);
		List<Operator> operators = operatorService.findAll();
		List<Employee> employees = employeeService.findAll();
		Sender sender = new Sender();
		model.addAttribute("sender", sender);
		model.addAttribute("operator", operator);
		model.addAttribute("operators", operators);
		model.addAttribute("employees", employees);
		model.addAttribute("role", role);
		return "id/new/new_sender";
	}
	
	@PostMapping("/{role}/operators/{id}/sender/save")
	public String saveSenderId(@PathVariable("id") Long id, Sender sender, @PathVariable("role") String role) {
		senderService.saveSender(sender);
		return "redirect:/{role}/operators/{id}/senders";
	}
	
	@PostMapping("/{role}/operators/{operatorId}/sender/update")
	public String updateDepartmentId(@ModelAttribute("sender") Sender sender, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		senderService.saveSender(sender);
		return "redirect:/{role}/operators/{operatorId}/senders";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/sender/delete/{id}")
	public String deleteSenderId(@PathVariable("id") Long id, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		senderService.deleteSenderById(id);
		return "redirect:/{role}/operators/{operatorId}/departments";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/sender/edit/{id}")
	public String showEditFormSenderId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Operator operator = operatorService.findById(operatorId);
		Sender sender = senderService.findById(id);
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("sender", sender);
		model.addAttribute("operators", operators);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		model.addAttribute("employees", employees);
		return "id/edit/edit_sender";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/sender/{id}")
	public String showInfoSenderId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		Sender sender = senderService.findById(id);
		Operator operator = operatorService.findById(operatorId);
		model.addAttribute("sender", sender);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/info/sender";
	}
}
