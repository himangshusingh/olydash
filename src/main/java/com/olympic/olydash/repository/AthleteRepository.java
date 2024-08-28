package com.olympic.olydash.repository;

import com.olympic.olydash.model.Athlete;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AthleteRepository {

    private final JdbcTemplate jdbcTemplate;

    public AthleteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Athlete> findAll() {
        String sql = "SELECT * FROM athletes";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Athlete(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sport"),
                        rs.getInt("medals")
                ));
    }

    public void save(Athlete athlete) {
        String sql = "INSERT INTO athletes (name, sport, medals) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, athlete.getName(), athlete.getSport(), athlete.getMedals());
    }
}
