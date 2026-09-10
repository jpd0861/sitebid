package com.stronghaul.sitebid.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service 
public class ValidateEmail {
    public static String ERROR_NULL_EMAIL = "The email is null or blank";
    public static String ERROR_INVALID_EMAIL = "The email is not a valid email";

    private String error;
    public String getError(){
        return this.error;
    }

    private final Pattern PATTERN = 
        Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public boolean isValid(String value) {
        this.error = "";
        if (value == null){
            this.error = ERROR_NULL_EMAIL;
            return false;
        }
        
        if(!PATTERN.matcher(value).matches()){
            this.error = ERROR_INVALID_EMAIL;
            return false;
        }
        return true;
    }
}
