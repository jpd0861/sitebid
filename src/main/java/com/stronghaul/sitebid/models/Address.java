package com.stronghaul.sitebid.models;

public class Address {
    private Long id = 0L;
    private String street = "";
    private String zip = "";

    // Getters and Setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public String getStreet() {
        return this.street;
    }
    public void setStreet(String value) {
        this.street = value;
    }

    public String getZip() {
        return this.zip;
    }
    public void setZip(String value) {
        this.zip = value;
    }
}
