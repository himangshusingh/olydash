package com.olympic.olydash.dao;
import com.olympic.olydash.domain.Athlete;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteDao extends JpaRepository<Athlete, Long> {

    List<Athlete> findAll();
    Athlete findById(long id);
    Athlete save(Athlete athlete);
    void deleteById(long id);
}
