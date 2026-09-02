package com.stronghaul.sitebid.models;

public class UserCrew {
    Long id;
    Long userProfileId;
    String firstName;
    String lastName;
    double hourlyRate;
    boolean isSubContractor;
    double overheadPercentage;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserProfileId() {
        return userProfileId;
    }
    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public boolean isSubContractor() {
        return isSubContractor;
    }
    public void setSubContractor(boolean subContractor) {
        isSubContractor = subContractor;
    }
    public double getOverheadPercentage() {
        return overheadPercentage;
    }
    public void setOverheadPercentage(double overheadPercentage) {
        this.overheadPercentage = overheadPercentage;
    }
}
