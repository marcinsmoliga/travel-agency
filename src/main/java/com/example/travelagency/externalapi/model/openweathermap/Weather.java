package com.example.travelagency.externalapi.model.openweathermap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {
	private long id;
	private String main;
	private String description;
	private String icon;

}
