package com.stronghaul.sitebid.models;

public class DistanceResponse {

	private String origin;
	private String destination;
	private double distanceMiles;
	private String duration;

	public DistanceResponse() {
	}

	public DistanceResponse(String origin, String destination, double distanceMiles, String duration) {
		this.origin = origin;
		this.destination = destination;
		this.distanceMiles = distanceMiles;
		this.duration = duration;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getDistanceMiles() {
		return distanceMiles;
	}

	public void setDistanceMiles(double distanceMiles) {
		this.distanceMiles = distanceMiles;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
