package bdbt_project.SpringApplication.controller;

import bdbt_project.SpringApplication.entity.Customer;
import bdbt_project.SpringApplication.entity.Offer;
import bdbt_project.SpringApplication.entity.Operator;
import bdbt_project.SpringApplication.service.CustomerService;
import bdbt_project.SpringApplication.service.OfferService;
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
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private OfferService offerService;
	
	@GetMapping("/{role}/customers")
	public String listCustomers(Model model, @PathVariable("role") String role) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		model.addAttribute("role", role);
		return "all/customers";
	}
	
	
	@GetMapping("/{role}/customers/{id}")
	public String showInfoCustomer(@PathVariable("id") Long id, Model model,@PathVariable("role") String role) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		model.addAttribute("role", role);
		return "info/customer";
	}
	
	@GetMapping("/{role}/customer/new")
	public String showNewFormCustomer(Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Customer customer = new Customer();
		List<Offer> offers = offerService.findAll();
		model.addAttribute("customer", customer);
		model.addAttribute("operators", operators);
		model.addAttribute("offers", offers);
		model.addAttribute("role", role);
		return "new/new_customer";
	}
	
	@PostMapping("/{role}/customer/save")
	public String saveCustomer(Customer customer,@PathVariable("role") String role) {
		customerService.saveCustomer(customer);
		return "redirect:/{role}/customers";
	}
	
	@GetMapping("/{role}/customer/edit/{id}")
	public String showEditFormCustomer(@PathVariable("id") Long id, Model model,@PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Customer customer = customerService.findById(id);
		List<Offer> offers = offerService.findAll();
		model.addAttribute("customer", customer);
		model.addAttribute("operators", operators);
		model.addAttribute("offers", offers);
		model.addAttribute("role", role);
		return "edit/edit_customer";
	}
	
	@PostMapping("/{role}/customer/update")
	public String updateCustomer(@ModelAttribute("customer") Customer customer,@PathVariable("role") String role) {
		customerService.updateCustomer(customer);
		return "redirect:/{role}customers";
	}
	
	@GetMapping("/{role}/customer/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Long id,@PathVariable("role") String role) {
		customerService.deleteCustomerById(id);
		return "redirect:/{role}/customers";
	}
	
	@GetMapping("/{role}/operators/{id}/customers")
	public String listCustomersId(@PathVariable("id") Long id, Model model,@PathVariable("role") String role) {
		List<Customer> customers = customerService.findAllByOperatorId(id);
		Operator operator = operatorService.findById(id);
		model.addAttribute("customers", customers);
		model.addAttribute("operator", operator);
		model.addAttribute("role", role);
		return "id/all/customers";
	}
	
	@GetMapping("/{role}/operators/{id}/customer/new")
	public String showNewFormCustomerId(@PathVariable("id") Long id, Model model,@PathVariable("role") String role) {
		Operator operator = operatorService.findById(id);
		List<Operator> operators = operatorService.findAll();
		List<Offer> offers = offerService.findAll();
		Customer customer = new Customer();
		model.addAttribute("operator", operator);
		model.addAttribute("customer", customer);
		model.addAttribute("operators", operators);
		model.addAttribute("offers", offers);
		model.addAttribute("role", role);
		return "id/new/new_customer";
	}
	
	@PostMapping("/{role}/operators/{id}/customer/save")
	public String saveCustomerId(@PathVariable("id") Long id, Customer customer,@PathVariable("role") String role) {
		Operator operator=operatorService.findById(id);
		customer.setOperator(operator);
		customerService.saveCustomer(customer);
		return "redirect:/{role}/operators/{id}/customers";
	}
	
	@PostMapping("/{role}/operators/{operatorId}/customer/update")
	public String updateCustomerId(@ModelAttribute("customer") Customer customer, @PathVariable("operatorId") Long operatorId,@PathVariable("role") String role) {
		Operator operator=operatorService.findById(operatorId);
		customer.setOperator(operator);
		customerService.saveCustomer(customer);
		return "redirect:/{role}/operators/{operatorId}/customers";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/customer/delete/{id}")
	public String deleteCustomerId(@PathVariable("id") Long id, @PathVariable("operatorId") Long operatorId,@PathVariable("role") String role) {
		customerService.deleteCustomerById(id);
		return "redirect:/{role}/operators/{operatorId}/customers";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/customer/edit/{id}")
	public String showEditFormCustomerId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId,@PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Operator operator = operatorService.findById(operatorId);
		Customer customer = customerService.findById(id);
		List<Offer> offers = offerService.findAll();
		model.addAttribute("customer", customer);
		model.addAttribute("operators", operators);
		model.addAttribute("operator", operator);
		model.addAttribute("offers", offers);
		model.addAttribute("role", role);
		return "id/edit/edit_customer";
	}
	
	@GetMapping("/{role}/operators/{operatorId}/customer/{id}")
	public String showInfoCustomerId(@PathVariable("id") Long id, Model model, @PathVariable("operatorId") Long operatorId,@PathVariable("role") String role) {
		Operator operator = operatorService.findById(operatorId);
		Customer customer = customerService.findById(id);
		model.addAttribute("operator", operator);
		model.addAttribute("customer", customer);
		model.addAttribute("role", role);
		return "id/info/customer";
	}
}
