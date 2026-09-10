package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.UserCustomer;

@Service 
public class ValidateUserCustomer {

    public static String ERROR_NULL_CUSTOMER = "The customer is null";
    public static String ERROR_NULL_CUSTOMER_FIRST_NAME = "The customer's first name is null";
    public static String ERROR_NULL_CUSTOMER_LAST_NAME = "The customer's last name is null";
    public static String ERROR_NULL_CUSTOMER_USER_PROFILE_ID = "The customer's user profile id is null";

    private String error;
    public String getError(){
        return this.error;
    }

    @Autowired private ValidateEmail validateEmail;    
    @Autowired private ValidatePhone validatePhone;  
    @Autowired private ValidateAddress validateAddress;

    public boolean isValid(UserCustomer uc){
        this.error = "";

        if(uc == null){
            this.error = ERROR_NULL_CUSTOMER;
            return false;
        }

        if(uc.getUserProfileId() < 1){
            this.error = ERROR_NULL_CUSTOMER_USER_PROFILE_ID;
            return false;
        }

        String value = uc.getFirstName();
        if(value == null || value.trim().isBlank()){
            this.error = ERROR_NULL_CUSTOMER_FIRST_NAME;
            return false;
        }

        value = uc.getLastName();
        if(value == null || value.trim().isBlank()){
            this.error = ERROR_NULL_CUSTOMER_LAST_NAME;
            return false;
        }

        value = uc.getEmail();
        if(!validateEmail.isValid(value)){
            this.error = validateEmail.getError() + " for the customer";
            return false;
        }
        
        value = uc.getPhone();
        if(!validatePhone.isValid(value)){
            this.error = validatePhone.getError() + " for the customer";
            return false;
        }

        if(!validateAddress.isValid(uc.getAddress())){
            this.error = validateAddress.getError() + " for the customer";
            return false;
        }
        return true;
    }
}
