package com.example.travelagency.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.travelagency.model.Tour;
import com.example.travelagency.service.TourService;

@Controller
public class TourController {
	private final TourService tourService;

	public TourController(TourService tourService) {
		this.tourService = tourService;
	}

	@GetMapping("/addTour")
	public String showForm(Model model) {
		model.addAttribute("tour", new Tour());
		return "form";
	}

	@PostMapping("/processForm")
	public String showTourData(@Valid @ModelAttribute Tour tour, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		tourService.saveOrUpdate(tour);
		return "redirect:showOffer";
	}

	@GetMapping("/showOffer")
	public String getTours(Model model) {
		model.addAttribute("tours", tourService.getAll());
		return "tours";
	}

	@GetMapping("/deleteTour/{id}")
	public String deleteTour(@PathVariable Long id) {
		Tour tour = tourService.getById(id);
		if (tour != null) {
			tourService.delete(id);
		}
		return "redirect:/showOffer";
	}

	@GetMapping("/editTour/{id}")
	public String editTour(@PathVariable Long id, Model model) {
		Tour tour = tourService.getById(id);
		if (tour != null) {
			model.addAttribute("tour", tour);
			return "form";
		}
		return "redirect:/showOffer";
	}

	@GetMapping("/addUserToTour/{tourId}/{userId}")
	public String addUserToTour(@PathVariable Long tourId, @PathVariable Long userId) {
		tourService.addUserToTour(tourId, userId);
		return "redirect:/showOffer";
	}
}
