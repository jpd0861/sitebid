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
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return this.isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getCompany() {
        return this.company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswordHash() {
        return this.passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public double getProfitPercentage() {
        return this.profitPercentage;
    }
    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }
    public LocalDateTime getLastLogin() {
        return this.lastLogin;
    }
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
