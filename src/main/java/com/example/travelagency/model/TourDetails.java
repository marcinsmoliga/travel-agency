package com.example.travelagency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tour_details")
public class TourDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String country;

	@Column(length = 2000)
	private String description;

	/*
	* uncomment to get a bidirectional mapping
	@OneToOne(mappedBy = "tourDetails")
	private Tour tour;
	 */
}
