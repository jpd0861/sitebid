package com.stronghaul.sitebid.services;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.BulkCalculationRequest;
import com.stronghaul.sitebid.models.BulkCalculationResponse;

@Service 
public class BulkCalculationService {

    public BulkCalculationResponse calculateBulk(BulkCalculationRequest request) {
        BulkCalculationResponse response = new BulkCalculationResponse();
        Double cubicYardsNeeded = (
            request.getLengthInFeet() * 
            request.getWidthInFeet() * 
            (request.getDepthInInches() / 12)) / 27;
        response.setCubicYardsNeeded(cubicYardsNeeded);
        return response;
    }
}
