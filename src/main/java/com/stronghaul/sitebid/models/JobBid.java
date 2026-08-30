package com.stronghaul.sitebid.models;

import java.time.LocalDateTime;

public class JobBid {
    private Long id;
    private Long userProfileId;
    private Long userCustomerId;
    private Long addressId;
    private Long bidStatusId;
    private String scopeOfWork;
    private LocalDateTime dateOfBid;

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserProfileId() {
        return this.userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Long getUserCustomerId() {
        return this.userCustomerId;
    }

    public void setUserCustomerId(Long userCustomerId) {
        this.userCustomerId = userCustomerId;
    }

    public Long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getBidStatusId() {
        return this.bidStatusId;
    }

    public void setBidStatusId(Long bidStatusId) {
        this.bidStatusId = bidStatusId;
    }

    public String getScopeOfWork() {
        return this.scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public LocalDateTime getDateOfBid() {
        return this.dateOfBid;
    }

    public void setDateOfBid(LocalDateTime dateOfBid) {
        this.dateOfBid = dateOfBid;
    }
}
