package com.football.api.apifootball.json.ro;

import java.util.List;

import com.football.api.apifootball.json.pojo.Country;
import com.football.api.apifootball.json.pojo.League;
import com.football.api.apifootball.json.pojo.Standing;

public class ResponceRO {

	private List<Country> countries;
	private List<League> leagues;
	private List<Standing> standings;

	public ResponceRO() {
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

	public List<Standing> getStandings() {
		return standings;
	}

	public void setStandings(List<Standing> standings) {
		this.standings = standings;
	}

}
