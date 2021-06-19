package com.example.travelagency.externalapi.model.openweathermap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sys {
	private long type;
	private long id;
	private String message;
	private String country;
	private long sunrise;
	private long sunset;

}
