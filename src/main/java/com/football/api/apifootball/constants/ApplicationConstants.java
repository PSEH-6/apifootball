package com.football.api.apifootball.constants;

public class ApplicationConstants {

	public static class RestApiURL {

		public static final String GET_COUNTRIES = "https://apiv2.apifootball.com/?action=get_countries&APIkey=%s";
		public static final String GET_LEAGUES_BY_COUNTRY_ID = "https://apiv2.apifootball.com/?action=get_leagues&country_id=%s&APIkey=%s";
		public static final String GET_TEAM_NAMES_BY_LEAGUE_ID = "https://apiv2.apifootball.com/?action=get_standings&league_id=%s&APIkey=%s";

	}

}
