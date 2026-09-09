package com.stronghaul.sitebid.models;

public class Supplier {
    private Long id = 0L;
    private String companyName = "";
    private String phone = "";
    private Address address = new Address();
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long value) {
        this.id = value;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String value) {
        this.phone = value;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address value) {
        this.address = value;
    }
}
