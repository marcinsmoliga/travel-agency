package com.example.travelagency.service;

import java.util.List;

import com.example.travelagency.model.Tour;

public interface TourService {
	List<Tour> getAll();
	Tour getById(Long id);
	void saveOrUpdate(Tour tour);
	void delete(Long id);
	Tour getByIdWithComments(Long id);
	void addUserToTour(Long tourId, String login);
	List<Tour> getAllForNextMonth();

}
