package com.olympic.olydash.service;

import com.olympic.olydash.model.Athlete;
import com.olympic.olydash.repository.AthleteDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {

    private final AthleteDao athleteDao;

    public AthleteService(AthleteDao athleteDao) {
        this.athleteDao = athleteDao;
    }

    public List<Athlete> getAllAthletes() {
        return athleteDao.findAll();
    }

    public void addAthlete(Athlete athlete) {
        athleteDao.save(athlete);
    }
}
