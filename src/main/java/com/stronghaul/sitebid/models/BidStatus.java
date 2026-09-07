package com.stronghaul.sitebid.models;

public class BidStatus {
    private Long id = 0L;
    private String status = "";

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
