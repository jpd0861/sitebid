package com.stronghaul.sitebid.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserBid {
    private Long id;
    private UserCustomer userCustomer = new UserCustomer();
    private UserProfile userProfile = new UserProfile();
    private Address address = new Address();
    private BidStatus bidStatus = new BidStatus();
    private ArrayList<UserBidLineItem> userBidLineItems = new ArrayList<UserBidLineItem>();
    private ArrayList<UserBidLineItemCrew> userBidLineItemCrews = new ArrayList<UserBidLineItemCrew>();
    private ArrayList<UserBidLineItemSupplier> userBidLineItemSuppliers = new ArrayList<UserBidLineItemSupplier>();
    private String scopeOfWork;
    private double profitPercentageOverride;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime dateOfBid;
    private StrongHaulSettings strongHaulSettings = new StrongHaulSettings();

    // Getters and Setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public UserCustomer getUserCustomer() {
        return this.userCustomer;
    }
    public void setUserCustomer(UserCustomer value) {
        this.userCustomer = value;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }
    public void setUserProfile(UserProfile value) {
        this.userProfile = value;
    }

    public Address getAddress() {
        return this.address;
    }
    public void setAddress(Address value) {
        this.address = value;
    }

    public BidStatus getBidStatus() {
        return this.bidStatus;
    }
    public void setBidStatus(BidStatus value) {
        this.bidStatus = value;
    }

    public ArrayList<UserBidLineItem> getUserBidLineItems() {
        return this.userBidLineItems;
    }

    public ArrayList<UserBidLineItemCrew> getUserBidLineItemCrews() {
        return this.userBidLineItemCrews;
    }

    public void setUserBidLineItemCrews(ArrayList<UserBidLineItemCrew> value) {
        this.userBidLineItemCrews = value;
    }

    public void setUserBidLineItems(ArrayList<UserBidLineItem> value) {
        this.userBidLineItems = value;
    }

    public ArrayList<UserBidLineItemSupplier> getUserBidLineItemSuppliers() {
        return this.userBidLineItemSuppliers;
    }

    public void setUserBidLineItemSuppliers(ArrayList<UserBidLineItemSupplier> value) {
        this.userBidLineItemSuppliers = value;
    }

    public String getScopeOfWork() {
        return this.scopeOfWork;
    }
    public void setScopeOfWork(String value) {
        this.scopeOfWork = value;
    }

    public double getProfitPercentageOverride() {
        return this.profitPercentageOverride;
    }
    public void setProfitPercentageOverride(double value) {
        this.profitPercentageOverride = value;
    }

    public LocalDateTime getDateOfBid() {
        return this.dateOfBid;
    }
    public void setDateOfBid(LocalDateTime value) {
        this.dateOfBid = value;
    }

    public StrongHaulSettings getStrongHaulSettings() {
        return this.strongHaulSettings;
    }

    public void setStrongHaulSettings(StrongHaulSettings value) {
        this.strongHaulSettings = value;
    }
}
