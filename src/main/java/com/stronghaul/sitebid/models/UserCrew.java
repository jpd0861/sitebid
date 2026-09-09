package com.stronghaul.sitebid.models;

public class UserCrew {
    Long id;
    Long userProfileId;
    String firstName;
    String lastName;
    double hourlyRate;
    boolean isSubContractor;
    double overheadPercentage;
    boolean isActive;

    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }
    public void setUserProfileId(Long value) {
        this.userProfileId = value;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String value) {
        this.lastName = value;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double value) {
        this.hourlyRate = value;
    }

    public boolean isSubContractor() {
        return isSubContractor;
    }
    public void setSubContractor(boolean value) {
        isSubContractor = value;
    }

    public double getOverheadPercentage() {
        return overheadPercentage;
    }
    public void setOverheadPercentage(double value) {
        this.overheadPercentage = value;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean value) {
        isActive = value;
    }
}
