package com.stronghaul.sitebid.validate;

import org.springframework.stereotype.Service;

@Service 
public class CubicYardValidate {
    private String error;
    public String getError() {
        return this.error;
    }

    public boolean isValidArea(Double widthInFeet, Double lengthInFeet, Double depthInInches){
        this.error = "";
        if(widthInFeet == null || widthInFeet <= 0){
            this.error = "The width of the area must be greater than 0.";
            return false;
        }
        if(lengthInFeet == null || lengthInFeet <= 0){
            this.error = "The length of the area must be greater than 0.";
            return false;
        }
        if(depthInInches == null || depthInInches <= 0){
            this.error = "The depth of the area must be greater than 0.";
            return false;
        }
        return true;
    }

    public boolean isValidWeight(Double productWeight, Double maxPayload){
        this.error = "";
        if(productWeight == null || productWeight <= 0){
            this.error = "The product weight must be greater than 0.";
            return false;
        }
        if(maxPayload == null || maxPayload <= 1){
            this.error = "The maximum payload must be greater than 1.";
            return false;
        }
        return true;
    }
}
