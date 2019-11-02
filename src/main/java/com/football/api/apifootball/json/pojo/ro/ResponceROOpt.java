package com.football.api.apifootball.json.pojo.ro;

import java.util.ArrayList;
import java.util.List;

public class ResponceROOpt {

	private List<String> countries = new ArrayList<>();
	private List<String> leagues = new ArrayList<>();;
	private List<String> teams = new ArrayList<>();;

	public ResponceROOpt() {
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<String> getLeagues() {
		return leagues;
	}

	public void setLeagues(List<String> leagues) {
		this.leagues = leagues;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

}
