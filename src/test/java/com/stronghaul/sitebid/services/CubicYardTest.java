package com.stronghaul.sitebid.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stronghaul.sitebid.models.CubicYardRequest;

public class CubicYardTest {

    @Autowired private CubicYardService bulkCalculationService;

    @BeforeEach 
    public void setUp() {
        bulkCalculationService = new CubicYardService();
    }

    @Test 
    public void returnsCorrectCubicYards() {
        CubicYardRequest request = new CubicYardRequest();
        request.setLengthInFeet(23.0);
        request.setWidthInFeet(12.0);
        request.setDepthInInches(36.0);

        Double expectedCubicYards = (23.0 * 12.0 * (36.0 / 12)) / 27;
        Double actualCubicYards = bulkCalculationService.calculate(request);

        assertEquals(expectedCubicYards, actualCubicYards, 0.01);
    }

}
