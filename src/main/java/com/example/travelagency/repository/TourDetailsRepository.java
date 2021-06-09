package com.example.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelagency.model.TourDetails;

@Repository
public interface TourDetailsRepository extends JpaRepository<TourDetails, Long> {
}
