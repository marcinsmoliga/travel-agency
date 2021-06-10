package com.example.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.travelagency.model.Tour;
import com.example.travelagency.model.TourDetails;
import com.example.travelagency.service.TourDetailsService;
import com.example.travelagency.service.TourService;

@Controller
public class TourDetailsController {
	private final TourService tourService;
	private final TourDetailsService tourDetailsService;

	public TourDetailsController(TourService tourService,
	                             TourDetailsService tourDetailsService) {
		this.tourService = tourService;
		this.tourDetailsService = tourDetailsService;
	}

	@GetMapping("/showTourDetails/{tourId}")
	public String showTourDetails(@PathVariable Long tourId, Model model) {
		Tour tour = tourService.getByIdWithComments(tourId);
		if (tour != null) {
			model.addAttribute("tour", tour);
			return "tour-details";
		}
		return "redirect:/showOffer";
	}

	@GetMapping("/editTourDetails/{tourId}")
	public String editTourDetails(@PathVariable Long tourId, Model model) {
		Tour tour = tourService.getById(tourId);
		if(tour != null) {
			model.addAttribute("tourDetails", tour.getTourDetails());
			return "form-tour-details";
		}
		return "redirect:/showOffer";
	}

	@PostMapping("/processFormTourDetails")
	public String processTourDetailsData(@ModelAttribute TourDetails tourDetails) {
		tourDetailsService.saveOrUpdate(tourDetails);
		return "redirect:/showOffer";
	}
}
