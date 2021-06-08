package com.example.travelagency.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Tour {
	public enum Continent {
		AFRICA, ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA;
	}

	@NotBlank(message = "Tour name cannot be empty")
	@Size(min = 5, message = "Tour name should have at least 5 characters")
	private String name;

	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]$", message = "Excepted format is LL-DDL (L-letter A-Z, D-digit 0-9)")
	private String code;

	private Continent continent;

	@NotNull(message = "Please select the date")
	@Future(message = "Date should be from the future")
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date date;

	@Min(value = 7, message = "Must be between 7 and 21")
	@Max(value = 21, message = "Must be between 7 and 21")
	private int duration;

	private boolean allInclusive = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAllInclusive() {
		return allInclusive;
	}

	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}
}
