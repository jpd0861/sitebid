package com.stronghaul.sitebid.models;

public class UserBidLineItemSupplier {
    private Long id;
    private Long userBidId;
    private String description;
    private double amount;
    private double quantity;
    private double contractorDiscountPercentage;
    private boolean siteDelivery;
    private InventoryItem supplier = new InventoryItem();

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public Long getUserBidId() {
        return userBidId;
    }
    public void setUserBidId(Long value) {
        this.userBidId = value;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double value) {
        this.amount = value;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double value) {
        this.quantity = value;
    }

    public double getContractorDiscountPercentage() {
        return contractorDiscountPercentage;
    }
    public void setContractorDiscountPercentage(double value) {
        this.contractorDiscountPercentage = value;
    }

    public boolean isSiteDelivery() {
        return siteDelivery;
    }
    public void setSiteDelivery(boolean value) {
        this.siteDelivery = value;
    }

    public InventoryItem getSupplier(){
        return this.supplier;
    }
    public void setSupplier(InventoryItem value){
        this.supplier = value;
    }
}
