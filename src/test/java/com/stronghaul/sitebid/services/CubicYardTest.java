package com.stronghaul.sitebid.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.stronghaul.sitebid.models.CubicYardRequest;
import com.stronghaul.sitebid.validate.CubicYardValidate;

public class CubicYardTest {

    private CubicYardService cubicYardService;

    @BeforeEach
    public void setUp() {
        cubicYardService = new CubicYardService();
        ReflectionTestUtils.setField(cubicYardService, "cubicYardValidate", new CubicYardValidate());
    }

    @Test
    public void returnsCorrectCubicYards() {
        CubicYardRequest request = new CubicYardRequest();
        request.setLengthInFeet(23.0);
        request.setWidthInFeet(12.0);
        request.setDepthInInches(36.0);

        Double expectedCubicYards = (23.0 * 12.0 * (36.0 / 12)) / 27;
        Double actualCubicYards = cubicYardService.calculate(request);

        assertEquals(expectedCubicYards, actualCubicYards, 0.01);
    }

    @Test
    public void returnsCorrectMaxCubicYardsPerTrip() {
        Double productWeight = 2700.0;
        Double expectedMaxCubicYardsPerTrip = (9500.0 / productWeight);
        Double actualMaxCubicYardsPerTrip = cubicYardService.getMaxCubicYardsPerTrip(productWeight, 9500.0);
        assertEquals(expectedMaxCubicYardsPerTrip, actualMaxCubicYardsPerTrip, 0.01);
    }
}
