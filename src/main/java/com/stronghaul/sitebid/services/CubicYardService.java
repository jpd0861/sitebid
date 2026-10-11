package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.configuration.TrailerConfig;
import com.stronghaul.sitebid.models.CubicYardRequest;

@Service
public class CubicYardService {
    @Autowired private TrailerConfig trailerConfig;

    public Double calculate(CubicYardRequest request) {
        Double cubicYardsNeeded = (
            request.getLengthInFeet() * 
            request.getWidthInFeet() * 
            (request.getDepthInInches() / 12)) / 27;
        return cubicYardsNeeded;
    }

    public Double getMaxCubicYardsPerTrip(Double productWeight) {
        return trailerConfig.getMaxPayload() / productWeight;
    }
}
