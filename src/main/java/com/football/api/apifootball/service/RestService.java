package com.football.api.apifootball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.football.api.apifootball.json.pojo.Country;
import com.football.api.apifootball.json.pojo.League;
import com.football.api.apifootball.json.pojo.Standing;
import com.football.api.apifootball.util.UrlGenrators;

@Service
public class RestService {
	
	@Autowired
	private RestTemplate restTemplate;

	public Country[] loadCountry(String apiUrl, String... parameters) {
		String url = UrlGenrators.convertMeaningUrl(apiUrl, parameters);
		return restTemplate.getForObject(url, Country[].class);
	}

	public League[] loadLeague(String apiUrl, String... parameters) {
		String url = UrlGenrators.convertMeaningUrl(apiUrl, parameters);
		return restTemplate.getForObject(url, League[].class);
	}

	public Standing[] loadStanding(String apiUrl, String... parameters) {
		String url = UrlGenrators.convertMeaningUrl(apiUrl, parameters);
		return restTemplate.getForObject(url, Standing[].class);
	}
}
