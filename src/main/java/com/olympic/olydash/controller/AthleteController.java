package com.olympic.olydash.controller;

import com.olympic.olydash.model.Athlete;
import com.olympic.olydash.service.AthleteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<Athlete> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    @PostMapping
    public void addAthlete(@RequestBody Athlete athlete) {
        athleteService.addAthlete(athlete);
    }
}
