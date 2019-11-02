package com.football.api.apifootball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.api.apifootball.constants.ApplicationConstants;
import com.football.api.apifootball.json.pojo.Country;
import com.football.api.apifootball.json.pojo.League;
import com.football.api.apifootball.json.pojo.Standing;
import com.football.api.apifootball.json.pojo.ro.ResponceROOpt;
import com.football.api.apifootball.json.ro.ResponceRO;

@Service
public class ApiFootBallService {
	
	@Autowired
	private RestService restService;

	public ResponceROOpt findStandings(String apiKey, String countryName, String leagueName, String teamName) {
		ResponceRO responceRO = new ResponceRO();
		ResponceROOpt responceROOpt = new ResponceROOpt();
		List<Country> countries = Stream
				.of(restService.loadCountry(ApplicationConstants.RestApiURL.GET_COUNTRIES, apiKey))
				.filter(e -> e.getCountry_name().equalsIgnoreCase(countryName)).collect(Collectors.toList());
		responceRO.setCountries(countries);
		List<League> leagues = new ArrayList<>();
		for (Country country : countries) {
			responceROOpt.getCountries().add(country.getCountry_id() + " - " + country.getCountry_name());
			leagues.addAll(Arrays.asList(restService.loadLeague(
					ApplicationConstants.RestApiURL.GET_LEAGUES_BY_COUNTRY_ID, country.getCountry_id(), apiKey)));

		}
		responceRO.setLeagues(leagues);

		List<Standing> standings = new ArrayList<>();
		for (League league : leagues) {
			responceROOpt.getLeagues().add(league.getLeague_id() + " - " + league.getLeague_name());
			standings.addAll(Arrays.asList(restService.loadStanding(
					ApplicationConstants.RestApiURL.GET_TEAM_NAMES_BY_LEAGUE_ID, league.getLeague_id(), apiKey)));
		}
		responceRO.setStandings(standings);

		for (Standing standing : standings) {
			responceROOpt.getTeams().add(standing.getTeam_id() + " - " + standing.getTeam_name() + " > "
					+ standing.getOverall_league_position());
		}
		return responceROOpt;
	}

}
