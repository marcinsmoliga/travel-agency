package com.example.travelagency.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.travelagency.model.Comment;
import com.example.travelagency.model.Tour;
import com.example.travelagency.service.CommentService;
import com.example.travelagency.service.TourService;

@Controller
public class CommentController {
	private final TourService tourService;
	private final CommentService commentService;

	public CommentController(TourService tourService, CommentService commentService) {
		this.tourService = tourService;
		this.commentService = commentService;
	}

	@GetMapping("/addComment")
	public String showCommentForm(Model model) {
		List<Tour> tours = tourService.getAll();
		model.addAttribute("tours", tours);
		model.addAttribute("comment", new Comment());
		return "form-comment";
	}

	@PostMapping("/processFormComment")
	public String addCommentData(@ModelAttribute Comment comment) {
		commentService.save(comment);
		return "home";
	}
}
