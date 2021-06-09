package com.example.travelagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.travelagency.model.Tour;
import com.example.travelagency.repository.TourRepository;
@Service
public class TourServiceImpl implements TourService {
	private final TourRepository tourRepository;

	public TourServiceImpl(TourRepository tourRepository) {
		this.tourRepository = tourRepository;
	}

	@Override
	public List<Tour> getAll() {
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(Long id) {
		return tourRepository.getById(id);
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourRepository.save(tour);
	}

	@Override
	public void delete(Long id) {
		tourRepository.deleteById(id);
	}
}
