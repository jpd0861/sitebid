package com.stronghaul.sitebid.models;

public class StrongHaulSettings {
    private Long id;
    private Double ratePerMile;
    private Double baseHookupFee;
    private Double techPlatformFee;
    private Double onlineTransactionFee;
    private Double onlineTransactionPercentage;
    private Double maxPayload;
    private String street;
    private String zip;
    private String localZipCodes;

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

    public Double getMaxPayload(){
        return this.maxPayload;
    }
    public void setMaxPayload(Double value){
        this.maxPayload = value;
    }

    public String getStreet(){
        return this.street;
    }
    public void setStreet(String value){
        this.street = value;
    }

    public String getZip(){
        return this.zip;
    }
    public void setZip(String value){
        this.zip = value;
    }

    public String getLocalZipCodes(){
        return this.localZipCodes;
    }
    public void setLocalZipCodes(String value){
        this.localZipCodes = value;
    }
}
