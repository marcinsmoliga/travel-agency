package com.example.travelagency.service;

import javax.servlet.http.HttpServletRequest;

import com.example.travelagency.externalapi.model.openweathermap.OpenWeatherMap;

public interface ExternalApiService {
	public OpenWeatherMap getData(HttpServletRequest request);
}
