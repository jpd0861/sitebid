package com.stronghaul.sitebid.services;

import com.stronghaul.sitebid.configuration.GeositeConfig;
import com.stronghaul.sitebid.models.DistanceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class DistanceServiceTest {

	private static final String ORIGIN = "552 28 Road, 81501";

	private RestClient.Builder restClientBuilder;
	private MockRestServiceServer server;
	private DistanceService distanceService;

	@BeforeEach
	public void setUp() {
		restClientBuilder = RestClient.builder();
		server = MockRestServiceServer.bindTo(restClientBuilder).build();

		GeositeConfig geositeConfig = new GeositeConfig();
		geositeConfig.setUrl("https://maps.googleapis.com/maps/api/distancematrix/json");
		distanceService = new DistanceService(restClientBuilder, geositeConfig);
	}

	@Test
	public void returnsDistanceAndDurationForI70BusinessLoop() {
		assertDistance("2860 I-70BL, 81501", 1.7, "3 mins", 1.7 * 1609.344);
	}

	@Test
	public void returnsDistanceAndDurationForSouth15thStreet() {
		assertDistance("800 S 15th Street, 81501", 3.6, "8 mins", 3.6 * 1609.344);
	}

	@Test
	public void returnsDistanceAndDurationForSouth15thStreet710() {
		assertDistance("710 S 15th Street, 81501", 3.3, "8 mins", 3.3 * 1609.344);
	}

	private void assertDistance(String destination, double expectedMiles, String expectedDuration,
			double distanceMeters) {
		server.expect(queryParam("origins", encodeQueryValue(ORIGIN)))
				.andExpect(queryParam("destinations", encodeQueryValue(destination)))
				.andExpect(queryParam("units", "imperial"))
				.andRespond(withSuccess("""
						{"rows":[{"elements":[{"status":"OK","distance":{"value":%s},"duration":{"text":"%s"}}]}]}
						""".formatted(distanceMeters, expectedDuration), org.springframework.http.MediaType.APPLICATION_JSON));

		DistanceResponse response = distanceService.getDistance(ORIGIN, destination);

		assertThat(response.getOrigin()).isEqualTo(ORIGIN);
		assertThat(response.getDestination()).isEqualTo(destination);
		assertThat(response.getDistanceMiles()).isCloseTo(expectedMiles,
				org.assertj.core.data.Offset.offset(0.001))
				.withFailMessage("Expected distance %.1f miles but was %.1f miles",
						expectedMiles, response.getDistanceMiles());
		assertThat(response.getDuration()).isEqualTo(expectedDuration);
		server.verify();
	}

	private String encodeQueryValue(String value) {
		return value.replace(" ", "%20");
	}
}