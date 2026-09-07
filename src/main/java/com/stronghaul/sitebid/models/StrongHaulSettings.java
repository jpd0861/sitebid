package com.stronghaul.sitebid.models;

import java.math.BigDecimal;

public class StrongHaulSettings {
    private Long id;
    private BigDecimal ratePerMile;
    private BigDecimal baseHookupFee;
    private BigDecimal techPlatformFee;
    private BigDecimal onlineTransactionFee;
    private BigDecimal onlineTransactionPercentage;

    // Getters and Setters
    public Long getId() {
        return id; 
    }
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRatePerMile() {
        return ratePerMile;
    }

    public void setRatePerMile(BigDecimal ratePerMile) {
        this.ratePerMile = ratePerMile;
    }

    public BigDecimal getBaseHookupFee() {
        return baseHookupFee;
    }

    public void setBaseHookupFee(BigDecimal baseHookupFee) {
        this.baseHookupFee = baseHookupFee;
    }

    public BigDecimal getTechPlatformFee() {
        return techPlatformFee;
    }

    public void setTechPlatformFee(BigDecimal techPlatformFee) {
        this.techPlatformFee = techPlatformFee;
    }

    public BigDecimal getOnlineTransactionFee() {
        return onlineTransactionFee;
    }

    public void setOnlineTransactionFee(BigDecimal onlineTransactionFee) {
        this.onlineTransactionFee = onlineTransactionFee;
    }

    public BigDecimal getOnlineTransactionPercentage() {
        return onlineTransactionPercentage;
    }

    public void setOnlineTransactionPercentage(BigDecimal onlineTransactionPercentage) {
        this.onlineTransactionPercentage = onlineTransactionPercentage;
    }
}
