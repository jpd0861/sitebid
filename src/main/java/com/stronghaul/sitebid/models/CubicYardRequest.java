package com.stronghaul.sitebid.models;

public class CubicYardRequest {
    private Double lengthInFeet;
    private Double widthInFeet;
    private Double depthInInches;
    
    public Double getLengthInFeet() {
        return lengthInFeet;
    }
    public void setLengthInFeet(Double lengthInFeet) {
        this.lengthInFeet = lengthInFeet;
    }

    public Double getWidthInFeet() {
        return widthInFeet;
    }
    public void setWidthInFeet(Double widthInFeet) {
        this.widthInFeet = widthInFeet;
    }

    public Double getDepthInInches() {
        return depthInInches;
    }
    public void setDepthInInches(Double depthInInches) {
        this.depthInInches = depthInInches;
    }
}
