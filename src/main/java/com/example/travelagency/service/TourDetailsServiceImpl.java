package com.example.travelagency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.travelagency.model.Tour;
import com.example.travelagency.model.TourDetails;
import com.example.travelagency.repository.TourDetailsRepository;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService {
	private final TourDetailsRepository tourDetailsRepository;

	public TourDetailsServiceImpl(TourDetailsRepository tourDetailsRepository) {
		this.tourDetailsRepository = tourDetailsRepository;
	}

	@Override
	public List<TourDetails> getAll() {
		return tourDetailsRepository.findAll();
	}

	@Override
	public TourDetails getById(Long id) {
		return tourDetailsRepository.getById(id);
	}

	@Override
	public void saveOrUpdate(TourDetails tourDetails) {
		tourDetailsRepository.save(tourDetails);
	}

	@Override
	public void delete(Long id) {
		tourDetailsRepository.deleteById(id);
	}
}
