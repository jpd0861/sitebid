package com.stronghaul.sitebid.models;

public class Product {
    private Long id = 0L;
    private Long productCategoryId = 0L;
    private Double averageWeight = 0.0;
    private String description = "";

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Double getAverageWeight() {
        return averageWeight;
    }
    public void setAverageWeight(Double averageWeight) {
        this.averageWeight = averageWeight;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
