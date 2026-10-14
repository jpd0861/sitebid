package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.CubicYardRequest;
import com.stronghaul.sitebid.validate.CubicYardValidate;

@Service
public class CubicYardService {
    @Autowired private CubicYardValidate cubicYardValidate;
    
    private String error;
    public String getError() {
        return this.error;
    }

    public Double calculate(CubicYardRequest request) {
        this.error = "";
        if (!this.cubicYardValidate.isValidArea(request.getWidthInFeet(), request.getLengthInFeet(), request.getDepthInInches())) {
            this.error = cubicYardValidate.getError();
            return -1.0;
        }
        Double cubicYardsNeeded = (
            request.getLengthInFeet() * 
            request.getWidthInFeet() * 
            (request.getDepthInInches() / 12)) / 27;
        return cubicYardsNeeded;
    }

    public Double getMaxCubicYardsPerTrip(Double productWeight, Double maxPayload) {
        this.error = "";

        if (!cubicYardValidate.isValidWeight(productWeight, maxPayload)) {
            this.error = cubicYardValidate.getError();
            return -1.0;
        }
        return maxPayload / productWeight;
    }
}
