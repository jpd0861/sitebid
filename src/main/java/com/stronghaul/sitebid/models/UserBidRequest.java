package com.stronghaul.sitebid.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserBidRequest {

    private String error;
    public String getError(){
        return this.error;
    }

    private UserProfile userProfile; 
    private UserCustomer userCustomer; 
    private BidStatus bidStatus;
    private Address siteAddress;
    private String scopeOfWork;
    private double profitPercentage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfBid;

    public UserBidRequest(
        UserProfile up,
        UserCustomer uc,
        BidStatus bs,
        Address sa,
        String sow,
        LocalDateTime dt){
        this.userProfile = up;
        this.userCustomer = uc;
        this.bidStatus = bs;
        this.siteAddress = sa;
        this.dateOfBid = dt;
        this.scopeOfWork = sow;
    }

    public UserProfile getUserProfile(){
        return this.userProfile;
    }
    public UserCustomer getUserCustomer(){
        return this.userCustomer;
    }
    public BidStatus getBidStatus(){
        return this.bidStatus;
    }
    public Address getSiteAddress(){
        return this.siteAddress;
    }
    public String getScopeOfWork(){
        return this.scopeOfWork;
    }
    public double getProfitPercentage(){
        return this.profitPercentage;
    }
    public LocalDateTime getDateOfBid(){
        return this.dateOfBid;
    }
}
