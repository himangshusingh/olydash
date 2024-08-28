package com.olympic.olydash.model;

public class Athlete {
    private int id;
    private String name;
    private String sport;
    private int medals;

    // Constructors
    public Athlete() {}

    public Athlete(int id, String name, String sport, int medals) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.medals = medals;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }
}
