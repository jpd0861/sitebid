package com.stronghaul.sitebid.models;

public class UserBidLineItem {
    private Long id;
    private Long userBidId;
    private String description;
    private double amount;
    private double quantity;
    private LineItemCategory lineItemCategory = new LineItemCategory();

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

    public LineItemCategory getLineItemCategory() {
        return lineItemCategory;
    }
    public void setLineItemCategory(LineItemCategory value) {
        this.lineItemCategory = value;
    }
}
