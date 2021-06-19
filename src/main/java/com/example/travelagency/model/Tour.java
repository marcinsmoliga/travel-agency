package com.example.travelagency.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Tour {
	public enum Continent {
		AFRICA, ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "{tour.name.notblank}")
	@Size(min = 5, message = "{tour.name.size}")
	private String name;

	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]$", message = "{tour.code.pattern}")
	private String code;

	private Continent continent;

	@NotNull(message = "{tour.date.notnull}")
	@Future(message = "{tour.date.future}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@Min(value = 7, message = "{tour.duration.minmax}")
	@Max(value = 21, message = "{tour.duration.minmax}")
	private int duration;

	private boolean allInclusive = false;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tour_details_id")
	private TourDetails tourDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@JsonIgnore
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "tour_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

}
