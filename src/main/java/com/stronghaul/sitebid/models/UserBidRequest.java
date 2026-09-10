package com.stronghaul.sitebid.models;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stronghaul.sitebid.services.ValidateUserCustomer;

public class UserBidRequest {

    private String error;
    public String getError(){
        return this.error;
    }

    private UserProfile userProfile; 
    private UserCustomer userCustomer; 
    private Address siteAddress;
    private String scopeOfWork;
    private double profitPercentage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfBid;

    @Autowired private ValidateUserCustomer validateUserCustomer;

    public UserBidRequest(
        UserProfile up,
        UserCustomer uc,
        Address sa,
        String sow,
        LocalDateTime dt){
        this.userProfile = up;
        this.userCustomer = uc;
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

    public boolean isSaved(){
        this.error = "";
        if(!this.validateUserCustomer.isValid(userCustomer)){
            this.error = this.validateUserCustomer.getError() + ", unable to save the user bid";
            return false;
        }
        return true;
    }

}
