package com.olympic.olydash.service;
import com.olympic.olydash.model.Athlete;
import com.olympic.olydash.repository.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    public void addAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }
}
