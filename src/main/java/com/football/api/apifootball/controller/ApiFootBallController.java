package com.football.api.apifootball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.football.api.apifootball.json.pojo.ro.ResponceROOpt;
import com.football.api.apifootball.service.ApiFootBallService;

@RestController
public class ApiFootBallController {

	@Autowired
	private ApiFootBallService apiFootBallService;

	@GetMapping("/findStandings")
	public ResponceROOpt findStandings(@RequestParam("apiKey") String apiKey, @RequestParam("leagueName") String leagueName,
			@RequestParam("countryName") String countryName, @RequestParam("teamName") String teamName) {
		return apiFootBallService.findStandings(apiKey, countryName, leagueName, teamName);
	}

}
