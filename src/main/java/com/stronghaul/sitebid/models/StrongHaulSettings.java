package com.stronghaul.sitebid.models;

public class StrongHaulSettings {
    private Long id;
    private Double ratePerMile;
    private Double baseHookupFee;
    private Double techPlatformFee;
    private Double onlineTransactionFee;
    private Double onlineTransactionPercentage;

    // Getters and Setters
    public Long getId() {
        return id; 
    }
    public void setId(Long value) {
        this.id = value;
    }

    public Double getRatePerMile() {
        return ratePerMile;
    }
    public void setRatePerMile(double value) {
        this.ratePerMile = value;
    }

    public Double getBaseHookupFee() {
        return baseHookupFee;
    }
    public void setBaseHookupFee(double value) {
        this.baseHookupFee = value;
    }

    public Double getTechPlatformFee() {
        return techPlatformFee;
    }
    public void setTechPlatformFee(double value) {
        this.techPlatformFee = value;
    }

    public Double getOnlineTransactionFee() {
        return onlineTransactionFee;
    }
    public void setOnlineTransactionFee(double value) {
        this.onlineTransactionFee = value;
    }

    public Double getOnlineTransactionPercentage() {
        return onlineTransactionPercentage;
    }
    public void setOnlineTransactionPercentage(double value) {
        this.onlineTransactionPercentage = value;
    }
}
