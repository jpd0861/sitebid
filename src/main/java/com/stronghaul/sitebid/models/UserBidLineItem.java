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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserBidId() {
        return userBidId;
    }

    public void setUserBidId(Long userBidId) {
        this.userBidId = userBidId;
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

    public LineItemCategory getLineItemCategory() {
        return lineItemCategory;
    }

    public void setLineItemCategory(LineItemCategory lineItemCategory) {
        this.lineItemCategory = lineItemCategory;
    }
}
