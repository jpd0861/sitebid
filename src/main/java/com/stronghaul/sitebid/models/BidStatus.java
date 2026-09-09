package com.stronghaul.sitebid.models;

public class BidStatus {
    private Long id = 0L;
    private String status = "";

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String value) {
        this.status = value;
    }
}
