package com.football.api.apifootball.util;

public class UrlGenrators {

	public static String convertMeaningUrl(String apiUrl, String... parameters) {
		return String.format(apiUrl, parameters);
	}

}
