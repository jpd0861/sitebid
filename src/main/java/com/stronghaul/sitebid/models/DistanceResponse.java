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
	public void setOrigin(String value) {
		this.origin = value;
	}

	public String getDestination() {
		return destination;
	}
	public void setDestination(String value) {
		this.destination = value;
	}

	public double getDistanceMiles() {
		return distanceMiles;
	}
	public void setDistanceMiles(double value) {
		this.distanceMiles = value;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String value) {
		this.duration = value;
	}
}
