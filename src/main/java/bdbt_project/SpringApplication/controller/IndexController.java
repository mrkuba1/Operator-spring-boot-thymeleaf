package bdbt_project.SpringApplication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController{
	GrantedAuthority role;
	@GetMapping("/index")
	public String viewIndexHomePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				role = authority;
				System.out.println("Rola użytkownika: " + role);
			}
		}
		System.out.println(role);
		model.addAttribute("role",role.getAuthority().toLowerCase());
		return "index";
	}
	@GetMapping("/")
	public String viewHomePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				role = authority;
				System.out.println("Rola użytkownika: " + role);
			}
		}
		System.out.println(role);
		model.addAttribute("role",role.getAuthority().toLowerCase());
		return "index";
	}
}
