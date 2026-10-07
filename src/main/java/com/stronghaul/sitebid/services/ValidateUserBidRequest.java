package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.UserBidRequest;

@Service
public class ValidateUserBidRequest {

    public static String ERROR_NULL_REQUEST = "The user bid request is null";
    public static String ERROR_INVALID_PROFIT_PERCENTAGE = "The profit percentage in the user bid is less than zero";
    public static String ERROR_NULL_SCOPE_OF_WORK = "The scope of work in the user bid is null";

    public static String ERROR_UNABLE_TO_CREATE_BID = ", unable to create a user bid";

    private String error;
    public String getError(){
        return this.error;
    }

    @Autowired ValidateUserCustomer validateUserCustomer;
    @Autowired ValidateUserProfile validateUserProfile;
    @Autowired ValidateAddress validateAddress;

    private boolean userBidRequestIsValid(UserBidRequest request){
        if(request == null){
            this.error = ERROR_NULL_REQUEST + ERROR_UNABLE_TO_CREATE_BID;
            return false;
        }
        if(request.getProfitPercentage() < 0){
            this.error = ERROR_INVALID_PROFIT_PERCENTAGE + ERROR_UNABLE_TO_CREATE_BID;
            return false;
        }
        if(request.getScopeOfWork() == null || request.getScopeOfWork().trim().isBlank()){
            this.error = ERROR_NULL_SCOPE_OF_WORK + ERROR_UNABLE_TO_CREATE_BID;
            return false;
        }
        return true;
    }

    public boolean isValid(UserBidRequest request){
        this.error = "";
        if(!userBidRequestIsValid(request)){
            return false;
        }
        if(!this.validateUserCustomer.isValid(request.getUserCustomer())){
            this.error = this.validateUserCustomer.getError() + ERROR_UNABLE_TO_CREATE_BID;
            return false;
        }
        if(!this.validateUserProfile.isValid(request.getUserProfile())){
            this.error = this.validateUserProfile.getError() + ERROR_UNABLE_TO_CREATE_BID;
            return false;
        }
        if(!this.validateAddress.isValid(request.getSiteAddress())){
            this.error = validateAddress.getError() + ERROR_UNABLE_TO_CREATE_BID;

        }
        return true;
    }
}
