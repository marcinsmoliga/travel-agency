package com.example.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.travelagency.model.User;
import com.example.travelagency.service.UserService;

@Controller
public class LoginController {
	private final UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/forbidden")
	public String showForbiddenErrorPage() {
		return "403error";
	}

	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "form-signup";
	}

	@PostMapping("/processSignup")
	public String processSignup(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		boolean errors = false;

		if (!user.getPassword().equals(user.getConfirmedPassword())) {
			redirectAttributes.addAttribute("differentPasswords", "Passwords are different");
			errors = true;
		}

		if (userService.loginExists(user.getLogin())) {
			redirectAttributes.addAttribute("loginExists", "Login already exists in the database");
			errors = true;
		}

		if (errors) {
			return "redirect:/signup";
		}
		userService.createNewAccount(user);
		return "login";
	}
}
