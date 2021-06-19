package com.example.travelagency.externalapi.model.openweathermap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Wind {
	private double speed;
	private double deg;
	private double gust;

}
