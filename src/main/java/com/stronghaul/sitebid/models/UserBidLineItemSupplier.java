package com.stronghaul.sitebid.models;

public class UserBidLineItemSupplier {
    private Long id;
    private Long userBidId;
    private Long suppierInventoryCategoryId;
    private String description;
    private double amount;
    private double quantity;
    private double contractorDiscountPercentage;
    private boolean siteDelivery;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserBidId() {
        return userBidId;
    }

    public void setUserBidId(Long userBidId) {
        this.userBidId = userBidId;
    }

    public Long getSupplierInventoryCategoryId() {
        return suppierInventoryCategoryId;
    }

    public void setSupplierInventoryCategoryId(Long supplierInventoryCategoryId) {
        this.suppierInventoryCategoryId = supplierInventoryCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getContractorDiscountPercentage() {
        return contractorDiscountPercentage;
    }

    public void setContractorDiscountPercentage(double contractorDiscountPercentage) {
        this.contractorDiscountPercentage = contractorDiscountPercentage;
    }

    public boolean isSiteDelivery() {
        return siteDelivery;
    }

    public void setSiteDelivery(boolean siteDelivery) {
        this.siteDelivery = siteDelivery;
    }
}
