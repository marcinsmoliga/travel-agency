package com.example.travelagency.service;

import java.util.List;

import com.example.travelagency.model.Tour;
import com.example.travelagency.model.TourDetails;

public interface TourDetailsService {
	List<TourDetails> getAll();
	TourDetails getById(Long id);
	void saveOrUpdate(TourDetails tourDetails);
	void delete(Long id);
}
