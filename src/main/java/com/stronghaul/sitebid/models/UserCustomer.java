package com.stronghaul.sitebid.models;

public class UserCustomer {
    private Long id;
    private Long userProfileId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address = new Address();

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }
    public void setUserProfileId(Long value) {
        this.userProfileId = value;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String value) {
        this.phone = value;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address value) {
        this.address = value;
    }
}
