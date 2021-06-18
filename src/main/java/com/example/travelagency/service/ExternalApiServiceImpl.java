package com.example.travelagency.service;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.travelagency.externalapi.model.myip.MyIP;
import com.example.travelagency.externalapi.model.openweathermap.OpenWeatherMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {
	private static final String OPENWEATHERMAP_API_KEY = "0fd3d46bc2476b3814027665ed11be9e";
	private static final String OPENWEATHERMAP_ADDRESS = "http://api.openweathermap.org/data/2.5/";
	private static final String IPAPI_ADDRESS = "http://www.geoplugin.net/json.gp?ip=";
	private static final String MYIP_ADDRESS = "https://api.myip.com";
	private static final String LOCALHOST_IP_V4 = "127.0.0.1";
	private static final String LOCALHOST_IP_V6 = "0:0:0:0:0:0:0:1";


	@Override
	public OpenWeatherMap getData(HttpServletRequest request) {
		String ip = getIpAddress(request);
		String city = getCity(ip);
		return getWeatherForCity(city);
	}

	private String getIpAddress(HttpServletRequest request) {
		String ip = request.getRemoteAddr();

		if (ip.equals(LOCALHOST_IP_V4) || ip.equals(LOCALHOST_IP_V6)) {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(MYIP_ADDRESS, String.class);
			ObjectMapper mapper = new ObjectMapper();
			MyIP myIP = new MyIP();

			try {
				myIP = mapper.readValue(result, MyIP.class);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			ip = myIP.getIp();
		}
		return ip;
	}

	private String getCity(String ip) {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(IPAPI_ADDRESS + ip, String.class);
		JSONObject jsonObject = new JSONObject(response);
		return jsonObject.getString("geoplugin_city");
	}

	private OpenWeatherMap getWeatherForCity(String city) {
		StringBuilder url = new StringBuilder();
		url.append(OPENWEATHERMAP_ADDRESS).append("weather?q=").append(city).append("&units=metric").append("&appid=")
				.append(OPENWEATHERMAP_API_KEY);

		RestTemplate restTemplate = new RestTemplate();
		OpenWeatherMap openWeatherMap = new OpenWeatherMap();

		try {
			String response = restTemplate.getForObject(url.toString(), String.class);
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			openWeatherMap = mapper.readValue(response, OpenWeatherMap.class);
		} catch (JsonProcessingException | HttpClientErrorException e) {
			e.printStackTrace();
			return null;
		}

		return openWeatherMap;
	}
}
