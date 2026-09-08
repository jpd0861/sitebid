package com.stronghaul.sitebid.models;

import java.math.BigDecimal;

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
    public void setId(Long id) {
        this.id = id;
    }

    public Double getRatePerMile() {
        return ratePerMile;
    }

    public void setRatePerMile(Double ratePerMile) {
        this.ratePerMile = ratePerMile;
    }

    public Double getBaseHookupFee() {
        return baseHookupFee;
    }

    public void setBaseHookupFee(Double baseHookupFee) {
        this.baseHookupFee = baseHookupFee;
    }

    public Double getTechPlatformFee() {
        return techPlatformFee;
    }

    public void setTechPlatformFee(Double techPlatformFee) {
        this.techPlatformFee = techPlatformFee;
    }

    public Double getOnlineTransactionFee() {
        return onlineTransactionFee;
    }

    public void setOnlineTransactionFee(Double onlineTransactionFee) {
        this.onlineTransactionFee = onlineTransactionFee;
    }

    public Double getOnlineTransactionPercentage() {
        return onlineTransactionPercentage;
    }

    public void setOnlineTransactionPercentage(Double onlineTransactionPercentage) {
        this.onlineTransactionPercentage = onlineTransactionPercentage;
    }
}
