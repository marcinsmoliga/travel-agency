package com.example.travelagency.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

	@Query("from Tour t left join fetch t.comments where t.id = :id")
	Tour getByIdWithComments(@Param("id") Long id);

	List<Tour> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
