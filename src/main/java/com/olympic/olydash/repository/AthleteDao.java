package com.olympic.olydash.repository;

import com.olympic.olydash.model.Athlete;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AthleteDao {

    private final String url = "jdbc:postgresql://localhost:5432/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Athlete> findAll() {
        List<Athlete> athletes = new ArrayList<>();
        String sql = "SELECT * FROM athletes";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Athlete athlete = new Athlete();
                athlete.setId(rs.getInt("id"));
                athlete.setName(rs.getString("name"));
                athlete.setSport(rs.getString("sport"));
                athlete.setMedals(rs.getInt("medals"));
                athletes.add(athlete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return athletes;
    }

    public void save(Athlete athlete) {
        String sql = "INSERT INTO athletes (name, sport, medals) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, athlete.getName());
            pstmt.setString(2, athlete.getSport());
            pstmt.setInt(3, athlete.getMedals());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
