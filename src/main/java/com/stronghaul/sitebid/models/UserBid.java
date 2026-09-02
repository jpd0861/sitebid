package com.stronghaul.sitebid.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UserBid {
    private Long id;
    private Long userProfileId;
    private Long userCustomerId;
    private Long addressId;
    private Long bidStatusId;
    private String scopeOfWork;
    private BigDecimal profitPercentageOverride;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
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

    public BigDecimal getProfitPercentageOverride() {
        return this.profitPercentageOverride;
    }

    public void setProfitPercentageOverride(BigDecimal profitPercentageOverride) {
        this.profitPercentageOverride = profitPercentageOverride;
    }

    public LocalDateTime getDateOfBid() {
        return this.dateOfBid;
    }

    public void setDateOfBid(LocalDateTime dateOfBid) {
        this.dateOfBid = dateOfBid;
    }
}
