package com.stronghaul.sitebid.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
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
    private BigDecimal profitPercentageOverride;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private LocalDateTime dateOfBid;
    private StrongHaulSettings strongHaulSettings = new StrongHaulSettings();

    // Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserCustomer getUserCustomer() {
        return this.userCustomer;
    }

    public void setUserCustomer(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BidStatus getBidStatus() {
        return this.bidStatus;
    }

    public void setBidStatus(BidStatus bidStatus) {
        this.bidStatus = bidStatus;
    }

    public ArrayList<UserBidLineItem> getUserBidLineItems() {
        return this.userBidLineItems;
    }

    public ArrayList<UserBidLineItemCrew> getUserBidLineItemCrews() {
        return this.userBidLineItemCrews;
    }

    public void setUserBidLineItemCrews(ArrayList<UserBidLineItemCrew> userBidLineItemCrews) {
        this.userBidLineItemCrews = userBidLineItemCrews;
    }

    public void setUserBidLineItems(ArrayList<UserBidLineItem> userBidLineItems) {
        this.userBidLineItems = userBidLineItems;
    }

    public ArrayList<UserBidLineItemSupplier> getUserBidLineItemSuppliers() {
        return this.userBidLineItemSuppliers;
    }

    public void setUserBidLineItemSuppliers(ArrayList<UserBidLineItemSupplier> userBidLineItemSuppliers) {
        this.userBidLineItemSuppliers = userBidLineItemSuppliers;
    }

    public String getScopeOfWork() {
        return this.scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public BigDecimal getProfitPercentageOverride() {
        return this.profitPercentageOverride;
    }

    public void setProfitPercentageOverride(BigDecimal profitPercentageOverride) {
        this.profitPercentageOverride = profitPercentageOverride;
    }

    public LocalDateTime getDateOfBid() {
        return this.dateOfBid;
    }

    public void setDateOfBid(LocalDateTime dateOfBid) {
        this.dateOfBid = dateOfBid;
    }

    public StrongHaulSettings getStrongHaulSettings() {
        return this.strongHaulSettings;
    }

    public void setStrongHaulSettings(StrongHaulSettings strongHaulSettings) {
        this.strongHaulSettings = strongHaulSettings;
    }
}
