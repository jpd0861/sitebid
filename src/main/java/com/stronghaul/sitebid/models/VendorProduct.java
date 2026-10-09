package com.stronghaul.sitebid.models;

public class VendorProduct {
    private Long id;
    private Long vendorId;
    private Long productId;
    private Double retail;
    private Double discountPercentage;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getRetail() {
        return retail;
    }
    public void setRetail(Double retail) {
        this.retail = retail;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
