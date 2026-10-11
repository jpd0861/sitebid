package com.stronghaul.sitebid.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stronghaul.sitebid.models.BulkCalculationRequest;

public class BulkCalculationServiceTest {

    @Autowired private BulkCalculationService bulkCalculationService;

    @BeforeEach 
    public void setUp() {
        bulkCalculationService = new BulkCalculationService();
    }

    @Test 
    public void calculateBulkReturnsCorrectCubicYards() {
        BulkCalculationRequest request = new BulkCalculationRequest();
        request.setLengthInFeet(23.0);
        request.setWidthInFeet(12.0);
        request.setDepthInInches(36.0);

        Double expectedCubicYards = (23.0 * 12.0 * (36.0 / 12)) / 27;
        Double actualCubicYards = bulkCalculationService.calculateBulk(request);

        assertEquals(expectedCubicYards, actualCubicYards, 0.01);
    }

}
