package com.example.travelagency.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.travelagency.externalapi.model.openweathermap.OpenWeatherMap;
import com.example.travelagency.service.ExternalApiService;

@Controller
public class HomeController {
	private final ExternalApiService externalApiService;

	public HomeController(ExternalApiService externalApiService) {
		this.externalApiService = externalApiService;
	}

	@GetMapping("/")
	public String getHome(HttpServletRequest request, Model model) {
		OpenWeatherMap openWeatherMap = externalApiService.getData(request);
		model.addAttribute("openWeatherMap", openWeatherMap);
		return "home";
	}
}
