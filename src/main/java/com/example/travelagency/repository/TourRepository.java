package com.example.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
}
