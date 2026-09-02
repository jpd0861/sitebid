package com.stronghaul.sitebid.models;

public class UserBidLineItemCrew {
    private Long id;
    private Long userBidId;
    private Long userCrewId;
    private String description;
    private double hours;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserBidId() {
        return userBidId;
    }

    public void setUserBidId(Long userBidId) {
        this.userBidId = userBidId;
    }

    public Long getUserCrewId() {
        return userCrewId;
    }

    public void setUserCrewId(Long userCrewId) {
        this.userCrewId = userCrewId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}
