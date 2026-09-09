package com.stronghaul.sitebid.models;

public class Customer {
    private Long id = 0L;
    private Long userProfileId = 0L;
    private String firstName = "";
    private String lastName = "";
    private String phone = "";
    private String email = "";
    private Long addressId = 0L;

    // Getters and Setters
    public Long getId() {
        return this.id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public Long getUserProfileId() {
        return this.userProfileId;
    }
    public void setUserProfileId(Long value) {
        this.userProfileId = value;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String value) {
        this.phone = value;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public Long getAddressId() {
        return this.addressId;
    }
    public void setAddressId(Long value) {
        this.addressId = value;
    }
}
