package com.stronghaul.sitebid.services;

import com.stronghaul.sitebid.configuration.GeositeConfig;
import com.stronghaul.sitebid.models.DistanceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.JsonNode;

import java.util.Objects;

@Service
public class DistanceService {

	private final RestClient restClient;
	private final GeositeConfig geositeConfig;

	public DistanceService(RestClient.Builder restClientBuilder, GeositeConfig geositeConfig) {
		this.restClient = restClientBuilder.build();
		this.geositeConfig = geositeConfig;
	}

	public DistanceResponse getDistance(String origin, String destination) {
		JsonNode response = restClient.get()
			.uri(UriComponentsBuilder.fromUriString(geositeConfig.getUrl())
						.queryParam("origins", origin)
						.queryParam("destinations", destination)
						.queryParam("units", "imperial")
				.build()
				.toUri())
				.retrieve()
				.body(JsonNode.class);

		JsonNode element = Objects.requireNonNull(response, "Google geoservice returned an empty response")
				.path("rows").path(0).path("elements").path(0);
		if (!"OK".equals(element.path("status").asText())) {
			throw new IllegalStateException("Google geoservice returned an invalid route response");
		}

		return new DistanceResponse(
				origin,
				destination,
				element.path("distance").path("value").asDouble() / 1609.344,
				element.path("duration").path("text").asText());
	}
}
