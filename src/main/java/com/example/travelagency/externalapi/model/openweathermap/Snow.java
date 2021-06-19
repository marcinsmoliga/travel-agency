package com.example.travelagency.externalapi.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Snow {
	@JsonAlias("1h")
	private double oneH;

	@JsonAlias("3h")
	private double threeH;

}
