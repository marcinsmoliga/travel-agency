package com.example.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/forbidden")
	public String showForbiddenErrorPage() {
		return "403error";
	}
}
