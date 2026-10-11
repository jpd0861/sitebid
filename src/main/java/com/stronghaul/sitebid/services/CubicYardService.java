package com.stronghaul.sitebid.services;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.configuration.TrailerConfig;
import com.stronghaul.sitebid.models.CubicYardRequest;

@Service
public class CubicYardService {
    private final TrailerConfig trailerConfig;

    public CubicYardService(TrailerConfig trailerConfig) {
        this.trailerConfig = trailerConfig;
    }

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
