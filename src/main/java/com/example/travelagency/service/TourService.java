package com.example.travelagency.service;

import java.util.List;

import com.example.travelagency.model.Tour;

public interface TourService {
	List<Tour> getAll();
	Tour getById(Long id);
	void saveOrUpdate(Tour tour);
	void delete(Long id);
	void addTourDetailsIfNotExists(Tour tour);
}
