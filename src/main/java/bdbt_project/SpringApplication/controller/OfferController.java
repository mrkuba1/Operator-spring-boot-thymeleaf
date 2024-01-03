package bdbt_project.SpringApplication.controller;

import bdbt_project.SpringApplication.entity.*;
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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Controller
public class OfferController {
	@Autowired
	private OfferService offerService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{role}/offers")
	public String listOffers(Model model, @PathVariable("role") String role) {
		List<Offer>  offers = offerService.findAll();
		Comparator<Offer> idComparator = Comparator.comparing(Offer::getOfferId);
		Collections.sort(offers, idComparator);
		model.addAttribute("offers", offers);
		model.addAttribute("role",role);
		return "all/offers";
	}
	@GetMapping("/{role}/offers/{id}")
	public String showInfoOffer(@PathVariable("id") Long id, Model model, @PathVariable("role") String role)
	{
		Offer offer=offerService.findById(id);
		model.addAttribute("offer",offer);
		model.addAttribute("role",role);
		return "info/offer";
	}
	
	@GetMapping("/{role}/offer/new")
	public String showNewFormOffer(Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Offer offer= new Offer();
		List<Customer> customers= customerService.findAll();
		model.addAttribute("offer", offer);
		model.addAttribute("operators", operators);
		model.addAttribute("customers",customers);
		model.addAttribute("role",role);
		return "new/new_offer";
	}
	
	@PostMapping("/{role}/offer/save")
	public String saveOffer(Offer offer, @PathVariable("role") String role) {
		offer.setOperator(offer.getCustomer().getOperator());
		offerService.saveOffer(offer);
		return "redirect:/{role}/offers";
	}
	
	@GetMapping("/{role}/offer/edit/{id}")
	public String showEditFormOffer(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Offer offer = offerService.findById(id);
		List<Customer> customers= customerService.findAll();
		model.addAttribute("offer", offer);
		model.addAttribute("operators", operators);
		model.addAttribute("customers",customers);
		model.addAttribute("role",role);
		return "edit/edit_offer";
	}
	
	@PostMapping("/{role}/offer/update")
	public String updateCustomer(@ModelAttribute("customer") Offer offer, @PathVariable("role") String role) {
		offer.setOperator(offer.getCustomer().getOperator());
		offerService.updateOffer(offer);
		return "redirect:/{role}/offers";
	}
	@GetMapping("/{role}/offer/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Long id, @PathVariable("role") String role) {
		offerService.deleteOfferById(id);
		return "redirect:/{role}/offers";
	}
	@GetMapping("/{role}/operators/{id}/offers")
	public String listOffersId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Offer> offers = offerService.findAllByOperatorId(id);
		Operator operator = operatorService.findById(id);
		model.addAttribute("offers", offers);
		model.addAttribute("operator", operator);
		model.addAttribute("role",role);
		return "id/all/offers";
	}
	@GetMapping("/{role}/operators/{id}/offer/new")
	public String showNewFormOfferId(@PathVariable("id") Long id, Model model, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Offer offer= new Offer();
		List<Customer>customers=customerService.findAllByOperatorId(id);
		Operator operator = operatorService.findById(id);
		model.addAttribute("offer", offer);
		model.addAttribute("operator",operator);
		model.addAttribute("operators", operators);
		model.addAttribute("customers",customers);
		model.addAttribute("role",role);
		return "id/new/new_offer";
	}
	@PostMapping("/{role}/operators/{id}/offer/save")
	public String saveOfferId(@PathVariable("id") Long id,Offer offer, @PathVariable("role") String role) {
		offer.setOperator(offer.getCustomer().getOperator());
		offerService.saveOffer(offer);
		return "redirect:/{role}/operators/{id}/offers";
	}
	@PostMapping("/{role}/operators/{operatorId}/offer/update")
	public String updateEmployeeId(@ModelAttribute("offer") Offer offer,@PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		offer.setOperator(offer.getCustomer().getOperator());
		offerService.saveOffer(offer);
		return "redirect:/{role}/operators/{operatorId}/offers";
	}
	@GetMapping("/{role}/operators/{operatorId}/offer/delete/{id}")
	public String deleteOfferId(@PathVariable("id") Long id, @PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		offerService.deleteOfferById(id);
		return "redirect:/{role}/operators/{operatorId}/offers";
	}
	@GetMapping("/{role}/operators/{operatorId}/offer/edit/{id}")
	public String showEditOfferId(@PathVariable("id") Long id, Model model,@PathVariable("operatorId") Long operatorId, @PathVariable("role") String role) {
		List<Operator> operators = operatorService.findAll();
		Operator operator=operatorService.findById(operatorId);
		List<Customer> customers= customerService.findAllByOperatorId(id);
		Offer offer = offerService.findById(id);
		model.addAttribute("offer", offer);
		model.addAttribute("operators", operators);
		model.addAttribute("operator",operator);
		model.addAttribute("customers",customers);
		model.addAttribute("role",role);
		return "id/edit/edit_offer";
	}
	@GetMapping("/{role}/operators/{operatorId}/offer/{id}")
	public String showInfoOfferId(@PathVariable("id") Long id, Model model,@PathVariable("operatorId") Long operatorId, @PathVariable("role") String role)
	{
		Offer offer=offerService.findById(id);
		Operator operator=operatorService.findById(operatorId);
		model.addAttribute("offer",offer);
		model.addAttribute("operator",operator);
		model.addAttribute("role",role);
		return "id/info/offer";
	}
}
