package com.stronghaul.sitebid.services;

import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.CubicYardRequest;

@Service 
public class CubicYardService {

    public Double calculate(CubicYardRequest request) {
        Double cubicYardsNeeded = (
            request.getLengthInFeet() * 
            request.getWidthInFeet() * 
            (request.getDepthInInches() / 12)) / 27;
        return cubicYardsNeeded;
    }
}
