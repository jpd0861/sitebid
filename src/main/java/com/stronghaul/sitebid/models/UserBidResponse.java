package com.stronghaul.sitebid.models;

public class UserBidResponse {
    private String error = "";
    private UserBid userBid = new UserBid();

    public String getError(){
        return this.error;
    }
    public void setError(String value){
        this.error = value;
    }

    public UserBid getUserBid(){
        return this.userBid;
    }
    public void setUserBid(UserBid value){
        this.userBid = value;
    }
}
