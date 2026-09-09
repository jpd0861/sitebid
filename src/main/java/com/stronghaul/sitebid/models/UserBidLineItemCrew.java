package com.stronghaul.sitebid.models;

public class UserBidLineItemCrew {
    private Long id;
    private Long userBidId;
    private UserCrew userCrew = new UserCrew();
    private String description;
    private double hours;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public Long getUserBidId() {
        return userBidId;
    }
    public void setUserBidId(Long value) {
        this.userBidId = value;
    }

    public UserCrew getUserCrew() {
        return userCrew;
    }
    public void setUserCrew(UserCrew value) {
        this.userCrew = value;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }

    public double getHours() {
        return hours;
    }
    public void setHours(double value) {
        this.hours = value;
    }
}
