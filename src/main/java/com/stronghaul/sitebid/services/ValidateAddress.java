package com.stronghaul.sitebid.services;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.Address;

@Service 
public class ValidateAddress {
    public static String ERROR_NULL_ADDRESS = "The address is null or blank";
    public static String ERROR_INVALID_SREET = "The street address is null or blank";
    public static String ERROR_INVALID_ZIP = "The zip code is invalid";

    private String error;
    public String getError(){
        return this.error;
    }

    public boolean isValid(Address value) {
        this.error = "";
        if (value == null){
            this.error = ERROR_NULL_ADDRESS;
            return false;
        }

        String data = value.getStreet();
        if(data == null || data.trim().isBlank()){
            this.error = ERROR_INVALID_SREET;
            return false;
        }

        data = value.getZip();
        if(data == null || !data.matches("^d{5}$")){
            this.error = ERROR_INVALID_ZIP;
            return false;
        }
        return true;
    }

}
