package com.stronghaul.sitebid.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service 
public class ValidatePhone {

    public static String ERROR_NULL_PHONE = "The phone number is null or blank";
    public static String ERROR_INVALID_PHONE = "The phone number is not valid";

    private String error;
    public String getError(){
        return this.error;
    }

    private final Pattern PATTERN = 
        Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

    public boolean isValid(String value){
        if(value == null){
            this.error = ERROR_NULL_PHONE;
            return false;
        }
        if(!PATTERN.matcher(value).matches()){
            this.error = ERROR_INVALID_PHONE;
            return false;
        }
        return true;

    }

}
