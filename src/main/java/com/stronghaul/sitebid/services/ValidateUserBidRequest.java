package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.UserBidRequest;

@Service
public class ValidateUserBidRequest {

    public static String ERROR_NULL_REQUEST = "The user bid request is null";
    public static String ERROR_NULL_USER_PROFILE = "The user profile in the user bid is null";
    public static String ERROR_NULL_SITE_ADDRESS = "The address of the user bid is null";
    public static String ERROR_INVALID_PROFIT_PERCENTAGE = "The profit percentage in the user bid is less than zero";
    public static String ERROR_NULL_SCOPE_OF_WORK = "The scope of work in the user bid is null";

    private String error;
    public String getError(){
        return this.error;
    }

    @Autowired ValidateUserCustomer validateUserCustomer;

    public boolean isValid(UserBidRequest request){
        this.error = "";
        if(!userBidRequestIsValid(request)){
            return false;
        }
        if(!this.validateUserCustomer.isValid(request.getUserCustomer())){
            this.error = this.validateUserCustomer.getError();
            return false;
        }
        return true;
    }

    private boolean userBidRequestIsValid(UserBidRequest request){
        if(request == null){
            this.error = ERROR_NULL_REQUEST;
            return false;
        }
        
        if(request.getUserProfile() == null){
            this.error = ERROR_NULL_USER_PROFILE;
            return false;
        }
        if(request.getSiteAddress() == null){
            this.error = ERROR_NULL_SITE_ADDRESS;
            return false;
        }
        if(request.getProfitPercentage() < 0){
            this.error = ERROR_INVALID_PROFIT_PERCENTAGE;
            return false;
        }
        if(request.getScopeOfWork() == null || request.getScopeOfWork().trim().isBlank()){
            this.error = ERROR_NULL_SCOPE_OF_WORK;
            return false;
        }
        return true;
    }

}
