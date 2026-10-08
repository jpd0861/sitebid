package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.UserProfile;

@Service 
public class ValidateUserProfile {

    public static String ERROR_NULL_USER_PROFILE = "The user profile is null";
    public static String ERROR_NULL_COMPANY = "The user profile company is null";
    public static String ERROR_NULL_FIRST_NAME = "The user profile first name is null";
    public static String ERROR_NULL_LAST_NAME = "The user profile last name is null";
    public static String ERROR_INACTIVE_USER_PROFILE = "The user profile is inactive";

    private String error;
    public String getError(){
        return this.error;
    }

    @Autowired private ValidateEmail validateEmail;
    @Autowired private ValidatePhone validatePhone;

    public boolean isValid(UserProfile userProfile){
        this.error = "";
        if(userProfile == null){
            this.error = ERROR_NULL_USER_PROFILE;
            return false;
        }

        String value = userProfile.getCompany();
        if(value == null || value.trim().isBlank()){
            this.error = ERROR_NULL_COMPANY;
            return false;
        }

        value = userProfile.getFirstName();
        if(value == null || value.trim().isBlank()){
            this.error = ERROR_NULL_FIRST_NAME;
            return false;
        }

        value = userProfile.getLastName();
        if(value == null || value.trim().isBlank()){
            this.error = ERROR_NULL_LAST_NAME;
            return false;
        }

        if(!validateEmail.isValid(userProfile.getEmail())){
            this.error = validateEmail.getError() + " for the user profile";
            return false;
        }

        if(!validatePhone.isValid(userProfile.getPhone())){
            this.error = validatePhone.getError() + " for the user profile";
            return false;
        }

        return true;
    }

}
