package com.stronghaul.sitebid.models;

public class UserBidResponse {
    private String em = "";
    private UserBid ub = new UserBid();

    public String getErrorMessage(){
        return this.em;
    }
    public UserBid getUserBid(){
        return this.ub;
    }
}
