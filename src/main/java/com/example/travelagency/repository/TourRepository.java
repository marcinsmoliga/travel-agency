package com.example.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM tour t LEFT JOIN comment c "
			+ "ON t.id = c.tour_id")
	Tour getByIdWithComments(Long id);
}
