package com.stronghaul.sitebid.services;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.BulkCalculationRequest;

@Service 
public class BulkCalculationService {

    public Double calculateBulk(BulkCalculationRequest request) {
        Double cubicYardsNeeded = (
            request.getLengthInFeet() * 
            request.getWidthInFeet() * 
            (request.getDepthInInches() / 12)) / 27;
        return cubicYardsNeeded;
    }
}
