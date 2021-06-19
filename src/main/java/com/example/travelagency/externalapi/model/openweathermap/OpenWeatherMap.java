package com.example.travelagency.externalapi.model.openweathermap;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMap {
	private Coord coord;
	private Weather[] weather;
	private String base;
	private Main main;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private Rain rain;
	private Snow snow;
	private long dt;
	private Sys sys;
	private long timezone;
	private long id;
	private String name;
	private long cod;

}
