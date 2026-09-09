package com.stronghaul.sitebid.models;

import java.time.LocalDateTime;

public class UserProfile {
    private Long id;
    private boolean isActive;
    private String company;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String passwordHash;
    private double profitPercentage;
    private java.time.LocalDateTime lastLogin;

    // Getters and Setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public boolean isActive() {
        return this.isActive;
    }
    public void setActive(boolean value) {
        this.isActive = value;
    }

    public String getCompany() {
        return this.company;
    }
    public void setCompany(String value) {
        this.company = value;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String value) {
        this.phone = value;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }
    public void setPasswordHash(String value) {
        this.passwordHash = value;
    }

    public double getProfitPercentage() {
        return this.profitPercentage;
    }
    public void setProfitPercentage(double value) {
        this.profitPercentage = value;
    }

    public LocalDateTime getLastLogin() {
        return this.lastLogin;
    }
    public void setLastLogin(LocalDateTime value) {
        this.lastLogin = value;
    }
}
