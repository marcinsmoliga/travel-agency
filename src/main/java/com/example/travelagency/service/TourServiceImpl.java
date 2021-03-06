package com.example.travelagency.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.travelagency.error.TourNotFoundException;
import com.example.travelagency.model.Tour;
import com.example.travelagency.model.TourDetails;
import com.example.travelagency.model.User;
import com.example.travelagency.repository.TourRepository;
import com.example.travelagency.repository.UserRepository;

@Service
@Transactional
public class TourServiceImpl implements TourService {
	private final TourRepository tourRepository;
	private final UserRepository userRepository;

	public TourServiceImpl(TourRepository tourRepository,
	                       UserRepository userRepository) {
		this.tourRepository = tourRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Tour> getAll() {
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(Long id) {
		return tourRepository.findById(id).orElseThrow(() -> new TourNotFoundException("Tour id " + id + " not found"));
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourRepository.save(tour);
	}

	@Override
	public void delete(Long id) {
		tourRepository.deleteById(id);
	}

	public Tour getByIdWithComments(Long id) {
		return tourRepository.getByIdWithComments(id);
	}

	@Override
	public void addUserToTour(Long tourId, String login) {
		Tour tour = getById(tourId);
		if (tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}

		User user = userRepository.findByLogin(login);
		if (user != null) {
			tour.getUsers().add(user);
			saveOrUpdate(tour);
		}
	}

	@Override
	public List<Tour> getAllForNextMonth() {
		LocalDate currentDate = LocalDate.now();
		LocalDate futureDate = currentDate.plusWeeks(4);
		return tourRepository.findByDateBetween(currentDate, futureDate);
	}
}
